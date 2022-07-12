import java.util.Stack;

/** 232. 用栈实现队列 https://leetcode.cn/problems/implement-queue-using-stacks/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode232 {
    /**
     * 双栈实现队列
     */
    class MyQueue {
        private Stack<Integer> s1;
        private Stack<Integer> s2;
        public MyQueue() {
            s1=new Stack<>();
            s2=new Stack<>();
        }
        // 入队正常入到s1中
        public void push(int x) {
            s1.push(x);
        }

        /**
         * 删除取队头元素
         * 先执行peek，为的是保证s2中有元素，如果没有就调用peek将s1中的元素倒序入栈s2
         * 随后直接将s2栈顶元素出栈即可
         * @return
         */
        public int pop() {
            peek();
            return s2.pop();
        }
        /*
         不删除取队头元素
         当s2中有元素时，s2的栈顶就是队头，因为s2中的元素是s1元素倒序入栈的，所以直接取s2栈顶元素即可
         当s2中没有元素时，将s1的元素倒序入栈，取s2的栈顶即可
         */
        public int peek() {
            // 在s2栈为空的情况下
            if(s2.isEmpty()){
                // 将s1中元素全部出栈直接进栈s2，也就是实现了倒序入栈，这时s2中的栈顶就是对应的队头
                while (!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            // 直接取出s2的栈顶元素，就是队头元素
            return s2.peek();
        }
        // 判断队列是否为空，当两个栈都为空时，队列就为空
        public boolean empty() {
            return s1.isEmpty()&&s2.isEmpty();
        }
    }
}
