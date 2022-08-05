import java.util.ArrayDeque;
import java.util.Deque;
/** 32. 最长有效括号 https://leetcode.cn/problems/longest-valid-parentheses/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode32 {
    /**
     * 使用栈
     * 思路：进栈的是下标，而不是括号，在一定的条件下，更新下标，更新最大值
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        // 核心结构：栈
        Deque<Integer> stack=new ArrayDeque<>();
        int max=0;
        // 先压入-1，保证栈不为空，也是防止接下来栈为空报错
        stack.push(-1);
        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            // 当前指针为（时，压栈
            if(c=='('){
                stack.push(i);
            }
            // 为）时
            else {
                // 先默认出栈
                stack.pop();
                // 当栈为空，压栈
                if(stack.isEmpty()){
                    stack.push(i);
                }
                // 不为空时，根据栈中下标进行更新
                else {
                    max=Math.max(max,i-stack.peek());
                }
            }
        }
        return max;
    }

    /**
     * 动态规划
     * @param s
     * @return
     */
    public int longestValidParentheses1(String s) {
        // max初始化
        int max = 0;
        // 为了方便初始化 base case dp[0]=0 dp[1]=0
        s = " " + s;
        // dp数组定义 dp[1]为字符串1位置的最长有效括号长度
        int[] dp = new int[s.length()];
        // 从2开始，因为2开始才能匹配到两个完整的括号
        for (int i = 2; i < s.length(); i++) {
            // 如果i位置为右括号
            if (s.charAt(i) == ')') {
                // 判断前一个位置是否为左括号，如果是，此位置的最长有效括号长度由dp[i-2]转移而来在加上此次加上的两个括号
                if (s.charAt(i - 1) == '(') {
                    dp[i] = dp[i - 2] + 2;
                }
                // 如果前一个位置不是，但是前面有左括号
                // 可以理解为（（））这类
                // 根据dp[i-1]的值可以得到一个区间，这个区间中都是有效括号
                // 得到i - dp[i - 1] - 1是前面的左括号，那么i位置的有效括号数，应该为i-1位置的有效括号数加上左括号之前的有效括号数在加上此次加上的两个括号
                else if (s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                }
                // 每次循环更新最大值
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
