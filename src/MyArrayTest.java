public class MyArrayTest {
    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        myArray.addLast(10);
        myArray.addLast(20);
        myArray.addLast(20);
        myArray.addLast(30);
        myArray.addLast(30);
        myArray.removeValAll(30);
//        myArray.removeValOnce(1);
//        myArray.remove(5);

//        myArray.setByVal(30, 300);
//        System.out.println(myArray.set(3,300));

//        System.out.println(myArray.get(8));
//        System.out.println(myArray.getbyVal(8));
//        System.out.println(myArray.contains(6));

//        myArray.add(3, 40);
//        myArray.addFirst(0);
        System.out.println(myArray);
    }
}
