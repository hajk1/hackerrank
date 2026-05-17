package ir.hajk1.leetcode;

public class Sample {

    int MINUTES = 60;
    int HOURS = 60 * MINUTES;
    int DAYS = 24 * HOURS;
    int WEEKS = 7 * DAYS;

    public static void main(String[] args) {
        new Sample().solution(100);
        new Sample().solution(7263);
        new Sample().solution(3605);
        new Sample().solution(3600);
        new Sample().solution(86461);
        new Sample().solution(604800);
        new Sample().solution(691201);
    }

    public String solution(int x) {
        // Implement your solution here
        String first = "";
        first = getFirst(x);
        System.out.println("first = " + first);
        return "0";
    }

    private String getFirst(int x) {
        int weeks = x / WEEKS;
        x %= WEEKS;

        int days = x / DAYS;
        x %= DAYS;

        int hours = x / HOURS;
        x %= HOURS;

        int minutes = x / MINUTES;
        x %= MINUTES;

        int seconds = x;

        // Collect units in order
        int[] values = {weeks, days, hours, minutes, seconds};
        String[] units = {"w", "d", "h", "m", "s"};

        String result = "";
        int count = 0;

        for (int i = 0; i < 5; i++) {
            if (values[i] > 0) {
                // If this is our 2nd unit and there's still remainder, round up
                if (count == 1 && i < 4 && seconds > 0) {
                    result += (values[i] + 1) + units[i];
                    return result;
                }
                result += values[i] + units[i];
                count++;
                if (count == 2) {
                    break;
                }
            }
        }

        return result;
    }
}

