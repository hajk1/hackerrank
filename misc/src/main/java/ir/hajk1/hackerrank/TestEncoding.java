package ir.hajk1.hackerrank;

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
public class TestEncoding {

  public static void main(String[] args) throws IOException {
    String line = "سلام دوست من خوبی؟";
    Writer out = new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream(
            "result.txt"), Charset.forName("UTF-8")));
    out.write(line);
    out.write("\n");
    out.close();
  }

}
