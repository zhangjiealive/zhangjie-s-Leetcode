import java.util.ArrayList;
import java.util.List;

/** 239. 滑动窗口最大值 https://leetcode.cn/problems/sliding-window-maximum/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 新建单调队列
        MonotonousQueue mQueue = new MonotonousQueue();
        int length=nums.length;
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 先插入k-1个元素，因为窗口大小为k，目前是在填充窗口中的元素，填充完下次循环就可以开始取值
            if(i<k-1){
                mQueue.push(nums[i]);
            }
            else {
                // 如窗口大小为3，上面的if语句会填充2个元素进去，在第三个元素就开始取值
                mQueue.push(nums[i]);
                // 默认队头是最大值，直接将队头元素加入list
                list.add(mQueue.max());
                // 将窗口最左边的元素出队(要看他在队列中是否是最大值，如果不是最大值就已经被挤掉了，不用删除了，是最大值则需要删除)
                mQueue.pop(nums[i-k+1]);
            }
        }
        // 将list结果放入数组返回
        int[] res=new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i]=list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a={1,-1};
        Leetcode239 leetcode239 = new Leetcode239();
        leetcode239.maxSlidingWindow(a,1);
    }
}
