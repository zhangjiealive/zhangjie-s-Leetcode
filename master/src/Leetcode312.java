/** 312. 戳气球 https://leetcode.cn/problems/burst-balloons/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode312 {
    /**
     * 怎么划分区间能取到最大值
     * 动态规划：自顶向下
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        int length=nums.length;
        // 替换原数组，边界应该为1的气球
        int[] replace=new int[length+2];
        replace[0]=1;
        replace[length+1]=1;
        for (int i = 1; i < length+1; i++) {
            replace[i]=nums[i-1];
        }
        // dp数组，根据替换数组大小
        // base case 为对角线为0，这样中间是没有气球的
        // 由下至上遍历，不同的位置代表了不同的划分方式，在每一行最后一个dp[i][length+1]计算数组大小为length-i的最大金币数
        int[][] dp = new int[length+2][length+2];
        // 倒序遍历
        for (int i = length; i >= 0; i--) {
            // 由内向外
            for (int j = i + 1; j < length + 2; j++) {
                // 控制每个位置的结果都要由本行base case以及之前的所有结果决定
                // base case后面的第一位只由base case转移而来，第二位由base和第一位转移而来，循环两次，第三位以此类推
                // dp[i][k] + dp[k][j]随着k的变动，dp[i][j]由dp[i][k] + dp[k][j]转移而来，k控制横着由远到近，竖着的由近到远(对应的意思就是k在哪里划分区间)
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(
                            dp[i][j],
                            // dp[i][j]分为dp[i][k] dp[k][j]两个区间，在加上k位置的值
                            // dp[i][k] dp[k][j]在看成一个新的区间去同上处理
                            dp[i][k] + dp[k][j] + replace[i]*replace[j]*replace[k]
                    );
                }
            }
        }
        return dp[0][length+1];
    }

    public static void main(String[] args) {
        Leetcode312 leetcode312 = new Leetcode312();
        leetcode312.maxCoins(new int[]{3,1,5,8});
    }
}
