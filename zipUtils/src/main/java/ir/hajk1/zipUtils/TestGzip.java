package ir.hajk1.zipUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <the description of the class for java doc by those that might use it, please use html if possible>
 */
public class TestGzip {

  public static void main(String[] args) throws IOException {
    TestGzip testGzip = new TestGzip();
    if (args.length == 0) {
      System.out.println("plz input file name for gzip as parameter.");
      System.exit(1);
    }
    String fileName = args[0];
    File file = new File(fileName);
    System.out.println("file.getCanonicalPath() = " + file.getCanonicalPath());
    System.out.println("file.exist = " + file.exists());
    testGzip.gzipIt(file.getCanonicalPath());
  }

  public void gzipIt(String sourcePath) {

    byte[] buffer = new byte[1024];

    try {

      GZIPOutputStream gzos =
          new GZIPOutputStream(new FileOutputStream(sourcePath + ".gz"));

      FileInputStream in =
          new FileInputStream(sourcePath);

      int len;
      while ((len = in.read(buffer)) > 0) {
        gzos.write(buffer, 0, len);
      }

      in.close();

      gzos.finish();
      gzos.close();

      System.out.println("Done");

    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
