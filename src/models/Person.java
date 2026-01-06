package models;

public class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person otra) {
        int result = Integer.compare(this.age, otra.age);
        if (result != 0)
            return result;

        result = this.name.compareTo(otra.name);
        if (result != 0)
            return result;

        return System.identityHashCode(this) - System.identityHashCode(otra);
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
