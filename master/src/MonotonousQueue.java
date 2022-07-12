import java.util.LinkedList;

/**
 * 单调队列
 * 队列中元素是递减的，并且可以按照时间顺序排列
 * 可用于滑动窗口的窗口最值
 */
public class MonotonousQueue {

    private LinkedList<Integer> maxq=new LinkedList<>();
    // 元素入队
    public void push(int n){
        // 保证队列前所有比他小的元素全部出队（保证元素的递减）
        while (!maxq.isEmpty()&&maxq.getLast()<n){
            maxq.pollLast();
        }
        maxq.addLast(n);
    }
    // 取队列的最大值
    public int max(){
        // 队头就是最大值
        return maxq.getFirst();
    }
    // 元素出队
    public void pop(int n){
        // 如果这个元素是最大值，那么出队，如果不是最大值，不执行任何操作，因为他已经被队列中的最大值挤掉了
        if(n==maxq.getFirst()){
            maxq.pollFirst();
        }
    }
}
