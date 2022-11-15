package offer;

public class Off43_CountDigitOne {
    public int countDigitOne(int n) {
        if(n <= 9) {
            return 1;
        }

        int high = n / 10;// 高位
        int cur = n % 10;// 当前位
        int low = 0;// 低位
        int digit = 1;// 位因子
        int count = 0;// 统计1出现的次数

        // 当high和cur都为0时，说明所有位数都已经计算完了，此时退出循环
        while(high != 0 || cur != 0) {
            if(cur == 0) {
                // 当前位为0时，出现1的次数只由高位决定
                count += high * digit;
            }else if(cur == 1) {
                // 当前位为1时，出现1的次数由高位和低位共同决定
                count += high * digit + low + 1;
            }else {
                // 当前位大于1时，出现1的次数只由高位决定
                count += (high + 1) * digit;
            }

            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }

        return count;
    }
}
