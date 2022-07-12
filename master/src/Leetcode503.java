import java.util.ArrayDeque;
import java.util.Deque;

/** 503. 下一个更大元素 II https://leetcode.cn/problems/next-greater-element-ii/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode503 {
    /**
     * 单调栈
     * 处理循环数组，常用方法，将数组长度翻倍
     * 不需要构建新的数组，只需下标范围翻倍，并对下标取模
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int length=nums.length;
        int[] res=new int[length];
        Deque<Integer> stack=new ArrayDeque<>();
        // 下标范围扩大到2倍长度
        for(int i=length*2-1;i>=0;i--){
            // 需要处理下标的地方都需要对下标取数组长度的模
            while (!stack.isEmpty()&&nums[i%length]>=stack.peek()){
                stack.pop();
            }
            res[i%length]=stack.isEmpty()?-1:stack.peek();
            stack.push(nums[i%length]);
        }
        return res;
    }
}
