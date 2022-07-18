import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/** 514. 自由之路 https://leetcode.cn/problems/freedom-trail/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode514 {
    /**
     * 动态规划：自底向上的迭代
     * @param ring
     * @param key
     * @return
     */
    public int findRotateSteps(String ring, String key) {
        int n=ring.length();
        int m=key.length();
        // 存储各键位的索引
        HashMap<Character, List<Integer>> charToIndex=new HashMap<>();
        // dp数组，m*n
        int[][] dp=new int[m][n];
        for (int i = 0; i < n; i++) {
            char c=ring.charAt(i);
            // 如果不存在这个键，则在此键对应位置建立list
            if(!charToIndex.containsKey(c)){
                charToIndex.put(c,new LinkedList<>());
            }
            // 把此索引位放入此list
            charToIndex.get(c).add(i);
        }
        // 全部填充为不可能的值
        for (int[] a: dp) {
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        // base case:key的第0位输入的步数是从ring第0位到与key此位相同的位，顺时针或逆时针转动的最小值
        for (int i :charToIndex.get(key.charAt(0))) {
            dp[0][i]=Math.min(i,n-i)+1;
        }
        // 需要输入的字符数
        for (int i = 1; i <m ; i++) {
            // map中取出此key的下标位置
            for (int j: charToIndex.get(key.charAt(i))) {
                // map中取出之前一位key的下标位置
                for (int k:charToIndex.get(key.charAt(i-1))) {
                    // dp[i][j]由dp[i-1][k]+从上一位转动完的位置转动这一位需要转动的次数转移而来，因为j,k可能都有多个选择，所以每次需要和dp[i][j]进行比较，取最小值
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k))+1);
                }
            }
        }
        // 找出最后一行的最小值
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }
    int[][] memo;
    HashMap<Character, List<Integer>> charToIndex;
    /**
     * 动态规划：自顶向下的递归
     * @param ring
     * @param key
     * @return
     */
    public int findRotateSteps1(String ring, String key) {
        int n=ring.length();
        int m=key.length();
        // 备忘录
        memo=new int[n][m];
        // 存储各键位的索引
        charToIndex=new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c=ring.charAt(i);
            // 如果不存在这个键，则在此键对应位置建立list
            if(!charToIndex.containsKey(c)){
                charToIndex.put(c,new LinkedList<>());
            }
            // 把此索引位放入此list
            charToIndex.get(c).add(i);
        }
        // 从0，0开始递归
        return dp(ring,0,key,0);
    }

    public int dp(String ring,int i,String key,int j){
        // base case 当j==key.length相当于已经全部输入完了
        if(j==key.length()){
            // 步数为1
            return 0;
        }
        // 当备忘录中为有效值，直接取出
        if(memo[i][j]!=0){
            return memo[i][j];
        }
        int m=ring.length();
        int res=Integer.MAX_VALUE;
        // 根据字母取出map中可选的值
        for (int k:charToIndex.get(key.charAt(j))) {
            // 顺时针旋转的步数
            int delta=Math.abs(k-i);
            // 逆时针旋转的步数
            // 找较小的
            delta=Math.min(delta,m-delta);
            // 去解决子问题，从k位置，因为目前已经转动到k位置了，因为k位置有对于j的值
            int subProblem=dp(ring,k, key, j+1);
            // 整个问题就等于本次问题的解加上子问题的解
            res=Math.min(res,1+delta+subProblem);
        }
        // 每次将结果存入备忘录
        memo[i][j]=res;
        return res;
    }

    public static void main(String[] args) {
        Leetcode514 leetcode514 = new Leetcode514();
        leetcode514.findRotateSteps(

                "godding",
                "gd");
    }
}
