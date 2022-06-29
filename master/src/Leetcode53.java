//: Leetcode53.java

/** 力扣53题 https://leetcode.cn/problems/maximum-subarray/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode53 {
    public int maxSubArray(int[] nums) {
        int currMax=nums[0];
        int befMax=nums[0];
        int Max=nums[0];
        for (int a : nums) {
            if(befMax<0){
                befMax=a;
                currMax=a;
            }
            else if(befMax>=0){
                befMax=befMax+a;
                currMax=a;
            }
            Max=Math.max(Max,Math.max(currMax,befMax));
        }
        return Max;
    }

    public int maxSubArray1(int[] nums) {
        int pre=0;
        int Max=nums[0];
        for (int i=0;i<nums.length;i++){
            if(pre>0){
                nums[i]=nums[i]+pre;
                pre=nums[i];
            }
            else{
                pre=nums[i];
            }
            Max=Math.max(Max,pre);
        }
        return Max;
    }

    public static void main(String[] args) {
        int[] a={-2,1,-3,4,-1,2,1,-5,4};
        Leetcode53 leetcode53 = new Leetcode53();
        leetcode53.maxSubArray1(a);
    }
}
