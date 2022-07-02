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

    public void generateParenthesisHelp(int n,int left,int right) {
        if(sb.length()==n*2){
            res.add(sb.toString());
            return;
        }
        if(n>left){
            sb.append('(');
            generateParenthesisHelp(n,left+1,right);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right<left){
            sb.append(')');
            generateParenthesisHelp(n,left,right+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        Leetcode22 leetcode22 = new Leetcode22();
        leetcode22.generateParenthesis(3);
    }
}
