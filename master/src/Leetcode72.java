import java.util.Arrays;

/** 72. 编辑距离 https://leetcode.cn/problems/edit-distance/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode72 {
    // 备忘录
    int[][] memo;
    /**
     * 动态规划（自顶向下）
     * base case：当任意一个字符串走完了，另一个字符串没有走完，剩余的步数为没有走完字符串的剩余长度+1(因为0也要走一步，0下标也是有值的)
     * 状态：两个字符串相等
     * 选择：
     * dp(word1, i, word2, j - 1)对应word1插入一个字符，所以将word2指针前移继续和word1比较
     * dp(word1, i - 1, word2, j)对应word1删除一个字符，所以将word1指针前移继续和word2比较
     * dp(word1, i - 1, word2, j - 1)对应word1替换一个字符，因为替换成和word2对应位置的字符所以这一位相同，都前移继续比较
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        // 建立一个m行n列的二维数组
        memo=new int[m][n];
        for (int i = 0; i < m; i++) {
            // 填充为无效步数(因为两个字符串最大为500，所以最多501步全部替换掉)
            Arrays.fill(memo[i],666);
        }
        return dp(word1,m-1,word2,n-1);
    }

    public int dp(String word1,int i,String word2,int j){
        // base case:任意一个字符串已经走完
        if(i==-1){
            return j+1;
        }
        // base case:任意一个字符串已经走完
        if(j==-1){
            return i+1;
        }
        // 当备忘录中是有效值，直接返回备忘录中的结果（memo[i][j]意为word1指针指向i，word2指针指向j时的最短距离）
        if(memo[i][j]!=666){
            return memo[i][j];
        }
        // 当目前这一位相同，返回将两个指针都前移的结果
        if(word1.charAt(i)==word2.charAt(j)){
            return dp(word1,i-1,word2,j-1);
        }
        // 当这一位不相同，则从3种选择中，找出最小的步数在+1，放入备忘录
        else {
            memo[i][j] = Math.min(dp(word1, i, word2, j - 1), Math.min(dp(word1, i - 1, word2, j), dp(word1, i - 1, word2, j - 1))) + 1;
        }
        // 返回备忘录中的值
        return memo[i][j];
    }
}
