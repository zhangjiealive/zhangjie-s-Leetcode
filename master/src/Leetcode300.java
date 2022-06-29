//: Leetcode300.java

import java.util.Arrays;

/** 力扣300题 https://leetcode-cn.com/problems/longest-increasing-subsequence
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode300 {
    public int lengthOfLIS(int[] nums) {
        int[] memo=new int[nums.length];
        Arrays.fill(memo,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    memo[i]=Math.max(memo[i],memo[j]+1);
                }
            }
        }
        int res=0;
        for (int a :
                memo) {
            res=Math.max(res,a);
        }
        return res;
    }

}
