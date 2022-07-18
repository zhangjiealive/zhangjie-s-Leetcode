import java.util.Arrays;

/** 198. 打家劫舍 https://leetcode.cn/problems/house-robber/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode198 {
    int[] memo;

    /**
     * 经典动态规划：自顶向下
     * 不能偷连续的两个房子
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        memo=new int[nums.length+1];
        // 备忘录先填充为无效值
        Arrays.fill(memo,-1);
        // 从数组0位置开始打劫
        return dp(nums,0);
    }

    public int dp(int[] nums,int start){
        // base case 当已经超出数组范围，代表没有房子可以抢，直接返回0
        if(start>=nums.length){
            return 0;
        }
        // 当备忘录中为有效值，直接返回
        if(memo[start]!=-1){
            return memo[start];
        }
        // 两种选择：偷当前这个和偷下一个中取最大值
        int res=Math.max(nums[start]+dp(nums,start+2),dp(nums,start+1));
        memo[start]=res;
        return res;
    }

    /**
     * 动态规划：自底向上
     * @param nums
     * @return
     */
    public int rob1(int[] nums) {
        // 用3个变量进行交换
        int price_a=0;
        int price_b=0;
        int price=0;
        // 抢劫区间
        int start=0;
        int end= nums.length;
        for (int i = start; i <end; i++) {
            // 选择：从当前这个房子开始抢劫，或从下一个房子开始抢劫
            // price从昨天抢和今天抢的结果中取最大
            price=Math.max(price_a,nums[i]+price_b);
            // price_b从price_a接收昨天抢过了的结果
            price_b=price_a;
            // price_a接收最大的结果
            price_a=price;
            // 通过price_a每次保存了之前天的最大值，然后通过每次调换price_b price_a来实现永不不会抢相邻的房子
            // 如果price_a>nums[i]+price_b就代表昨天抢总和的比今天抢的总和还大，那么price_a本来就等于price,然后今天就跳过没有抢
            // price_b又接过price_a昨天抢的，在下次循环中成为前天抢的，此时price_a和price_b相同

            // 如果price_a<nums[i]+price_b就代表今天新抢的比较大，price_a就是昨天抢过的
            // 并将price_a更新成今天刚抢的，price_b接替了price_a昨天抢过的结果，在下次循环中price_b成了前天抢过的结果，price_a变成了昨天抢的接着循环
        }
        return price;
    }

    public static void main(String[] args) {
        Leetcode198 leetcode198 = new Leetcode198();
        System.out.println(leetcode198.rob(new int[]{9,2,5,8}));
    }
}
