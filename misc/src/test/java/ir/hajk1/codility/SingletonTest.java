package ir.hajk1.codility;

import ir.hajk1.daily.SingletonClass;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingletonTest {

    private static final int NUM_JOBS_TO_CREATE = 100000;

    @Test
    void testUsage() throws InterruptedException {
        for (int i = 0; i < 100000; i++) {
            final SingletonClass[] s = new SingletonClass[2];
            Runnable r1 = () -> {
                s[0] = SingletonClass.getInstance();
            };
            Runnable r2 = () -> {
                s[1] = SingletonClass.getInstance();
            };
            Thread t1 = new Thread(r1);
            Thread t2 = new Thread(r2);
            t2.start();
            t1.start();
            t1.join();
            t2.join();
            assertEquals(s[0].random, s[1].random);

        }
    }

    @Test
    void testUsage2() throws InterruptedException {

        final List<SingletonClass> s = new ArrayList<>();

        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        // submit jobs to be executing by the pool
        for (int i = 0; i < NUM_JOBS_TO_CREATE; i++) {
            threadPool.submit(() -> {
                // some code to run in parallel
                // this could also be another class that implements Runnable
                s.add(SingletonClass.getInstance());
            });
        }
        // once you've submitted your last job to the service it should be shut down
        threadPool.shutdown();
        // wait for the threads to finish if necessary
        threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        SingletonClass s1 = s.get(0);
        for (SingletonClass singletonClass : s) {
            assertEquals(s1, singletonClass);

        }


    }
}
