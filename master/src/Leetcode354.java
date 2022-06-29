//: Leetcode354.java

import java.util.Arrays;
import java.util.Comparator;

/** 力扣354题 https://leetcode.cn/problems/russian-doll-envelopes/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode354 {
    public int maxEnvelopes(int[][] envelopes) {
        int n=envelopes.length;
        // 按宽度升序排列，如果宽度一样，则按高度降序排列
        Arrays.sort(envelopes, new Comparator<int[]>()
        {
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ?
                        b[1] - a[1] : a[0] - b[0];
            }
        });
        int[] replace=new int[n];
        for (int i = 0; i < n; i++) {
            replace[i]=envelopes[i][1];
        }
        return lengthOfLIS(replace);
    }
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
    public static void main(String[] args) {
        int[][] a={{4,5},{4,6},{6,7},{2,3},{1,1}};
        Leetcode354 leetcode354 = new Leetcode354();
        leetcode354.maxEnvelopes(a);
    }
}
