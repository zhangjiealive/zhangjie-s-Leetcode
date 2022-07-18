/** 213. 打家劫舍 II https://leetcode.cn/problems/house-robber-ii/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode213 {
    /**
     * 思路：从2个区间内取，一个不包含头，一个不包含尾，取两个中的最大值
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        return Math.max(robRange(nums,0,nums.length-1),robRange(nums,1, nums.length));
    }

    /**
     * 动态规划：自底向上
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public int robRange(int[] nums,int start,int end){
        int price_a=0;
        int price_b=0;
        int price=0;
        // 思路参考 Leetcode 198
        for (int i = start; i <end; i++) {
            price=Math.max(price_a,nums[i]+price_b);
            price_b=price_a;
            price_a=price;
        }
        return price;
    }

}
