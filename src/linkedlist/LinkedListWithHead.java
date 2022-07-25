package linkedlist;

public class LinkedListWithHead {
    ListNode dummyHead = new ListNode();
    int size = 0;

    public String toString(){
        ListNode listNode = dummyHead.next;
        String ret = "";
        while(listNode != null){
            ret += listNode.val;
            ret += "->";
            listNode = listNode.next;
        }
        ret += "NULL";
        return ret;
    }

    //封装检测index合法性的方法
    public boolean rangeCheck(int index){
        return index >= 0 && index < size;
    }

    /**
     * 向链表中添加元素
     */

    //头插
    public void addFirst(int val){
        dummyHead.next = new ListNode(val, dummyHead.next);
        size++;
    }

    //向链表中索引为index的位置插入结点
    public void add(int index, int val){
        ListNode prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new ListNode(val, prev.next);
        size++;
    }

    //尾插
    public void addLast(int val){
        add(size, val);
    }

    /**
     * 查找
     */

    //返回索引为index位置的元素值
    public int get(int index){
        if(!rangeCheck(index)){
            System.out.println("get index illegal");
        }
        ListNode listNode = dummyHead.next;
        for (int i = 0; i < index; i++) {
            listNode = listNode.next;
        }
        return listNode.val;
    }

    //找出链表中第一个元素值为val的索引，否则返回-1
    public int getByVal(int val){
        ListNode listNode = dummyHead.next;
        int num = 0;
        while(listNode != null){
            if(listNode.val == val){
                return num;
            }
            listNode = listNode.next;
            num++;
        }
        return -1;
    }

    //判断链表中是否包含val
    public boolean contains(int val){
        return getByVal(val) != -1;
    }

    /**
     * 修改链表中的元素值
     */

    //修改索引为index位置的元素值为newVal，并返回修改前的元素值，否则返回-1
    public int set(int index, int newVal){
        if(!rangeCheck(index)){
            System.out.println("set index illegal");
            return -1;
        }
        ListNode listNode = dummyHead.next;
        for (int i = 0; i < index; i++) {
            listNode = listNode.next;
        }
        int oldVal = listNode.val;
        listNode.val = newVal;
        return oldVal;
    }

    /**
     * 删除链表中的结点
     */

    //删除索引为index位置处的结点
    public void remove(int index){
        if(dummyHead.next == null){
            System.out.println("LinkedList is empty");
            return;
        }
        if(!rangeCheck(index)){
            System.out.println("remove index illegal");
            return;
        }
        ListNode prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        ListNode listNode = prev.next;
        prev.next = listNode.next;
        listNode.next = null;
        size--;
    }

    public void removeFirst(){
        remove(0);
    }

    public void removeLast(){
        remove(size - 1);
    }

    //删除链表中第一个元素值为val的结点
    public void removeValOnce(int val){
        if(size == 0){
            System.out.println("LinkedList is empty");
            return;
        }
        ListNode prev = dummyHead;
        while(prev.next != null){
            if(prev.next.val == val){
                ListNode listNode = prev.next;
                prev.next = listNode.next;
                listNode.next = null;
                size--;
                return;
            }
            prev = prev.next;
        }
        System.out.println("val does not exist");
    }

    //删除链表中所有元素值为val的结点
    public void removeValAll(int val){
        if(size == 0){
            System.out.println("LinkedList is empty");
            return;
        }
        ListNode prev = dummyHead;
        while(prev.next != null){
            if(prev.next.val == val){
                ListNode listNode = prev.next;
                prev.next = listNode.next;
                listNode.next = null;
                size--;
            }else{
                prev = prev.next;
            }
        }
    }

}
