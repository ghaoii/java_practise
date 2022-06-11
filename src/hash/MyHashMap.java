package hash;

import java.util.Arrays;

public class MyHashMap {
    Node[] hashTable;
    int size;

    int M;

    static final float LOAD_FACTOR = 0.75f;

    public MyHashMap() {
        this(16);
    }

    public MyHashMap(int Init){
        hashTable = new Node[Init];
        M = Init;
    }

    public int hash(int key){
        return Math.abs(key % M);
    }

    public int add(int key, int val){
        int index = hash(key);
        Node node = hashTable[index];
        while (node != null) {
            if(key == node.key){
                //key值已存在，更新val值，并返回修改前的val
                int oldVal = node.val;
                node.val = val;
                return oldVal;
            }
            node = node.next;
        }
        //走到这里说明key是第一次出现
        node = new Node(key, val);
        node.next = hashTable[index];
        hashTable[index] = node;
        size++;
        if(size >= LOAD_FACTOR * hashTable.length){
            resize();
        }
        return val;
    }

    private void resize(){
        Node[] newHash = new Node[hashTable.length << 1];
        M = newHash.length;
        for (int i = 0; i < hashTable.length; i++) {
            for(Node node = hashTable[i]; node != null; ){
                Node next = node.next;
                int newIndex = hash(node.key);
                node.next = newHash[newIndex];
                newHash[newIndex] = node;
                node = next;
            }
        }
        hashTable = newHash;
    }

    public boolean containKey(int key) {
        int index = hash(key);
        Node node = hashTable[index];
        while(node != null){
            if(node.key == key){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public boolean remove(int key, int val) {
        int index = hash(key);
        Node node = hashTable[index];
        if(node.key == key && node.val == val){
            //头结点就是待删除元素
            hashTable[index] = node.next;
            node = node.next = null;
            size--;
            return true;
        }
        //头结点不是待删除元素
        Node prev = hashTable[index];
        node = prev.next;
        while(node != null){
            if(node.key == key && node.val == val){
                prev = node.next;
                node = node.next = null;
                size--;
                return true;
            }
            prev = node;
            node = node.next;
        }
        //走到这说明待删除元素不存在
        return false;
    }


}
