/** 494. 目标和 https://leetcode.cn/problems/target-sum/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode494 {
    /**
     * 可转换为子集背包问题
     * 设有子集nums[A]和子集nums[B]
     * 假设加法的总和为x，那么减法对应的总和就是sum - x。
     * 所以我们要求的是 x - (sum - x) = target
     * x = (target + sum) / 2
     * 将x设置为新的target(x对应程序中的s)
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int sum=0;
        // 对nums中的值进行计数
        for (int i = 0; i <n ; i++) {
            sum+=nums[i];
        }
        // 如果总和加起来小于target的绝对值，代表怎么都凑不出，代表没有任何结果，直接返回0
        // 如果sum+target是奇数，代表不能划分成两个相同的子集，直接返回0
        if(sum<Math.abs(target)||(sum+target)%2!=0){
            return 0;
        }
        // 新的target值
        int s=(target+sum)/2;
        int[][] dp=new int[n+1][s+1];
        // 因为如果nums为[0,0,0]，target为0,那么[0][0]为1，[1][0]为2，[2][0]为4，所以base case为dp[0][0]=1
        // base case 装满背包0个物品，容量为0的方式只有1种，就是不放东西
        dp[0][0]=1;
        // 因为[0][0]为base case，所以i从1开始，代表背包可以放1样东西
        // 并且防止数组越界，从0开始dp[0-1][j]会越界
        for (int i = 1; i <=n ; i++) {
            // 之前j都从1开始，因为base覆盖了[i][0]，但是因为本题特殊，所以j从0开始
            // 并且[1][0]代表背包可以放1样东西，但是容量为0，所以实现的方式为0（容量为0，不可以放东西，所以实现不了）
            for (int j = 0; j <=s ; j++) {
                // 当目前背包剩余容量装不下此物品，选择不装此物品，此状态通过没装此物品，容量相同的状态得来也就是dp[i][j]=dp[i-1][j];
                if(j-nums[i-1]<0){
                    dp[i][j]=dp[i-1][j];
                }
                /* 当目前背包剩余容量装的下此物品，此时有两种选择：
                1、选择不装此物品，此状态通过没装此物品，容量相同的状态得来，状态就是dp[i][j]=dp[i-1][j];
                2、选择装此物品，此状态通过装此物品，容量减去此物品的重量(因为可以选择重复的物品，所以i不变)，状态转移为dp[i][j]=dp[i-1][j-nums[i-1]];
                而此次是计算方式的总和，应该由两种状态相加而来
                 */
                else {
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][s];
    }

    public static void main(String[] args) {
        Leetcode494 leetcode494 = new Leetcode494();
        System.out.println(leetcode494.findTargetSumWays(new int[]{0, 0, 0}, 0));
    }
}
