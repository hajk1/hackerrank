package ir.hajk1.linkedin.test;

import java.util.Objects;

public class Horse extends Animal {

    private String name;

    public Horse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void run() {
        super.run();
        System.out.println("Horse is running");
    }

    void run(String st) {
        System.out.println("animal st = " + st);
    }

    void eat() {
        System.out.println("family = " + family);
        System.out.println("age = " + age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Horse horse = (Horse) o;
        return name.equals(horse.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
