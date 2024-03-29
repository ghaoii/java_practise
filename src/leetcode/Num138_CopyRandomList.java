package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Num138_CopyRandomList {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        Node node = head;
        Map<Node, Node> map = new HashMap<>();
        while(node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }
        node = head;
        while(node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }
}
