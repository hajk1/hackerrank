import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <the description of the class for java doc by those that might use it, please use html if possible>
 */
public class TESTENC {

  public static void main(String[] args) throws IOException {
    String line = "سلام گژپچ ۱۲۳ UTF-8؟";
    writeToFile(line, "UTF-8", "utf8.txt");
    writeToFile(line, "", "def.txt");
    writeToFile(line, "Cp1256", "c1256.txt");
    writeToFile(line, "Cp1097", "c1097.txt");
    writeToFile(line, "ASCII", "asci.txt");
  }

  private static void writeToFile(String line, String encoding, String fileName)
      throws IOException {
    Writer out;
    System.out.println("encoding = " + encoding);
    if (encoding.length() == 0) {
      out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
    } else {
      out = new BufferedWriter(
          new OutputStreamWriter(new FileOutputStream(fileName), Charset.forName(encoding)));
    }
    out.write(line);
    out.write("\n");
    out.close();
  }
}
