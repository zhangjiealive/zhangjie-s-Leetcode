import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/** 496. 下一个更大元素 I https://leetcode.cn/problems/next-greater-element-i/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode496 {
    /**
     * nums1是nums2的子集，题目要求找出nums1中元素在nums2中位置的下一个最大元素
     * 先将nums2都算出来，存入map，而后去取
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nums2Res=nextGreaterElement(nums2);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums2.length;i++) {
            map.put(nums2[i],nums2Res[i]);
        }
        int[] res=new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i]=map.get(nums1[i]);
        }
        return res;
    }

    /**
     * 单调栈
     * @param nums
     * @return
     */
    public int[] nextGreaterElement(int[] nums){
        int n=nums.length;
        int[] res=new int[n];
        // 栈使用ArrayDeque比较快
        Deque<Integer> stack = new ArrayDeque<Integer>();
        // 从后往前入栈，就是从前往后出栈
        for (int i = n-1; i >=0 ; i--) {
            // 保证栈不为空，并将小于指针指向元素的元素全部出栈
            while (!stack.isEmpty()&& stack.peek()<=nums[i]){
                stack.pop();
            }
            // 如果栈为空，代表这个元素比栈里所有元素都大，如果不为空，下一个比它大的就是栈顶的元素
            res[i]=stack.isEmpty()?-1:stack.peek();
            // 将此元素入栈
            stack.push(nums[i]);
        }
        return res;
    }
}
