package ir.hajk1.daily;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class AsciMatcher {

    public static void main(String[] args) throws IOException, URISyntaxException {
        String str = "موسسات (انتفاعي/ غير انتفاعي)- انجمن ها قرض الحسنه ابرار خميني شه\n";
        System.out.println("str.getBytes(StandardCharsets.UTF_8).length = " + str.getBytes(StandardCharsets.UTF_8).length);
        String str2 = "موسسه\u200C\u200Cغیرتجاری\u200C\u200Cانتفا\u200Cعی\u200Cگل\u200C\u200Cهای\u200C موسسه\u200C\u200Cغیرتجاری\u200C\u200Cانتفا\u200Cعی\u200Cگل\u200C\u200Cهای\u200C";
        System.out.println("str2.getBytes(StandardCharsets.UTF_8).length = " + str2.getBytes(StandardCharsets.UTF_8).length);
        System.out.println("str3.getBytes(StandardCharsets.UTF_8).length = " + StringCleaner.cleanAndTrimTo140Bytes(str2).getBytes(StandardCharsets.UTF_8).length);
        if (str2.getBytes(StandardCharsets.UTF_8).length >= 140) {
            str2 = StringCleaner.cleanAndTrimTo140Bytes(str2);
        }
        System.out.println("str2.length = " + str2.length());
        AsciMatcher as = new AsciMatcher();
        as.myMethod();
    }

    private static void process(String line) {
        String patternStr = "[\\\\000]*";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(line);

        if (matcher.matches()) {
            System.out.println("lookingAt = " + matcher.lookingAt());
            System.out.println("matches   = " + matcher.matches());

        }
//if(line.contains("<code>") && ! line.contains("AG02"))
//        System.out.println("line = " + line);
//
    }

    void myMethod() throws URISyntaxException, IOException {
        try (Stream<String> lines = Files.lines(Paths.get(getClass().getClassLoader().getResource("lnar.xml").toURI()), Charset.forName("UTF-8"))) {
            lines.forEachOrdered(line -> process(line));
        }

    }

}
