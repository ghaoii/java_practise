package reﬂection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception {
        Person person = new Person("Taylor", 20);
        Class<Person> cls = Person.class;
//        Class<Person> cls2 = (Class<Person>) Class.forName("reﬂection.Person");
//        Class<Person> cls3 = (Class<Person>) new Person().getClass();
//        System.out.println(cls == cls2);
//        System.out.println(cls == cls3);

//        Constructor<?>[] constructors = cls.getConstructors();
//        for(Constructor constructor : constructors) {
//            System.out.println(constructor);
//        }
//        System.out.println("--------------------------------");
//        Constructor[] constructors1 = cls.getDeclaredConstructors();
//        for(Constructor constructor : constructors1) {
//            System.out.println(constructor);
//        }

//        Constructor<Person> constructor = cls.getDeclaredConstructor(String.class, int.class);
//        Person person = constructor.newInstance("Taylor", 20);
//        System.out.println(person);
//        System.out.println(constructor);

        Method method = cls.getDeclaredMethod("show");
        method.invoke(person);
        Method method1 = cls.getDeclaredMethod("fun", String.class);
        method1.setAccessible(true);
        String msg = (String) method1.invoke(person, "hello");
        System.out.println(msg);
        Method method2 = cls.getMethod("test");
        method2.invoke(null);

        Field field = cls.getDeclaredField("name");
        field.set(person, "Dua");
        System.out.println(field.get(person));

        Field[] fields = cls.getDeclaredFields();
        for(Field field1 : fields) {
            System.out.println(field1.get(person));
        }
    }
}
