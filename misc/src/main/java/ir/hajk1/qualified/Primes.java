package ir.hajk1.qualified;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Primes {

    public static IntStream stream() {
        // TODO: make this stream endless
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        primes.add(3);
        return IntStream.iterate(2, x -> x + 1).
            filter(n -> {
                if (n == 2 || n == 3) {
                    return true;
                }
                if (n % 2 == 0) {
                    return false;
                }
                int limit = (int) Math.sqrt(n);
                for (Integer prime : primes) {
                    if (prime > limit) {
                        break;
                    }
                    if (n % prime == 0) {
                        return false;
                    }
                }
                primes.add(n);
                return true;
            });
    }
}
