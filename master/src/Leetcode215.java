//: Leetcode215.java

import java.util.PriorityQueue;

/** 力扣215. 数组中的第K个最大元素 https://leetcode.cn/problems/kth-largest-element-in-an-array/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode215 {
    /**
     * 二叉堆
     * 保持堆中只有k个元素，大于k时，出堆一个，当所有元素全部入堆并大于k时出堆后，堆顶就是第k大的元素
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pr=new PriorityQueue<>();
        for (int a: nums) {
            pr.offer(a);
            if(pr.size()>k){
                pr.poll();
            }
        }
        return pr.peek();
    }
}
