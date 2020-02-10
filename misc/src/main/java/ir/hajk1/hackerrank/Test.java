package ir.hajk1.hackerrank;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <the description of the class for java doc by those that might use it, please use html if possible>
 */
public class Test {

  public static void main(String[] args) {
    String line = "/OTHR/";
    System.out.println("line = " + line);

    String ourString = "Hello Istanbul";
    ourString.concat(" Go");
    String newString = (ourString.length() > 10) ? "long String" : "Ok";
    System.out.print(newString + ": " + ourString);
  }

}
