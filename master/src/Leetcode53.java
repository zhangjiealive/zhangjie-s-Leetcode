//: Leetcode53.java

import java.util.Arrays;

/** 力扣53题 https://leetcode.cn/problems/maximum-subarray/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode53 {
    /**
     * 根据题意，如果前面的预先值小于0，最大的就是当前指针本身的数
     * 如果大于0，则加起来，每次循环更新最大值
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
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

    int[] memo;

    /**
     * 自底向下，已知底层的base case
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int n=nums.length;
        memo=new int[n];
        memo[0]=nums[0];
        int res=Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            memo[i]=Math.max(memo[i-1],memo[i-1]+nums[i]);
            res=Math.max(res,memo[i]);
        }
        return res;
    }

    /**
     * 自顶向下递归
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int n=nums.length;
        memo=new int[n];
        Arrays.fill(memo,-6666);
        int res=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp(nums,i);
        }
        for (int i = 0; i < nums.length; i++) {
            res=Math.max(memo[i],res);
        }
        return res;
    }

    public int dp(int[] nums,int i){
        if(i==0){
            memo[i]=nums[i];
            return nums[0];
        }
        // 要去思考，什么样的递归顺序，能最大的利用memo中的数据
        // 如果是从n到0的递归，每次想取memo中的值都不是有效值
        // 如果是从0到n的递归，则每次递归都会用到memo中的值，但是要根据题目含义做出对应的操作
        if(memo[i]!=-6666){
            return memo[i];
        }
        memo[i]=Math.max(dp(nums,i-1)+nums[i],nums[i]);
        return memo[i];
    }

    public static void main(String[] args) {
        int[] a={-2,1,-3,4,-1,2,1,-5,4};
        Leetcode53 leetcode53 = new Leetcode53();
        leetcode53.maxSubArray1(a);
    }
}
