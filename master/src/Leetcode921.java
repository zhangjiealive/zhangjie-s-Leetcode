import java.util.ArrayDeque;
import java.util.Deque;

/** 921. 使括号有效的最少添加 https://leetcode.cn/problems/minimum-add-to-make-parentheses-valid/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode921 {
    /**
     * 修改20题的方法，正常匹配括号，最后栈中的元素个数，就是需要添加的括号
     * @param s
     * @return
     */
    public int minAddToMakeValid(String s){
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
                    // 无论栈是否为空只要没匹配上都将c进栈，没匹配上代表需要添加括号
                    else {
                        stack.addLast(c);
                    }
                }
                // 无论栈是否为空只要没匹配上都将c进栈，没匹配上代表需要添加括号
                else {
                    stack.addLast(c);
                }
            }
        }
        // 最后只需返回，栈的元素个数，当栈为空，则代表全部匹配完，不需要添加括号
        return stack.size();
    }

    /**
     * 遍历一次字符串
     * 思路：遇到一个左括号，则需要一个右括号
     * 遇到左括号，将右括号需求+1，遇到右括号将右括号需求-1，当需求为-1，则插入左括号
     * @param s
     * @return
     */
    public int minAddToMakeValid1(String s){
        // 添加左括号的数量
        int res=0;
        // 需要右括号的数量
        int need=0;
        // 遍历字符串
        for (char c : s.toCharArray()) {
            // 当c为左括号
            if(c=='('){
                // 右括号的需求量+1
                need++;
            }
            // 当c为右括号，右括号的需求量-1
            else if(c==')'){
                need--;
                // 当右括号的需求量为-1,代表右括号多出来了，直接添加一个左括号，并把右括号的需求量置0，代表左括号和右括号平衡了
                if(need==-1){
                    res++;
                    need=0;
                }
            }
        }
        // 最后返回res+need，意为添加左括号的数量+和需求右括号的数量
        return res+need;
    }
}
