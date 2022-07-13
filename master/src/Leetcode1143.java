import java.util.Arrays;

/** 1143. 最长公共子序列 https://leetcode.cn/problems/longest-common-subsequence/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode1143 {
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        memo=new int[n][m];
        // 填充为不可能的结果
        for (int[] a: memo) {
            Arrays.fill(a,-6666);
        }
        // 从两个字符串开头开始
        int res=dp(text1,0,text2,0);
        return res;
    }

    public int dp(String text1,int i, String text2,int j) {
        // base case当一个字符串为空，此时最长公共子序列为0
        if(i==text1.length()||j==text2.length()){
            return 0;
        }
        // 当备忘录中为有效值，直接取备忘录的值
        if(memo[i][j]!=-6666){
            return memo[i][j];
        }
        // 如果遇到相同的字符则两个指针后移，子序列长度加一继续递归
        if(text1.charAt(i)==text2.charAt(j)){
            memo[i][j]=dp(text1,i+1,text2,j+1)+1;
            return memo[i][j];
        }
        /**
         * 如果不相同，则在三种选择中选择最大的
         * 1:text1[i]不在text2中，i后移
         * 2:text2[j]不在text1中，j后移
         * 3:text1[i]不在text2中，text2[j]也不在text1中，i,j都后移
         */
        else {
            memo[i][j]=Math.max(dp(text1,i+1,text2,j),Math.max(dp(text1,i+1,text2,j+1),dp(text1,i,text2,j+1)));
        }
        return memo[i][j];
    }
}
