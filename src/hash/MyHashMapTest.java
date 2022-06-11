package hash;

public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap(4);
        map.add(1,10);
        map.add(2,20);
        map.add(5,50);
        map.add(6,60);
        System.out.println(map.containKey(10));
        System.out.println(map.containKey(6));
        System.out.println(map.remove(2, 20));
        System.out.println(map.remove(5, 30));
    }
}
