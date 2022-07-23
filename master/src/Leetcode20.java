import java.util.ArrayDeque;
import java.util.Deque;

/** 20. 有效的括号 https://leetcode.cn/problems/valid-parentheses/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode20 {
    // 判断是否为有效的括号
    public boolean isValid(String s) {
        // ArrayDeque做栈，比栈快
        Deque<Character> stack=new ArrayDeque<>();
        // 遍历字符串
        for (char c:s.toCharArray()) {
            // 当c为左括号，进栈
            if(c=='{'||c=='('||c=='['){
                stack.addLast(c);
            }
            // 当c为右括号
            else {
                // 栈不为空的话，去判断栈顶是否为对应的左括号，如果是，则将左括号出栈，继续下次循环
                if(!stack.isEmpty()){
                    if(c=='}'&&stack.peekLast()=='{'){
                        stack.removeLast();
                    }
                    else if(c==']'&&stack.peekLast()=='['){
                        stack.removeLast();
                    }
                    else if(c==')'&&stack.peekLast()=='('){
                        stack.removeLast();
                    }
                    // 如果不是，将此右括号进栈
                    else {
                        stack.addLast(c);
                    }
                }
                // 当c为右括号，栈为空，直接返回false
                else {
                    return false;
                }
            }
        }
        // 最后只需返回，栈是否为空即可
        return stack.isEmpty();
    }
}
