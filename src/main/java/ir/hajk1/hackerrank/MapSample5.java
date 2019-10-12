package ir.hajk1.hackerrank;

import java.util.*;

public class MapSample5 {
    public static final String EXIT = "exit", ADD = "add", GET = "get", EVICT = "evict", REMOVE = "remove";
    static Map<Object, Object> map = new LinkedHashMap<>();
    static Queue<Object> queue = new PriorityQueue<>();
    private static String errorStr = "-1 ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.next();
        while (!EXIT.equals(command)) {
            switch (command) {
                case ADD:
                    add(scanner);
                    break;
                case EVICT:
                    evict();
                    break;
                case GET:
                    get(scanner);
                    break;
                case REMOVE:
                    remove(scanner);
                    break;
            }
            command = scanner.next();
        }
    }

    private static void remove(Scanner scanner) {
        String key = scanner.next();
        Object o = map.get(key);
        if (o != null) {
            queue.remove(key);
            System.out.println(map.remove(key));
        } else {
            System.out.println(errorStr);
        }
    }

    private static void get(Scanner scanner) {
        String key = scanner.next();
        Object result = map.get(key);
        if (result != null) {
            queue.remove(key);
            queue.add(key);
            System.out.println(map.get(key));
        } else {
            System.out.println(errorStr);
        }
    }

    private static void evict() {
        Object o = queue.poll();
        if (o != null)
            map.remove(o);
    }

    private static void add(Scanner scanner) {
        String key = scanner.next();
        String value = scanner.next();
        queue.remove(key);
        queue.add(key);
        map.put(key, value);
    }
}
