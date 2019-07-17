package ir.hajk1.zos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <the description of the class for java doc by those that might use it, please use html if possible>
 */
public class TestMd5 {

  public static void main(String[] args) throws IOException {
    if (args.length == 0) {
      System.out.println("plz input file name as parameter.");
      System.exit(1);
    }
    String fileName = args[0];
    File file = new File(fileName);
    System.out.println("file.getCanonicalPath() = " + file.getCanonicalPath());
    System.out.println("file.exist = " + file.exists());
    FileInputStream fileInputStream = null;
    try {
      fileInputStream = new FileInputStream(fileName);
      // md5Hex converts an array of bytes into an array of characters representing the hexadecimal values of each byte in order.
      // The returned array will be double the length of the passed array, as it takes two characters to represent any given byte.
      String result = DigestUtils.md5Hex(IOUtils.toByteArray(fileInputStream));
      fileInputStream.close();
      System.out.println("md5 result is :" + result);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        fileInputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }


  }

}
