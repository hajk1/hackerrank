package ir.hajk1.hackerrank;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.stream.IntStream;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 11/21/2019, Thu
 **/
public class EbcdicConvertor {
    private static final char[] toUniCode = {
            '\u0635', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', '\u0635', '\u0636', '\u0636', '\u0637', '\u0638', '\u0639',
            '\u0639', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', '\u0639', '\u0639', '\u063a', '\u063a', '\u063a', '\u063a',
            '\u0641', '~', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '\u0641', '\u0642', '\u0642', '\u06a9', '\u06a9', '\u06af',
            '\u06af', '\u0644', '\u0644', '\u0645', '\u0645', '\u0646', '\u0646', '\u0648', '\u0647', '\u0647', '[', ']', '\u0647', '\u064a', '\u064a', '.',
            '{', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', '.', '\u064a', '0', '.', '.', '.',
            '}', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', '1', '2', '3', '.', '.', '.',
            '\\', '.', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '4', '5', '6', '.', '.', '.',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '7', '8', '9', '.', '.', '.',
            ' ', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',
            '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',
            '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',
            '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',
            ' ', '.', ',', '-', '\u0622', '\u0627', '\u0627', '.', '\u0621', '\u0621', '[', '.', '<', '(', '+', '|',
            '&', '\u0626', '\u0628', '\u0628', '\u067e', '\u067e', '\u062a', '\u062a', '\u062b', '\u062b', '!', '$', '*', ')', ';', '^',
            '-', '/', '\u062c', '\u062c', '\u0686', '\u0686', '\u062d', '\u062d', '\u062e', '\u062e', '|', ',', '%', '_', '>', '?',
            '\u062f', '\u0630', '\u0631', '\u0632', '\u0698', '\u0633', '\u0633', '\u0634', '\u0634', '`', ':', '#', '@', '\'', '=', '"'};


    public static String ConvertToUnicode(byte[] b) {
        char[] res = new char[b.length];
        for (int i = 0; i < b.length; i++) {
            res[i] = toUniCode[128 + b[i]];
        }
        return String.copyValueOf(res);
    }

    public static String ConvertToUnicode2(byte[] b) {
        return String.valueOf(IntStream.range(0, b.length).limit(b.length).parallel()
                .mapToObj(i -> new StringBuilder(toUniCode[128 + b[i]]))
                .reduce(new StringBuilder(""), (s1, s2) -> s1.append(s2)));

    }

    public static String ConvertToUnicode3(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        s.codePoints().parallel().mapToObj(i -> toUniCode[128 + (char) i]).forEach(sb::appendCodePoint);
        return sb.toString();
    }

    public static void main(String[] args) {
        String data = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz" +
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        Date fromDate = new Date();
        for (int i = 0; i < 50000000; i++) {
            // ConvertToUnicode(data.getBytes());//PT39.4S
            ConvertToUnicode3(data);//PT39.4S

        }
        System.out.println(Duration.between(                   // Calculate the span of time between two moments as a number of hours, minutes, and seconds.
                fromDate.toInstant(),    // Convert legacy class to modern class by calling new method added to the old class.
                Instant.now()                   // Capture the current moment in UTC. About two and a half hours later in this example.
        ));
    }
}
