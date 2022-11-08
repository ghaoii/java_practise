package offer;

public class Off20_IsNumber {
    private int i = 0;// 遍历元素时使用的全局变量

    public static void main(String[] args) {
        Off20_IsNumber test = new Off20_IsNumber();
        System.out.println(test.isNumber("0.8"));
    }

    public boolean isNumber(String s) {
        if(s == null || s.length() == 0) {
            return false;
        }

        s = s.trim();

        // 第一步，判断从当前i到方法执行结束之后的i之间是否存在整数
        boolean isNum = isInteger(s);

        // 到这里，i指向的元素要么到头了，要么指向非数字字符
        if(i < s.length() && s.charAt(i) == '.') {
            // 如果还没到头，且i指向的字符是小数点
            // 那么可能有这么几种情况：1. or .1 or 1.2
            // 即前面既可以有整数也可以没有，后面既可以有整数也可以没有，但是前后至少满足一种
            // 因此通过 || 来更新isNum的状态，并且小数点之后我们判断的是无符号整数
            i++;
            isNum = isUnsignedInteger(s) || isNum;// 这里判断的顺序不能变，否则后面的部分就不扫描了
        }

        // 判断完是否有小数后，再来判断是否存在e或E
        if(i < s.length()) {
            if((s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
                // 如果存在e或E，则要求前面必须满足整数或小数，且后面必须要有整数
                // 所以我们用 && 来更新 isNum 的状态
                i++;
                isNum = isNum && isInteger(s);
            }
        }
        // 只有当i走到头并且i之前都满足数值才返回true
        return i == s.length() && isNum;
    }

    // 判断从i开始的无符号整数部分
    private boolean isUnsignedInteger(String s) {
        int start = i;
        while(i < s.length()) {
            char c = s.charAt(i);
            if(c < '0' || c > '9') {
                // 如果i指向的字符不是数字
                break;
            }
            // 如果i指向的字符是数字，就不断往后走
            i++;
        }
        // 如果i>start说明中间存在字符，否则说明i一开始指向的字符就不是数字字符
        return i > start;
    }

    // 判断从i开始的整数部分
    private boolean isInteger(String s) {
        if(i == s.length()) {
            return false;
        }
        char c = s.charAt(i);
        // 先判断第一位是否有正负号
        if(c == '+' || c == '-') {
            i++;
        }
        return isUnsignedInteger(s);
    }
}
