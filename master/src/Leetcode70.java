import java.util.Arrays;

/** 70. 爬楼梯 https://leetcode.cn/problems/climbing-stairs/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode70 {
    // 备忘录
    int[] dp;

    /**
     * 动态规划，自顶向下的递归
     * dp数组的定义：dp[n]到达第n层可选择的方法
     * 到达第n层有两种选择，从n-1层爬一层或者，从n-2层爬两层
     * 可以思考，从0-n-1和0到n-2的所有方法都不同，但是0-n-1-n只能在0-n-1的所有方法上在+1
     * 0-n-2-n这条路就可以加上2个1或者1个2，但是通过计算会和0-n-1-n中有些重叠，所以就等于（n-1）+（n-2）
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        // 初始化备忘录数组
        dp=new int[n+1];
        // 填充为无效值
        Arrays.fill(dp,-1);
        // 调用递归方法
        dp[n]=climbStairsHelp(n);
        return dp[n];
    }

    // 递归方法
    public int climbStairsHelp(int n){
        // 当本来就在0阶不需要爬，或者小于0阶，无效范围
        if(n<=0){
            return 0;
        }
        // base case 到第一阶，只有一种办法
        if(n==1){
           return 1;
        }
        // base case 到第二阶，有两种办法
        if(n==2){
            return 2;
        }
        int res=0;
        // 当备忘录中不为无效值，从备忘录中取
        if(dp[n]!=-1){
            return dp[n];
        }
        // 爬n阶楼梯的结果由爬n-1层楼梯和爬n-2层楼梯的结果相加得来（可以选择爬一阶和爬两阶）
        res=climbStairsHelp(n-2)+climbStairsHelp(n-1);
        dp[n]=res;
        return res;
    }

    public static void main(String[] args) {
        Leetcode70 leetcode70 = new Leetcode70();
        leetcode70.climbStairs(2);
    }
}
