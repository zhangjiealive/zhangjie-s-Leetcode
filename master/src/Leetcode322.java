package likou;
//: Leetcode322.java
import java.util.Arrays;
/** 力扣322题零钱兑换 动态规划https://leetcode.cn/problems/coin-change/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode322 {
    // 自顶向下 递归
    public int coinChange(int[] coins, int amount) {
        // 备忘录，将之前的结果记下来，每次取找之前的结果
        int[] memo=new int[amount+1];
        // 填充不可能出现的结果
        Arrays.fill(memo,-9999);
        return coinChangeHelp(coins,amount,memo);
    }

    public int coinChangeHelp(int[] coins, int amount,int[] memo) {
        // 如果还需要换的钱为0，返回0
        if(amount==0) return 0; // base case基本状态
        // 如果还需要换的钱小于0，返回-1
        if(amount<0) return -1;  // base case基本状态
        // 只要备忘录中的信息修改过了，不是原本填充的信息，就返回备忘录中的值
        if(memo[amount]!=-9999) return memo[amount];
        // 结果，先取最大值
        int res=Integer.MAX_VALUE;
        // 将有的钱币种类的所有结果遍历
        for (int coin:
             coins) {
            // 将一个大问题拆成子问题，将需要换钱的数减去目前钱币的数值,一直去拆分，直到amount==0或者小于0，返回值
            int subProblem=coinChangeHelp(coins,amount-coin,memo);  //变量为amount，选择为coin
            // 如果子问题==-1，本次循环无效
            if(subProblem==-1){
                continue;
            }
            // res保存res和子问题+1中小的
            res=Math.min(subProblem+1,res);  // 求子问题的最小钱数 最终求出整个问题的最小钱数
        }
        // 只要本次res被替换了，就将其添加到备忘录
        // 理解：一直递归到最底层，才开始制作备忘录，之后的结果依靠备忘录生成
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return res==Integer.MAX_VALUE ? -1:res;
    }
    // 自底向上，迭代
    public int coinChange1(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        // 明确dp状态0时需要的钱数为0
        dp[0]=0;  // base case基本状态
        // 外层循环遍历所有状态的取值
        for (int i = 0; i < dp.length; i++) {
            // 内层for循环在求所有选择的取值
            for (int coin :
                    coins) {
                // 当目前的钱的面值大于要求的状态，继续内层循环循环
                if(i-coin<0){
                    continue;
                }
                /* dp[i]等于dp[i]和1+dp[i-coin]中的最小值，意思为从之前的状态中取 例如 目前i为5 coin为2 那么dp[5]应当等于dp[3]+1,因为目前正好coin为2，在dp[3]的基础
                *例如 目前i为5 coin为2 那么dp[5]应当等于dp[3]+1,因为目前正好coin为2，在dp[3]的基础加一张2块钱正好为dp[5]的值
                 */
                dp[i]=Math.min(dp[i],1+dp[i-coin]);
            }
        }
        // 判断此取值是否有效
        return (dp[amount]==amount+1)?-1:dp[amount];
    }

    public static void main(String[] args) {
        int[] a={1,2,5};
        Leetcode322 leetcode322 = new Leetcode322();
        leetcode322.coinChange(a,11);
    }
}
