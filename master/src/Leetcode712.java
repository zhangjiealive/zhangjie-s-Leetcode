import java.util.Arrays;

/** 712. 两个字符串的最小ASCII删除和 https://leetcode.cn/problems/minimum-ascii-delete-sum-for-two-strings/
 * 关联583
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode712 {
    int[][] memo;
    public int minimumDeleteSum(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        memo=new int[n][m];
        for (int[] a:memo) {
            Arrays.fill(a,-1);
        }
        return dp(s1,0,s2,0);
    }

    public int dp(String word1,int i,String word2,int j){
        int res=0;
        // 如果word1字符串走完了，那么需要删除的是word2剩下的所有，用res累加
        if(i==word1.length()){
            for (; j <word2.length() ; j++) {
                res=res+word2.charAt(j);
            }
            return res;
        }
        // 如果word2字符串走完了，那么需要删除的是word1剩下的所有，用res累加
        if(j==word2.length()){
            for (; i <word1.length() ; i++) {
                res=res+word1.charAt(i);
            }
            return res;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        if(word1.charAt(i)==word2.charAt(j)){
            memo[i][j]=dp(word1,i+1,word2,j+1);
        }
        else{
            // 计算某个是更小的结果
            memo[i][j]=Math.min((word1.charAt(i)+dp(word1, i+1, word2, j)),(word2.charAt(j)+dp(word1, i, word2, j+1)));
        }
        return memo[i][j];
    }

    public static void main(String[] args) {
        Leetcode712 leetcode712 = new Leetcode712();
        leetcode712.minimumDeleteSum("ccaccjp", "fwosarcwge");
    }
}
