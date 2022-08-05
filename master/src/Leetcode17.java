import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/** 17. 电话号码的字母组合 https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode17 {
    // 结果集
    List<String> res;
    // 可拼接字符串
    StringBuilder sb;
    int n;
    public List<String> letterCombinations(String digits) {
        // 当字符串为空，返回空的list
        if(digits==""||digits.equals("")){
            return new ArrayList<>();
        }
        sb=new StringBuilder();
        res=new LinkedList<>();
        n=digits.length();
        // 从0位置开始回溯算法
        letterCombinationsHelp(digits,0);
        return res;
    }

    /**
     * 回溯算法
     * @param digits
     * @param i
     */
    public void letterCombinationsHelp(String digits,int i) {
        // 当字符串的长度等于需要的字符
        if(sb.length()==n){
            // 加入res集合
            res.add(sb.toString());
            return;
        }
        // 从帮助函数中取得数组进行遍历
        for (char c:help(digits.charAt(i))) {
            // 选择
            sb.append(c);
            // 递归调用
            letterCombinationsHelp(digits,i+1);
            // 撤销选择
            sb.deleteCharAt(sb.length()-1);
        }
        return;
    }

    // 根据字符，返回对应的字符数组
    public char[] help(char c) {
        switch (c){
            case '2':return new char[]{'a','b','c'};
            case '3':return new char[]{'d','e','f'};
            case '4':return new char[]{'g','h','i'};
            case '5':return new char[]{'j','k','l'};
            case '6':return new char[]{'m','n','o'};
            case '7':return new char[]{'p','q','r','s'};
            case '8':return new char[]{'t','u','v'};
            case '9':return new char[]{'w','x','y','z'};
            default:return null;
        }
    }

    public static void main(String[] args) {
        Leetcode17 leetcode17 = new Leetcode17();
        leetcode17.letterCombinations("23");
    }
}
