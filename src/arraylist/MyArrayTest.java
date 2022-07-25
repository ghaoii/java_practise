package arraylist;

public class MyArrayTest {
    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        myArray.add(10);
        myArray.add(20);
        myArray.add(20);
        myArray.add(30);
        myArray.add(30);
        //myArray.removeAll(30);
//        myArray.removeFirst(30);
//        myArray.remove(1);

//        myArray.set(3, 300);

//        System.out.println(myArray.get(2));
//        System.out.println(myArray.getbyVal(8));
//        System.out.println(myArray.contains(30));

        myArray.add(5, 40);
//        myArray.addFirst(0);
        System.out.println(myArray);
    }
}
