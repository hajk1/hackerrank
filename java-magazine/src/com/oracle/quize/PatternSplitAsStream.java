package com.oracle.quize;

import java.util.Arrays;
import java.util.regex.Pattern;

public class PatternSplitAsStream {
    static final Pattern PIPE_SPLITTER = Pattern.compile("\\|");

    public static void main(String[] args) {
        System.out.print(doIt("12|11|30"));
    }

    static public int doIt(String s) {
        var a = PIPE_SPLITTER.splitAsStream(s)
                .mapToInt(Integer::valueOf)
                .mapToObj(v -> new Integer[]{v % 3 == 0 ? 1 : 0, v % 5 == 0 ? 2 : 0, v})
                .reduce(new Integer[]{0, 0, 0}, (i, is) -> new Integer[]{i[0] + is[0], i[1] + is[1], i[2] + is[2]});
        return Arrays.stream(a).mapToInt(Integer::intValue).sum();
    }
}
