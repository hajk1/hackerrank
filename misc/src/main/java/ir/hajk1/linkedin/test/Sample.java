package ir.hajk1.linkedin.test;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 * <p>
 * Description: <the description of the class for java doc by those that might use it, please use html if possible>
 */
public class Sample {

    static String s;

    public static void main(String[] args) {
//    Horse horse = new Horse();
//    horse.run();
//    horse.run("Test");
//    horse.eat();
//    Animal animal = new Horse();
//    animal.run();
//    animal.run("");
//    animal.eat();
        Set<Horse> horseSet = new HashSet<>();
        Horse horse1 = new Horse("aaa");
        horseSet.add(horse1);
        Horse horse2 = new Horse("aaa");
        horseSet.add(horse2);
        System.out.println("horseSet.size() = " + horseSet.size());
        for (Horse horse : horseSet) {
            System.out.println("horse.getName() = " + horse.getName());
        }
        String s = "";


    }

    private static Exception hello() {
        return new Exception();
    }

}
