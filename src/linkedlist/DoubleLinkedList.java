package linkedlist;

import leetcode.ListNode;

public class DoubleLinkedList {
    DoubleNode head;
    DoubleNode tail;
    int size;

    public String toString(){
        DoubleNode node = head;
        String ret = "";
        while(node != null){
            ret += node.val;
            ret += "->";
            node = node.next;
        }
        ret += "NULL";
        return ret;
    }

    /**
     * 添加元素
     */

    //头插
    public void addFirst(int val){
        if(head == null){
            head = new DoubleNode(val);
            tail = head;
        }else{
            head = new DoubleNode(null, val, head);
        }
        size++;
    }

    //尾插
    public void addLast(int val){
        if(tail == null){
            tail = new DoubleNode(val);
            head = tail;
        }else{
            tail.next = new DoubleNode(tail, val, null);
            tail = tail.next;
        }
        size++;
    }

    //封装一个找到索引为index处的结点的方法
    private DoubleNode findIndex(int index){
        if(index < 0 || index >= size){
            System.out.println("find index illegal");
            return null;
        }
        if(index < size / 2){
            DoubleNode node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }else{
            DoubleNode node = tail;
            for (int i = size - 1;i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    //在索引为index处插入元素值val
    public void add(int index, int val){
        if(index < 0 || index > size){
            System.out.println("add index illegal");
            return;
        }
        if(index == 0){
            addFirst(val);
        }else if(index == size){
            addLast(val);
        }else{
            DoubleNode next = findIndex(index);
            DoubleNode node = new DoubleNode(next.prev, val, next);
            DoubleNode prev = node.prev;
            prev.next = node;
            next.prev = node;
            //也可以简化为下面的写法，但是顺序就不能变了
//            next.prev.next = node;
//            next.prev = node;
            size++;
        }
    }

    /**
     * 查找双向链表
     */

    //返回索引为index处的元素值，否则返回-1
    public int get(int index){
        if(!rangeCheck(index)){
            System.out.println("get index illegal");
            return -1;
        }
        return findIndex(index).val;
    }

    //返回链表中第一个元素值为val的索引，否则返回-1
    public int getByVal(int val){
        DoubleNode node = head;
        int num = 0;
        while(node != null){
            if(node.val == val){
                return num;
            }
            node = node.next;
            num++;
        }
        System.out.println("val does not exist");
        return -1;
    }



    //判断链表中是否包含元素值val
    public boolean contains(int val){
        return getByVal(val) != -1;
    }

    /**
     * 修改链表的元素值
     */

    //修改索引为index处的元素值，并返回修改前的值
    public int set(int index, int newVal){
        if(!rangeCheck(index)){
            System.out.println("set index illegal");
            return -1;
        }
        DoubleNode node = findIndex(index);
        int oldVal = node.val;
        node.val = newVal;
        return oldVal;
    }

    /**
     * 删除链表中的元素
     */

    //封装一个删除结点的方法
    private void unlink(DoubleNode node){
        if(node == null){
            return;
        }
        DoubleNode prev =node.prev;
        DoubleNode successor = node.next;
        //先处理结点的前半部分
        if(prev == null){
            //该结点是头结点
            head = successor;
        }else{
            //有前驱结点
            prev.next = successor;
            node.prev = null;
        }
        //处理结点的后半部分
        if(successor == null){
            //该结点是尾结点
            tail = prev;
        }else{
            //有后继结点
            successor.prev = prev;
            node.next = null;
        }
        size--;
    }

    //删除索引为index处的结点
    public void remove(int index){
        if(!rangeCheck(index)){
            System.out.println("remove index illegal");
            return;
        }
        unlink(findIndex(index));
    }

    //删除链表中第一个元素值为val的结点
    public void removeValOnce(int val){
        int index = getByVal(val);
        unlink(findIndex(index));
    }

    //删除链表中所有元素值为val的结点
    public void removeValAll(int val){
        DoubleNode node = head;
        while(node != null){
            DoubleNode next = node.next;
            if(node.val == val){
                unlink(node);
            }
            node = next;
        }
    }

    //封装一个检测index合法性的方法
    private boolean rangeCheck(int index){
        return index >= 0 && index < size;
    }

}
