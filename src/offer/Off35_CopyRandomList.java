package offer;

import java.util.HashMap;
import java.util.Map;

//class Node {
//    int val;
//    Node next;
//    Node random;
//
//    public Node(int val) {
//        this.val = val;
//        this.next = null;
//        this.random = null;
//    }
//}

public class Off35_CopyRandomList {
//    public Node copyRandomList(Node head) {
//        if(head == null) {
//            return null;
//        }
//
//        // 先遍历原链表，将新旧结点都存储到Map集合中
//        Map<Node, Node> map = new HashMap<>();
//        Node node = head;
//        while(node != null) {
//            map.put(node, new Node(node.val));
//            node = node.next;
//        }
//
//        // 再次遍历原链表，通过Map集合获得对应的新结点，并设置新结点的next和random
//        node = head;
//        while(node != null) {
//            map.get(node).next = map.get(node.next);
//            map.get(node).random = map.get(node.random);
//            node = node.next;
//        }
//
//        return map.get(head);
//    }
}
