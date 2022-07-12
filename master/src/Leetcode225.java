import java.util.LinkedList;
import java.util.Queue;

/** 225. 用队列实现栈 https://leetcode.cn/problems/implement-stack-using-queues/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode225 {
    // 使用一个队列模拟栈
    class MyStack {
        Queue<Integer> q;
        // 记录队列尾的元素(也就是栈顶)
        int top_elem;

        public MyStack() {
        q=new LinkedList<>();
        top_elem=0;
        }
        // 元素入栈，队列正常入队每次更新栈顶元素
        public void push(int x) {
            q.offer(x);
            top_elem=x;
        }

        /**
         * 返回栈顶元素并出栈
         * 每次将队列中的队头元素出队并且重新插入队尾，直到还剩2个元素，正好可以更新下一次栈顶的元素
         * @return
         */
        public int pop() {
            // 队列的长度
            int size=q.size();
            // 将队列的长度小于等于2
            while(size>2){
                q.offer(q.poll());
                size--;
            }
            // 先记录下一次栈顶的元素
            top_elem=q.peek();
            // 在将下一次栈顶元素出队在入队
            q.offer(q.poll());
            // 取出目前栈顶元素
            return q.poll();
        }
        // 返回栈顶元素
        public int top() {
            return top_elem;
        }
        // 判断栈是否为空
        public boolean empty() {
            return q.isEmpty();
        }
    }
}
