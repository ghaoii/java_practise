package linkedlist;

public class LinkedListNoHead {
    Node head = null;//存储头结点
    int size = 0;//统计链表中元素的个数

    /**
     * 链表的插入
     */

    //头插法
    public void addFirst(int val){
        if(head == null){
            //链表中没有结点
            head = new Node(val);
        }else{
            //链表中已经存在结点
            head = new Node(val, head);
        }
        size++;
    }

    //尾插法
    public void addLast(int val){
        if(head == null){
            //此时链表中没有结点
            head = new Node(val);
        }else{
            Node node = head;
            while(node.next != null){
                node = node.next;
            }
            node.next = new Node(val);
        }
        size++;
    }

    //在索引为index的位置插入
    public void add(int index, int val){
        //判断index的合法性
        if(index < 0 || index > size){
            System.out.println("add index illegal");
            return;
        }
        if(index == 0){
            //头插
            addFirst(val);
        }else if(index == size){
            //尾插
            addFirst(val);
        }else{
            Node prev = head;
            //找到前驱结点
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            prev.next = new Node(val, prev.next);
        }
        size++;
    }

    /**
     * 查找
     */

    //找到索引为index的元素值，否则返回-1
    public  int get(int index){
        if(!rangeCheck(index)){
            System.out.println("get index illegal");
            return -1;
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.val;
    }

    //查找第一个元素值为val的元素，并返回其索引，否则返回-1
    public int getByVal(int val){
        Node node = head;
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

    //判断该链表中是否包含val
    public boolean contains(int val){
        return getByVal(val) != -1;
    }

    /**
     * 修改
     */

    //修改索引为index位置的结点的元素值为newVal，返回修改前的元素值，否则返回-1
    public int set(int index, int newVal){
        if(!rangeCheck(index)){
            System.out.println("set index illegal");
            return -1;
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        int oldVal = node.val;
        node.val = newVal;
        return oldVal;
    }

    /**
     * 删除链表中的结点
     */

    //删除索引为index位置的结点
    public void remove(int index){
        if(!rangeCheck(index)){
            System.out.println("remove index illegal");
            return;
        }
        //如果待删除元素第头结点
        if(index == 0){
            Node node = head;
            head = node.next;
            node.next = null;
        }else{
            //如果待删除元素不是头结点
            Node prev = head;//保存前驱
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            Node node = prev.next;
            prev.next = node.next;
            node.next = null;
        }
        size--;
    }

    //删除链表中第一个元素值为val的结点，并返回删除前的元素值
    public int removeValOnce(int val){
        Node prev = head;
        //单独处理头结点
        if(head.val == val){
            Node node = head;
            head = head.next;
            node.next = null;
            size--;
            return node.val;
        }
        //待删除元素不是头结点
        while(prev.next != null){
            if(prev.next.val == val){
                Node node = prev.next;
                prev.next = node.next;
                node.next = null;
                size--;
                return node.val;
            }
            prev = prev.next;
        }
        System.out.println("val does not exist");
        return -1;
    }

    //删除所有链表中值为val的元素
    public void removeValAll(int val) {
        //处理头结点
        if (head.val == val) {
            while (head != null && head.val == val) {
                Node node = head;
                head = head.next;
                node.next = null;
                size--;
            }
        } else {
            Node prev = head;
            while(prev.next != null){
                if(prev.next.val ==val){
                    Node node = prev.next;
                    prev.next = node.next;
                    node.next = null;
                    size--;
                }else{
                    prev = prev.next;
                }
            }
        }
    }

    /**
     * 函数的部分方法
     */

    //封装一个判断index合法性的方法
    private boolean rangeCheck(int index){
        return index >= 0 && index < size;
    }


    public String toString(){
        Node node = head;
        String ret = "";
        while(node != null){
            ret += node.val;
            ret += "->";
            node = node.next;
        }
        ret += "NULL";
        return ret;
    }

}
