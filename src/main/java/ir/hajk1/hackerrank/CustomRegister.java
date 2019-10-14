package ir.hajk1.hackerrank;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CustomRegister {
    HashMap<Integer, Integer> hashMap = new HashMap<>();

    void addAttendance(int[] a) {
        for (int i : a) {
            if (hashMap.containsKey(i)) {
                hashMap.put(i, hashMap.get(i) + 1);
            } else
                hashMap.put(i, 1);

        }
    }

    void changeAttendance(int id, char c) {
        switch (c) {
            case 'A':
                System.out.println("The attendance of student with id:{" + id + "} has been reduced by one");
                hashMap.put(id, hashMap.get(id) - 1);
                break;
            case 'P':
                System.out.println("The attendance of student with id:{" + id + "} has been increased by one");
                hashMap.put(id, hashMap.get(id) + 1);
                break;
        }
    }

    void reduceRegister(int limit) {
        System.out.println("Removing students with less attendance");
        Set<Integer> integerSet = hashMap.keySet();
        for (Integer integer : integerSet) {
            if (hashMap.get(integer) < limit)
                hashMap.remove(integer);
        }
    }

    void personalAttendance(int id) {
        if (hashMap.containsKey(id))
            System.out.println("The Attendance of the student with id:" + id + " is:" + hashMap.get(id));
        else
            System.out.println("The student with id:" + id + " has been removed due to low attendance");
    }

    int maxAttendance() {
        Integer keyWithHighestVal = null;

        int maxValueInMap = (Collections.max(hashMap.values()));

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {  // Iterate through hashmap
            if (entry.getValue() == maxValueInMap) {

                keyWithHighestVal = entry.getKey();     // this is the key which has the max value
            }

        }
        return keyWithHighestVal;
    }
}
