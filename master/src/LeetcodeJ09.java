import java.util.ArrayDeque;
import java.util.Deque;
/** 剑指 Offer 09. 用两个栈实现队列 https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class LeetcodeJ09 {

}

class CQueue {
    // 入队栈
    Deque<Integer> in;
    // 出队栈
    Deque<Integer> out;

    public CQueue() {
        in=new ArrayDeque();
        out=new ArrayDeque();
    }

    // 入队操作，正常插入入队栈
    public void appendTail(int value) {
        in.push(value);
    }

    // 出队操作
    public int deleteHead() {
        // 当两个栈为空，队列为空，返回-1
        if(in.isEmpty()&&out.isEmpty()){
            return -1;
        }
        // 如果出队栈为空，则要从入队栈去取元素
        if(out.isEmpty()){
            // 循环直到入队栈为空
            while (!in.isEmpty()){
                // 将入队栈，栈顶的，放入出队栈的栈底，可以想象一个栈反过来，也就是队列了
                out.push(in.pop());
            }
        }
        // 此时出队栈一定有元素，直接返回栈顶即可
        return out.pop();
    }
}
