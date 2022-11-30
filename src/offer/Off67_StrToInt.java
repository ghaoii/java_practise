package offer;

public class Off67_StrToInt {
    public int strToInt(String str) {
        if(str == null || str.length() == 0) {
            return 0;
        }
        char[] ch = str.toCharArray();
        int i = 0;
        // 去掉开头的空格
        while(i < ch.length && ch[i] == ' ') {
            i++;
        }
        // 如果全是空格，直接返回0
        if(i == ch.length) {
            return 0;
        }

        int flag = 1;
        long ret = 0;

        // 判断是否有正负号
        if(ch[i] == '+') {
            i++;
        }else if(ch[i] == '-') {
            flag = -1;
            i++;
        }

        // 提取整数，如果不是数字字符，long本身就是0，所以不影响结果
        while(i < ch.length && ch[i] >= '0' && ch[i] <= '9') {
            ret = ret * 10 + (ch[i] - '0');
            // 如果已经超出整形范围就直接返回
            if(ret >= Integer.MAX_VALUE) {
                if(flag == 1) {
                    // 如果是正整数，则直接返回整形最大值
                    return Integer.MAX_VALUE;
                }else if(ret * flag <= Integer.MIN_VALUE) {
                    // 如果是负整数，且小于整形最小值，则直接返回整形最大值
                    return Integer.MIN_VALUE;
                }
            }
            i++;
        }

        return (int) ret * flag;
    }
}
