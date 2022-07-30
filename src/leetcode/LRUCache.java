package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class mapNode {
    int key;
    int value;

    public mapNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    Map<Integer, mapNode> map = new HashMap<>();

    // 双向链表，按照最近使用时间排列，前面为最久未使用元素，后面为最近使用元素
    List<mapNode> list = new LinkedList<>();

    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            updateUseTime(key);
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            removeNode(key);
            addElement(key, value);
            return;
        }
        if(list.size() == capacity) {
            removeNotUse();
        }
        addElement(key, value);
    }

    // 更新结点为最新结点
    private void updateUseTime(int key) {
        mapNode node = map.get(key);
        list.remove(node);
        list.add(node);
    }

    // 删除旧元素
    private void removeNode(int key) {
        list.remove(map.get(key));
        map.remove(key);
    }

    // 删除最久未使用的元素
    private void removeNotUse() {
        mapNode node = list.get(0);
        list.remove(node);
        map.remove(node.key);
    }

    // 添加新元素,并作为最新结点
    private void addElement(int key, int value) {
        mapNode node = new mapNode(key, value);
        list.add(node);
        map.put(key, node);
    }
}