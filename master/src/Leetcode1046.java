import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/** 1046. 最后一块石头的重量 https://leetcode.cn/problems/last-stone-weight/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode1046 {
    /**
     * 每次选出最大的两个元素，使用大顶堆
     * @param stones
     * @return
     */
    public int lastStoneWeight(int[] stones) {
        // 大顶堆
        Queue<Integer> queue=new PriorityQueue<>(Comparator.reverseOrder());
        // 全部加入堆
        for (int a : stones) {
            queue.offer(a);
        }
        // 只要堆里有两个或两个以上的元素
        while (queue.size()>1){
            // 相应取出
            int a=queue.poll();
            int b=queue.poll();
            // 两个石头相等，不做任何操作
            if(a==b){
                continue;
            }
            // 否则在将碎石头加入堆
            else {
                queue.offer(a-b);
            }
        }
        // 如果最后执行完毕，堆为空，则返回0，否则返回堆中唯一的元素
        return queue.isEmpty()?0:queue.poll();
    }
}
