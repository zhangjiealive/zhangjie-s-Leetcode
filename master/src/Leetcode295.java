import java.util.PriorityQueue;

/** 295. 数据流的中位数 https://leetcode.cn/problems/find-median-from-data-stream/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode295 {
    /**
     * 从流中找中位数，运用两个优先级堆，保证两个堆元素差不大于1，保证large>=small
     * 两个堆共同存储流的所有数据，如果数量是奇数，则两个堆谁更大，取谁栈顶的元素，如果是偶数，则取出各自栈顶的元素除以2.0
     * 增加参数 如果large的元素个数大于small的元素个数则需要往small中插入，需要将元素先放入large，然后将large堆顶(最小)的元素插入small
     * 如果large的元素个数小于或等于small的元素个数，则需要往large中插入，需要将元素先放入small，然后将small堆顶(最大)的元素插入large
     */
    class MedianFinder {
        private PriorityQueue<Integer> large;
        private PriorityQueue<Integer> small;

        public MedianFinder() {
            // 小顶堆
            large=new PriorityQueue<>();
            // 大顶堆
            small=new PriorityQueue<>((a,b)->{
                return b-a;
            });
        }

        public void addNum(int num) {
            // 通过插入large需要先插入small而后取栈顶的操作来使large中的元素最小值大于或等于small中的最大值
            if(small.size()>=large.size()){
                small.offer(num);
                large.offer(small.poll());
            }
            // 通过插入small需要先插入large而后取栈顶的操作来使large中的元素最小值大于或等于small中的最大值
            else {
                large.offer(num);
                small.offer(large.poll());
            }
        }

        public double findMedian() {
            // 两个堆大小不同，谁大取谁的栈顶
            if(large.size()<small.size()){
                return small.peek();
            }
            else if(large.size()>small.size()){
                return large.peek();
            }
            // 否则取各自栈顶除以二
            return (large.peek()+small.peek())/2;
        }
    }
}
