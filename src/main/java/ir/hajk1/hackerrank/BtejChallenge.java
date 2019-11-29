package ir.hajk1.hackerrank;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.stream.Stream;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 11/29/2019, Fri
 **/
public class BtejChallenge {
    public static void main(String[] args) throws IOException {
        long start1 = System.nanoTime();
        String batch = "C:\\shp\\batch_980908_cycle_01_details.shap_BTEJ_18.txt";
        String iban = "C:\\shp\\v_iban1.txt";
        String target = "C:\\shp\\target.txt";
        final HashMap<String, String> hashMap = new HashMap<>(1000, 1);
        PrintWriter pw = new PrintWriter(new FileWriter(target, true));
        try (Stream<String> ibnstream = Files.lines(Paths.get(iban))) {
            ibnstream.forEach(i -> {
                hashMap.put(i, i);
            });
        }

        try (Stream<String> stream = Files.lines(Paths.get(batch))) {
            stream.forEach(t -> {
                boolean found = false;
                for (String s : hashMap.keySet()) {
                    if (t.substring(73, 99).equals(s)) {
                        found = true;
                        break;
                    }
                }
                if (!found)
                    pw.println(t);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        pw.flush();
        pw.close();
        long time1 = System.nanoTime() - start1;
        System.out.printf("Took %.3f seconds to write to a  file rate%n", time1 / 1e9);
    }
}
