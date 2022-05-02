import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArray {
    int[] data;
    int size = 0;

    public MyArray(){
        this(3);
    }

    public MyArray(int val){
        data = new int[val];
    }

    public String toString(){
        String ret = "[";
        for (int i = 0; i < size; i++) {
            ret += data[i];
            if(i != size - 1){
                ret += ", ";
            }
        }
        ret += "]";
        return ret;
    }

    /**
     * 向数组中添加元素
     */

    private void grow(){
        data = Arrays.copyOf(data, data.length * 2);
    }

    //尾插
    public void addLast(int val){
        data[size] = val;
        size++;
        if(size == data.length){
            grow();
        }
    }

    //在索引为index处插入元素
    public void add(int index, int val){
        if(index < 0 || index > size){
            System.out.println("add index illegal");
            return;
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = val;
        size++;
        if(size == data.length){
            grow();
        }
    }

    //头插
    public void addFirst(int val){
        add(0, val);
    }

    /**
     * 查找元素
     */

    //查找索引为index处的元素值
    public int get(int index){
        if(index < 0 || index >= size){
            System.out.println("get index illegal");
            return -1;
        }
        return data[index];
    }

    //找到动态数组中值为val的元素，返回其下标
    public int getbyVal(int val){
        for (int i = 0; i < size; i++) {
            if(data[i] == val){
                return i;
            }
        }
        System.out.println("val does not exist");
        return -1;
    }

    //判断动态数组中是否包含val
    public boolean contains(int val){
        return getbyVal(val) != -1;
    }

    /**
     * 修改动态数组的元素值
     */

    //修改索引为index处的元素值，返回修改前的元素值
    public int set(int index, int newVal){
        int ret = data[index];
        data[index] = newVal;
        return ret;
    }

    //修改第一个值为oldVal的元素值为newVal
    public void setByVal(int oldVal, int newVal){
        for (int i = 0; i < size; i++) {
            if(data[i] == oldVal){
                data[i] = newVal;
                break;
            }
        }
    }

    /**
     * 删除动态数组中的元素
     */

    //删除索引为index处的元素
    public void remove(int index){
        if(index < 0 || index >= size){
            System.out.println("remove index illegal");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i+1];
        }
        size--;
    }

    //删除动态数组中第一个值为val的元素
    public void removeValOnce(int val){
        if(size == 0){
            System.out.println("array is empty");
            return;
        }
        for (int i = 0; i < size; i++) {
            if(data[i] == val){
                remove(i);
            }
        }
        System.out.println("data does not exist");
    }

    //删除动态数组中所有值为val的元素
    public void removeValAll(int val){
        if(size == 0){
            System.out.println("array is empty");
            return;
        }
        for (int i = 0; i < size; i++) {
            while(i < size && data[i] == val){
                for (int j = i; j < size - 1; j++) {
                    data[j] = data[j+1];
                }
                size--;
            }
        }
    }

}
