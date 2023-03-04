package ir.hajk1.codility;

public class StrReplace {

    public static void main(String[] args) {
        var p1 = new StrReplace();
        System.out.println("p1.solution() = " + p1.solution("CBACD"));
        System.out.println("p1.solution() = " + p1.solution("CABABD"));
        System.out.println("p1.solution() = " + p1.solution("ACBDACBD"));
    }

    public String solution(String S) {
        // Implement your solution here
        while (S.contains("BA") || S.contains("CD") || S.contains("AB") || S.contains("DC")) {
            S = S.replaceAll("BA", "")
                .replaceAll("CD", "")
                .replaceAll("AB", "")
                .replaceAll("DC", "");
        }
        return S;
    }
}
