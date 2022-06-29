package likou;
/*动态规划基本思路
    1、确定base case基本状态
    2、确定状态，就是原问题和子问题中的变量
    3、确定选择，导致状态发生变化的行为
    4、明确dp函数/数组的定义，要做什么，求什么
 */
public class DynamicProgramming {
    // 自顶向下，递归
    void dp(){
        /*
        for 选择：所有可能的选择{
        此时状态时随着选择而改变
        result=求最值（result，dp（状态1，状态2，。。。。。。））
        return result；
        }
         */
    }
    // 自底向下，迭代
    void dp1(){
        /*
        dp[0][0]=base case
        进行状态转移
        for 状态1：状态1的所有选择{
            for 状态2：状态2的所有选择{
                for ...{
                    dp[状态1][状态2][...]=求最值（选择1,选择2...）
        }
         */
    }
}
