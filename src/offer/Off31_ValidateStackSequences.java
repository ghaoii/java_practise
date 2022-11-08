package offer;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Off31_ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed == null || pushed.length == 0) {
            return true;
        }
        Deque<Integer> stack = new LinkedList<>();
        int i= 0;
        for(int num : pushed) {
            stack.push(num);
            while(!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

//    public boolean validateStackSequences(int[] pushed, int[] popped) {
//        if(pushed == null || pushed.length == 0) {
//            return true;
//        }
//
//        int prev = 0;
//        Deque<Integer> stack = new LinkedList<>();
//
//        for(int num : popped) {
//            if(stack.isEmpty() || num != stack.peek()) {
//                while(prev < pushed.length) {
//                    // 添加num之前的所有元素
//                    if(num == pushed[prev]) {
//                        break;
//                    }
//                    stack.push(pushed[prev++]);
//                }
//                // 这里要么已经添加了num，要么走到头了
//                if(prev == pushed.length) {
//                    // 如果走到头都没有找到num，说明num已经在栈中了
//                    // 但是栈顶元素又不是num，说明这种出栈顺序是不可能存在的
//                    // 直接返回false
//                    return false;
//                }
//                prev++;
//            }else {
//                stack.pop();
//            }
//        }
//
//        return true;
//    }
}
