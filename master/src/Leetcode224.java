import java.util.ArrayDeque;
import java.util.Deque;
/** 224.227.772. 基本计算器 https://leetcode.cn/problems/basic-calculator/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode224 {
    /**
     * 思路：将所有元素除了空格放进一个双端队列中
     * @param s
     * @return
     */
    public int calculate(String s) {
        // 双端队列
        Deque<Character> deque=new ArrayDeque<>();
        // 遍历一次数组，除了空格按顺序放入双端队列
        for (char a: s.toCharArray()) {
            if(a!=' '){
                deque.addLast(a);
            }
        }
        return help(deque);
    }

    public int help(Deque<Character> deque) {
        // 双端队列模拟栈
        Deque<Integer> stack=new ArrayDeque<>();
        // 初始化是+号
        char sign='+';
        int num=0;
        // 只要队列不为空
        while (deque.size()>0){
            // 从队头拿元素
            char c=deque.removeFirst();
            // 如果拿出来的是数字，则将之前位乘10，在加上此数字
            if(isDigit(c)){
                num=num*10+(c-'0');
            }
            // 如果是括号，则递归调用，因为括号优先处理
            if(c=='('){
                num=help(deque);
            }
            // 当拿出来的是运算符，就要进行运算操作,初始化第一次运算为+，当遇到运算符，直接将之前的结果加入栈
            // 如果队列里没有元素了，也要进行运算
            if(!isDigit(c)||deque.size()==0){
                if(sign=='+'){
                    stack.addLast(num);
                }
                else if(sign=='-'){
                    stack.addLast(-num);
                }
                // 如果为乘，将栈顶元素取出来，和num做乘法在重新加入栈
                else if(sign=='*'){
                    int pre=stack.removeLast();
                    stack.add(num*pre);
                }
                // 如果为除，将栈顶元素取出来，用pre除以num，并重新加入栈
                else if(sign=='/'){
                    int pre=stack.removeLast();
                    stack.add(pre/num);
                }
                // 运算结束后，清空num
                num=0;
                // 更新运算符
                sign=c;
            }
            // 当再次遇到一个括号时，结束递归
            if(c==')'){
                break;
            }
        }
        int res=0;
        // 最后从栈中去除元素，累加在一起即可(因为栈中元素是带符号的)
        while (stack.size()>0){
            int top=stack.removeLast();
            res=res+top;
        }
        return res;
    }

    // 判断此字符是否是数字
    private boolean isDigit(char c){
        if(c>='0'&&c<='9'){
            return true;
        }
        return false;
    }
}
