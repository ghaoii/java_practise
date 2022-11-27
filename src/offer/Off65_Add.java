package offer;

public class Off65_Add {
    public int add(int a, int b) {
        if(a == 0) {
            return b;
        }
         while(b != 0) {
             int temp = a & b;
             a ^= b;
             b = temp << 1;
         }
         return a;
    }
}
