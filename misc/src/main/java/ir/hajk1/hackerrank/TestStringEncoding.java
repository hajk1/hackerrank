package main.java.ir.hajk1.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <the description of the class for java doc by those that might use it, please use html if possible>
 */
public class TestStringEncoding {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader;
    FileInputStream is = new FileInputStream("/opt/apache/apache-tomcat-7.0.90/temp/V-980221-02-1");
    InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
    bufferedReader = new BufferedReader(isr);
    String line = bufferedReader.readLine();
    Writer out = new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream(
            "/tmp/result.txt"), StandardCharsets.US_ASCII));
    while (line != null) {
      System.out.println("line = " + line);
      out.write(line);
      out.write("\n");
      line = bufferedReader.readLine();
    }
    bufferedReader.close();
    out.close();
  }

}
