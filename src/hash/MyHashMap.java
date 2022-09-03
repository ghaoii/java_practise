package hash;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyHashMap {
    Node[] hashTable;

    int size;

    int M;// 取模数

    private final static float LOAD_FACTOR = 0.75f;

    public MyHashMap(int init) {
        hashTable = new Node[init];
        M = init;
    }

    public MyHashMap() {
        this(16);
    }

    public int hash(int key) {
        return Math.abs(key % M);
    }

    public void put(int key, int val) {
        int hash = hash(key);
        if(hashTable[hash] == null) {
            hashTable[hash] = new Node(key, val);
        }else {
            Node node = hashTable[hash];
            Node prev = null;
            while(node != null) {
                // 如果已经存在key值，则更新val
                if(key == node.key) {
                    node.val = val;
                    break;
                }
                if(node.next == null) {
                    prev = node;
                }
                node = node.next;
            }
            // 如果该prev不为空，则说明当前哈希表中不存在key
            if(prev != null) {
                prev.next = new Node(key, val);
            }
        }
        size++;
        if(size >= M * LOAD_FACTOR) {
            resize();
        }
    }

    private void resize() {
        Node[] newHashTable = new Node[hashTable.length * 2];
        M = newHashTable.length;
        for(Node node : hashTable) {
            while(node != null) {
                int hash = hash(node.key);
                // 由于需要搬移当前结点，因此先暂存下一个结点
                Node next = node.next;
                // 方便起见，直接头插
                node.next = newHashTable[hash];
                newHashTable[hash] = node;
                // 继续搬移下一个结点
                node = next;
            }
        }
        hashTable = newHashTable;
    }

    public boolean contains(int key) {
        int hash = hash(key);
        Node node = hashTable[hash];
        while(node != null) {
            if(node.key == key) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public Integer get(int key) {
        int hash = hash(key);
        int ret = 0;
        Node node = hashTable[hash];
        while(node != null) {
            if(node.key == key) {
                ret = node.val;
                break;
            }
            node = node.next;
        }
        return ret == 0 ? null : ret;
    }

    public boolean remove(int key, int val) {
        int hash = hash(key);
        if(hashTable[hash] != null) {
            Node node = hashTable[hash];
            int ret = 0;
            if(node.key == key && node.val == val) {
                ret = node.val;
                hashTable[hash] = node.next;
                node = node.next = null;
                return true;
            }
            Node prev = node;
            node = node.next;
            while (node != null) {
                if(node.key == key && node.val == val) {
                    ret = node.val;
                    prev.next = node.next;
                    node = node.next = null;
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }
}

//public class MyHashMap {
//    Node[] hashTable;
//    int size;
//
//    int M;
//
//    static final float LOAD_FACTOR = 0.75f;
//
//    public MyHashMap() {
//        this(16);
//    }
//
//    public MyHashMap(int Init){
//        hashTable = new Node[Init];
//        M = Init;
//    }
//
//    public int hash(int key){
//        return Math.abs(key % M);
//    }
//
//    public int add(int key, int val){
//        int index = hash(key);
//        Node node = hashTable[index];
//        while (node != null) {
//            if(key == node.key){
//                //key值已存在，更新val值，并返回修改前的val
//                int oldVal = node.val;
//                node.val = val;
//                return oldVal;
//            }
//            node = node.next;
//        }
//        //走到这里说明key是第一次出现
//        node = new Node(key, val);
//        node.next = hashTable[index];
//        hashTable[index] = node;
//        size++;
//        if(size >= LOAD_FACTOR * hashTable.length){
//            resize();
//        }
//        return val;
//    }
//
//    private void resize(){
//        Node[] newHash = new Node[hashTable.length << 1];
//        M = newHash.length;
//        for (int i = 0; i < hashTable.length; i++) {
//            for(Node node = hashTable[i]; node != null; ){
//                Node next = node.next;
//                int newIndex = hash(node.key);
//                node.next = newHash[newIndex];
//                newHash[newIndex] = node;
//                node = next;
//            }
//        }
//        hashTable = newHash;
//    }
//
//    public boolean containKey(int key) {
//        int index = hash(key);
//        Node node = hashTable[index];
//        while(node != null){
//            if(node.key == key){
//                return true;
//            }
//            node = node.next;
//        }
//        return false;
//    }
//
//    public boolean remove(int key, int val) {
//        int index = hash(key);
//        Node node = hashTable[index];
//        if(node.key == key && node.val == val){
//            //头结点就是待删除元素
//            hashTable[index] = node.next;
//            node = node.next = null;
//            size--;
//            return true;
//        }
//        //头结点不是待删除元素
//        Node prev = hashTable[index];
//        node = prev.next;
//        while(node != null){
//            if(node.key == key && node.val == val){
//                prev = node.next;
//                node = node.next = null;
//                size--;
//                return true;
//            }
//            prev = node;
//            node = node.next;
//        }
//        //走到这说明待删除元素不存在
//        return false;
//    }
//
//
//}
