//209. 长度最小的子数组

/** 力扣209题 https://leetcode.cn/problems/minimum-size-subarray-sum/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int right=0;
        int left=0;
        int count=0;
        int min=Integer.MAX_VALUE;
        while (right<nums.length){
            int a=nums[right];
            count=count+a;
            right++;
            while (count>=target){
                min=Math.min(min,right-left);
                int b=nums[left];
                count=count-b;
                left++;
                }
            }
            if(count==target){
                min=Math.min(min,right-left);
            }
        return min==Integer.MAX_VALUE?0:min;
    }

    public static void main(String[] args) {
        int[] a={1,4,4};
        Leetcode209 leetcode209 = new Leetcode209();
        leetcode209.minSubArrayLen(4,a);
    }
}
