import java.util.Arrays;

/** 516. 最长回文子序列 https://leetcode.cn/problems/longest-palindromic-subsequence/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode516 {
    /**
     * 自底向上的迭代
     * 深入理解，自底向下
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        // dp数组
        int[][] dp=new int[n][n];
        // base case 每个字符都是长度为1的最长回文子序列
        for (int i = 0; i < n; i++) {
            // 在对角线赋值
            dp[i][i]=1;
        }
        // 斜着遍历
        for (int l = 2; l <=n; l++) {
            for (int i = 0; i <= n-l; i++) {
                int j=l+i-1;
                // 想计算0-3之间的最长回文子序列要得到02，13，12位置的值，自底向上（根据最底下的值往上求）
                if(s.charAt(i)==s.charAt(j)){
                    // 当i和j指向位置的字符串相等时，dp[i][j]为dp[i+1][j-1]的值+2
                    dp[i][j]=dp[i+1][j-1]+2;
                }
                // 当不相同时，将i往后移一位，或者把j往前移一位，取最大的
                else {
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        // dp[0][n-1]位置放的就是此字符串0-n-1长度的最长回文子序列
        return dp[0][n-1];
    }

    int[][] memo;

    /**
     * 自顶向下的递归
     * @param s
     * @return
     */
    public int longestPalindromeSubseq1(String s) {
        int n=s.length();
        // 备忘录数组
        memo=new int[n][n];
        // 都填充为不可能的值，判别是否为有效值
        for (int[] a:memo) {
            Arrays.fill(a,-1);
        }
        return dp(s,0,n-1);
    }

    public int dp(String s,int left,int right) {
        // 当左右指针指向一起，此时回文子序列只为1
        if(left==right){
            return 1;
        }
        // 如果左指针大于右指针，则越界
        if(left>right){
            return 0;
        }
        // 当备忘录中为有效值，直接取
        if(memo[left][right]!=-1){
            return memo[left][right];
        }
        // 当左右指针位置指向的字符相同，左指针右移，右指针左移继续递归，并且回文子序列长度+2,因为至少这两个是回文子序列
        if(s.charAt(left)==s.charAt(right)){
            memo[left][right]=dp(s,left+1,right-1)+2;
        }
        // 否则左指针右移，右指针左移继续递归，取两个中的最大值
        else {
            memo[left][right]=Math.max(dp(s, left+1, right),dp(s, left, right-1));
        }
        return memo[left][right];
    }
}
