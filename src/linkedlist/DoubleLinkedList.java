package linkedlist;

public class DoubleLinkedList {

    DoubleNode head;

    DoubleNode tail;

    int size;

    public boolean addFirst(int val) {
        if(isEmpty()) {
            head = new DoubleNode(val);
            tail = head;
        }else {
            head.prev = new DoubleNode(null, val, head);
            head = head.prev;
        }
        size++;
        return true;
    }

    public boolean addLast(int val) {
        if(isEmpty()) {
            head = new DoubleNode(val);
            tail = head;
        }else {
            tail.next = new DoubleNode(tail, val, null);
            tail = tail.next;
        }
        size++;
        return true;
    }

    public void add(int val) {
        addLast(val);
    }

    public void add(int index, int val) {
        if(index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("index is illegal! cannot add!");
        }
        if(index == 0) {
            addFirst(val);
            return;
        }
        if(index == size) {
            addLast(val);
            return;
        }
//        if(index <= (size - 1) / 2) {
//            int i = 0;
//            DoubleNode node = head;
//            while(i < index) {
//                node = node.next;
//                i++;
//            }
//            DoubleNode newNode = new DoubleNode(node.prev, val, node);
//            node.prev = newNode;
//            newNode.prev.next = newNode;
//        }else {
//            int i = size - 1;
//            DoubleNode node = tail;
//            while(i > index) {
//                node = node.prev;
//                i--;
//            }
//            DoubleNode newNode = new DoubleNode(node.prev, val, node);
//            node.prev = newNode;
//            newNode.prev.next = newNode;
//        }
        DoubleNode node = getNode(index);
        DoubleNode newNode = new DoubleNode(node.prev, val, node);
        node.prev = newNode;
        newNode.prev.next = newNode;
        size++;
    }

    public int get(int index) {
        if(!indexRange(index)) {
            throw new ArrayIndexOutOfBoundsException("index is illegal! cannot search!");
        }
        return getNode(index).val;
    }

    public boolean contains(int val) {
        DoubleNode node = head;
        while(node != null) {
            if(node.val == val) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public int set(int index, int val) {
        if(!indexRange(index)) {
            throw new ArrayIndexOutOfBoundsException("index is illegal! cannot change!");
        }
        DoubleNode node = getNode(index);
        int ret = node.val;
        node.val = val;
        return ret;
    }

    public int remove(int index) {
        if(!indexRange(index)) {
            throw new ArrayIndexOutOfBoundsException("index is illegal! cannot remove!");
        }
        DoubleNode node = getNode(index);
        int ret = node.val;
        unlink(node);
        return ret;
    }

    public void removeValOnce(int val) {
        DoubleNode node = head;
        while(node != null) {
            if(node.val == val) {
                unlink(node);
                return;
            }
            node = node.next;
        }
    }

    public void removeValAll(int val) {
        DoubleNode node = head;
        while(node != null) {
            if(node.val == val) {
                DoubleNode next = node.next;
                unlink(node);
                node = next;
            }else{
                node = node.next;
            }

        }
    }

    private void unlink(DoubleNode node) {
        if(node == head) {
            head = head.next;
            head.prev = null;
            node.next = null;
            return;
        }
        if(node == tail) {
            tail = tail.prev;
            tail.next = null;
            node.prev = null;
            return;
        }
        DoubleNode prev = node.prev;
        DoubleNode next = node.next;
        prev.next = next;
        next.prev = prev;
        node.prev = null;
        node.next = null;
        size--;
    }

    private DoubleNode getNode(int index) {
        DoubleNode node = null;
        if(index < (size - 1) / 2) {
            int i = 0;
            node = head;
            while(i < index) {
                node = node.next;
                i++;
            }
        }else {
            int i = size - 1;
            node = tail;
            while(i > index) {
                node = node.prev;
                i--;
            }
        }
        return node;
    }

    private boolean indexRange(int index) {
        return index >= 0 && index < size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        DoubleNode node = head;
        String ret = "";
        while(node != null) {
            ret += node.val;
            if(node.next != null) {
                ret += "->";
            }
            node = node.next;
        }
        return ret;
    }
}
