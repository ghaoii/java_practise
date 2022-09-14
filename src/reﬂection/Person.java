package reﬂection;

public class Person {
    public String name = "Harley";
    public int age = 18;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("公有无参构造");
    }

    Person(String name) {
        this.name = name;
        System.out.println("default权限的有参构造");
    }

    private Person(int age) {
        this.age = age;
        System.out.println("私有有参构造");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void show() {
        System.out.println("name: " + name + ", age: " + age);
    }

    private String fun(String msg) {
        return msg;
    }

    public static void test() {
        System.out.println("静态方法");
    }

    public String toString() {
        return "name: " + name + ", age: " + age;
    }
}
