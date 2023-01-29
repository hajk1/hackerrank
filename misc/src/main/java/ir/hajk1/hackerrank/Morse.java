package ir.hajk1.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class Morse {
    /*
   INPUT: "----"
   EXPECTED OUTPUT: "--..",".--.","..--"
     */
    public static final String pattern = "..";
    String replace = "--";

    /*
    Does not work because regex will not contain the first match
     */
//    List<String> solution(String str) {
//        List<String> result = new ArrayList<>();
//        Pattern pattern = Pattern.compile("..");
//        Matcher matcher = pattern.matcher(str);
//        while (matcher.find()) {
//            int start = matcher.start(), end = matcher.end();
//            System.out.print("Start index: " + start);
//            System.out.print(" End index: " + end);
//            StringBuilder builder = new StringBuilder();
//            builder.append(str.substring(0, start) + replace + str.substring(end, str.length()));
//            System.out.println(" = " + builder.toString());
//            System.out.println(matcher.group());
//        }
//        return result;
//    }

    public static void main(String[] args) {
        Morse morse = new Morse();
        String input = "....";
        List<String> result = morse.solution2(input);
        result.forEach(System.out::println);
    }

    List<String> solution2(String str) {
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index != str.length() - 1) {
            StringBuilder builder = new StringBuilder();
            int start = str.indexOf(pattern, index);
            builder.append(str, 0, start).append(replace).append(str.substring(start + 2));
            result.add(builder.toString());
            index++;
        }
        return result;
    }


}
