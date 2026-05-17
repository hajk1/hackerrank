package ir.hajk1.daily;

import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.regex.Pattern;

public class StringCleaner {

    private static final Pattern INVISIBLE_CHARS = Pattern.compile(
        "[\\p{Cntrl}" +
            "\\p{Cf}" +
            "\\p{Zl}\\p{Zp}" +
            "\\u200B-\\u200F" +
            "\\u202A-\\u202E" +
            "\\u2060-\\u206F" +
            "\\uFEFF]"
    );

    public static String cleanAndTrimTo140Bytes(String input) {
        if (input == null) {
            return null;
        }

        // Step 1: Normalize and remove invisible/control characters
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFKC);
        String cleaned = INVISIBLE_CHARS.matcher(normalized).replaceAll("");

        // Step 2: Ensure result fits within 140 bytes (UTF-8)
        byte[] utf8Bytes = cleaned.getBytes(StandardCharsets.UTF_8);
        if (utf8Bytes.length <= 140) {
            return cleaned;
        }

        // Step 3: Trim character-by-character to not break multi-byte sequences
        StringBuilder builder = new StringBuilder();
        int currentBytes = 0;
        for (int i = 0; i < cleaned.length(); i++) {
            String ch = cleaned.substring(i, i + 1);
            int byteLen = ch.getBytes(StandardCharsets.UTF_8).length;
            if (currentBytes + byteLen > 140) {
                break;
            }
            builder.append(ch);
            currentBytes += byteLen;
        }
        return builder.toString();
    }
}