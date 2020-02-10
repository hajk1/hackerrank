package ir.hajk1.hackerrank;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 11/29/2019, Fri
 **/
public class BtejReconcil {

  static String path = "/home/k1/Desktop/logs/btej/";
  static String class_forname = "oracle.jdbc.driver.OracleDriver";
  static String jdbc_url = "jdbc:oracle:thin:@10.10.15.181:1521:payadb";
  static String db_user = "ach";
  static String db_password = "ach01";
  static PreparedStatement statement;
  static Connection con;
  private static String sql = "SELECT * FROM TB_PAYMENT_ORDER po INNER JOIN TB_PAYMENT_ORDER_AGREEMENT poa ON po.PYOA_ID=poa.ID WHERE poa.REFERENCE_ID=? AND po.TRACKING_CODE=?";

  public static void main(String[] args) throws IOException, SQLException {
    long start1 = System.nanoTime();

    String saflog = path + "TBSAFLOGACH-ALL-change.txt";
    String cmPlus = path + "cm-plus.txt";
    PrintWriter pw = new PrintWriter(new FileWriter(cmPlus, true));
    AtomicLong counter = new AtomicLong(0);
    try (Stream<String> stream = Files.lines(Paths.get(saflog))) {
      stream.forEach(t -> {
        createConnection();
        boolean found = findInAch(t);
        //todo k1: search in paya db
        if (!found) {
          pw.println(t);
        } else {
          System.out.println("found = " + t);
        }
        try {
          con.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
        long time1 = System.nanoTime() - start1;
        System.out
            .printf("Took %.3f seconds to process %d%n", time1 / 1e9, counter.getAndIncrement());
      });
    } catch (IOException e) {
      e.printStackTrace();
    }
    pw.flush();
    pw.close();
    long time1 = System.nanoTime() - start1;
    System.out.printf("Took %.3f seconds to write to a  file rate%n", time1 / 1e9);
  }

  private static boolean findInAch(String t) {
    ResultSet rs;
    try {
      statement = con.prepareStatement(sql);
      statement.setString(1, "123");
      statement.setString(2, "321");
      rs = statement.executeQuery();
      if (rs.next()) {
        return true;
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return false;
  }

  private static void createConnection() {
    try {
      Class.forName(class_forname);
      con = DriverManager.getConnection(jdbc_url
          , db_user, db_password);
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
