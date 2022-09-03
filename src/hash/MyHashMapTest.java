package hash;

public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap(4);
        map.put(1,10);
        map.put(2,20);
        map.put(5,50);
        map.put(6,60);
        map.put(9, 90);
        System.out.println(map.get(3));
        System.out.println(map.remove(9, 90));
        System.out.println(map.contains(9));
    }
}
