//22. 括号生成

import java.util.LinkedList;
import java.util.List;

/** 力扣22题 https://leetcode.cn/problems/generate-parentheses/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode22 {
    List<String> res=new LinkedList<>();
    StringBuilder sb=new StringBuilder();
    public List<String> generateParenthesis(int n) {
        generateParenthesisHelp(n,0,0);
        return res;
    }

    /**
     * 回溯算法：基于dfs，括号生成
     * 思路：先拼左括号，左括号的数量不超过总括号数量，右括号的数量不能超过当前左括号
     * @param n
     * @param left
     * @param right
     */
    public void generateParenthesisHelp(int n,int left,int right) {
        // 当字符串的大小和括号数量对应（符合条件，加入结果集）相当于剪枝操作
        if(sb.length()==n*2){
            // 则将此字符串加入结果集
            res.add(sb.toString());
            return;
        }
        // 当左括号还有剩余
        if(n>left){
            // 添加左括号
            sb.append('(');
            // 将左括号数量+1继续dfs
            generateParenthesisHelp(n,left+1,right);
            // 回溯
            sb.deleteCharAt(sb.length()-1);
        }
        // 当左括号比右括号多
        if(right<left){
            // 添加右括号
            sb.append(')');
            // 将右括号数量+1继续dfs
            generateParenthesisHelp(n,left,right+1);
            // 回溯
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        Leetcode22 leetcode22 = new Leetcode22();
        leetcode22.generateParenthesis(3);
    }
}
