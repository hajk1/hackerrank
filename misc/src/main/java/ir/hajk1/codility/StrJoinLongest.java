package ir.hajk1.codility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StrJoinLongest {

    public static void main(String[] args) {
        var p2 = new StrJoinLongest();
//        System.out.println("p2 = " + p2.solution(5,0,2));
//        System.out.println("p2 = " + p2.solution(5,5,3));
//        System.out.println("p2 = " + p2.solution(1,2,1));
//        System.out.println("p2 = " + p2.solution(0,2,0));
//        System.out.println("p2 = " + p2.solution(0,0,10));
        System.out.println("p2 = " + p2.solution(2, 5, 10));
//        p2 = AABBAABBAA
//        p2 = AABBABAB
//        p2 = ABAB
//        p2 = BB
//        p2 = AABBAABBABABABABAB
//        p2 = BBABABABABABAABBAABB

    }

    public String solution(int AA, int AB, int BB) {
        // Implement your solution here
        Map<String, List<String>> map = new HashMap<>();
        map.put("AA", Stream.generate(() -> "AA").limit(AA).collect(Collectors.toList()));
        map.put("AB", Stream.generate(() -> "AB").limit(AB).collect(Collectors.toList()));
        map.put("BB", Stream.generate(() -> "BB").limit(BB).collect(Collectors.toList()));
        String result1 = checkCondition(clone(map), "AA");
        String result2 = checkCondition(clone(map), "AB");
        String result3 = checkCondition(clone(map), "BB");
        String finalStr = result1.length() > result2.length() ? result1 : result2;
        finalStr = finalStr.length() > result3.length() ? finalStr : result3;
        return finalStr;
    }

    private String checkCondition(Map<String, List<String>> map, String start) {
        String result = "";
        if (start.equals("AA") && map.get("AA").size() == 0) {
            return "";
        }
        if (start.equals("AB") && map.get("AB").size() == 0) {
            return "";
        }
        if (start.equals("BB") && map.get("BB").size() == 0) {
            return "";
        }

        result += map.get(start).get(0);
        map.get(start).remove(0);
        while ((!result.contains("AAA") || !result.contains("BBB"))) {
            if (result.endsWith("AA")) {
                if (map.get("BB").size() == 0) {
                    break;
                }
                result += map.get("BB").get(0);
                map.get("BB").remove(0);
            } else if (result.endsWith("BB")) {
                String tmp1 = checkCondition(clone(map), "AA");
                String tmp2 = checkCondition(clone(map), "AB");
                result += tmp1.length() > tmp2.length() ? tmp1 : tmp2;
                break;
            } else if (result.endsWith("AB")) {
                String tmp1 = checkCondition(clone(map), "AA");
                String tmp2 = checkCondition(clone(map), "AB");
                result += tmp1.length() > tmp2.length() ? tmp1 : tmp2;
                break;
            }
        }
        return result;
    }

    private Map<String, List<String>> clone(Map<String, List<String>> map) {
        return map.entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, e -> new ArrayList<>(e.getValue())));
    }
}
