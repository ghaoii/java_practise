package linkedlist;

public class Test {
    public static void main(String[] args) {
        LinkedListNoHead linkedListNoHead = new LinkedListNoHead();
        linkedListNoHead.addLast(10);
        linkedListNoHead.addLast(20);
        linkedListNoHead.addLast(20);
        linkedListNoHead.addLast(10);
        linkedListNoHead.addLast(20);
        linkedListNoHead.addLast(20);
        linkedListNoHead.removeValAll(20);
//        System.out.println(linkedListNoHead.removeValOnce(60));
//        linkedListNoHead.remove(3);
//        System.out.println(linkedListNoHead.set(1, 200));
//        System.out.println(linkedListNoHead.contains(50));
//        System.out.println(linkedListNoHead.getByVal(40));
//        System.out.println(linkedListNoHead.get(2));
//        linkedListNoHead.add(2, 200);//添加
        System.out.println(linkedListNoHead);
    }
}
