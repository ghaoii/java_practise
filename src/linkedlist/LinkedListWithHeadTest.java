package linkedlist;

public class LinkedListWithHeadTest {
    public static void main(String[] args) {
        LinkedListWithHead linkedListWithHead = new LinkedListWithHead();
        linkedListWithHead.addLast(20);
        linkedListWithHead.addLast(100);
        linkedListWithHead.addLast(20);
        linkedListWithHead.addLast(20);

//        linkedListWithHead.removeValAll(20);
//        linkedListWithHead.removeValOnce(0);
//        linkedListWithHead.removeLast();
//        linkedListWithHead.removeFirst();
//        linkedListWithHead.remove(3);

//        System.out.println(linkedListWithHead.set(9, 400));

//        System.out.println(linkedListWithHead.contains(0));
//        System.out.println(linkedListWithHead.getByVal(0));

        System.out.println(linkedListWithHead);
    }
}
