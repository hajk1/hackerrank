package main.java.ir.hajk1.hackerrank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <the description of the class for java doc by those that might use it, please use html if possible>
 */
public class ArrayTest {

  public static void main(String[] args) throws FileNotFoundException {
    InputStream[] inputStreams = new InputStream[1];
    InputStream inputStream = inputStreams[0];
    inputStream = new FileInputStream("/tmp/hi.txt");
    System.out.println(inputStreams[0]);
    System.out.println(inputStream);
  }
}
