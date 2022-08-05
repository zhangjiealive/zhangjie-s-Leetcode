/** 474. 一和零 https://leetcode.cn/problems/ones-and-zeroes/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode474 {
    /**
     * 01背包问题
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        // dp数组定义：dp[i][j] 0的个数为i，1的个数为j时最大的子集长度
        int[][] dp=new int[m+1][n+1];
        // 最外层循环，选择
        for (String s: strs) {
            int oneCount=0;
            int zeroCount=0;
            // 遍历此字符串，对每个String的0和1进行计数
            for (char c: s.toCharArray()) {
                if(c=='0'){
                    zeroCount++;
                }
                else {
                    oneCount++;
                }
            }
            // i为m，不可小于此字符串0的数量，背包的两种容量
            for (int i = m; i >=zeroCount; i--) {
                // j为n，不可小于此字符串1的数量 背包的两种容量
                for (int j = n; j >=oneCount; j--) {
                    // 两种状态：由不放进子集，和放进子集这两种状态中找出最大的
                    dp[i][j]=Math.max(dp[i][j],dp[i-zeroCount][j-oneCount]+1);
                }
            }
        }
        return dp[m][n];
    }
}
