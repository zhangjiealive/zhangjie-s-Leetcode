/** 1049. 最后一块石头的重量 II https://leetcode.cn/problems/last-stone-weight-ii/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode1049 {
    /**
     * 背包问题：使用一维数组
     * 思路：将一堆石头分成两个堆，保证这两个堆的差值最小即可
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        // 计算石堆总重量
        for (int a : stones) {
            sum+=a;
        }
        // 石堆总重量除以2，就是背包容量
        int capacity=sum/2;
        // 数组定义：dp[i]为背包容量为i时能装的重量
        int[] dp=new int[capacity+1];
        // 外层遍历选择
        for (int stone:stones) {
            // 内层遍历状态
            for (int i = capacity; i >=stone ; i--) {
                // 状态由此选择装入背包或不装入背包两种
                dp[i]=Math.max(dp[i-stone]+stone,dp[i]);
            }
        }
        // 石堆数量减去两个此背包容量，就是差值（可以理解为两个背包装入背包容量范围内的最大的同样的容量，最后剩下的就是差值）
        return sum-(2*dp[capacity]);
    }

    /**
     * 背包问题：使用二维数组
     * @param stones
     * @return
     */
    public int lastStoneWeightII1(int[] stones) {
        int sum=0;
        for (int a : stones) {
            sum+=a;
        }
        int capacity=sum/2;
        int length=stones.length;
        // 数组定义：dp[i][j]意为可放i+1个商品，背包容量为j时背包的最大价值
        int[][] dp=new int[length][capacity+1];
        // base case 当dp[0][0]意为1个商品，背包容量为0，价值默认为0
        // base case 当dp[0][j] j>=stone[0]，默认把stone[0]放入背包
        for (int i = stones[0]; i <= capacity; i++) {
            dp[0][i]=stones[0];
        }
        // 外层遍历选择，从1开始，0已经选择过了
        for (int i = 1; i <length; i++) {
            // 内层遍历状态
            for (int j = 1; j <=capacity; j++) {
                // 背包的容量大于stones[i] 此时有两种选择，放入或不放入
                if(j>=stones[i]){
                    // dp[i][j]由dp[i-1][j]可放i-1个物品，背包容量不变和dp[i-1][j-stones[i]]可放i-1个商品，背包容量减去当前选择的两种状态转移而来
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-stones[i]]+stones[i]);
                }
                // 当背包容量小于stones[i]代表不够放入，只能由dp[i-1][j]转移而来
                else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return sum-(2*dp[length-1][capacity]);
    }
}
