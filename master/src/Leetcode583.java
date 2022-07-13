import java.util.Arrays;

/** 583. 两个字符串的删除操作 https://leetcode.cn/problems/delete-operation-for-two-strings/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode583 {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        memo=new int[n][m];
        for (int[] a:memo) {
            Arrays.fill(a,-1);
        }
        return dp(word1,0,word2,0);
    }

    public int dp(String word1,int i,String word2,int j){
        // 如果word1字符串走完了，那么需要删除的是word2剩下的所有
        if(i==word1.length()){
            return word2.length()-j;
        }
        // 如果word2字符串走完了，那么需要删除的是word1剩下的所有
        if(j==word2.length()){
            return word1.length()-i;
        }
        // 备忘录查询重复的值
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        // 如果指针指向的两个字符相同，则都向后移
        if(word1.charAt(i)==word2.charAt(j)){
            return dp(word1,i+1,word2,j+1);
        }
        // 否则判断删除哪个的步数更小，并加1
        memo[i][j]=Math.min(dp(word1, i+1, word2, j),dp(word1, i, word2, j+1))+1;
        return memo[i][j];
    }

    public static void main(String[] args) {
        Leetcode583 leetcode583 = new Leetcode583();
        leetcode583.minDistance("sea","eat");
    }
}
