import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/** 241. 为运算表达式设计优先级 https://leetcode.cn/problems/different-ways-to-add-parentheses/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode241 {

    // 备忘录，解决重叠子问题
    HashMap<String,List<Integer>> memo=new HashMap<>();

    /**
     * 递归，分治，dfs
     * 思路：根据运算符分割字符串，不断递归往里，直到串中不存在运算符就当成数字返回，在不断递归返回进行计算
     * 递归：从最小的问题解决后去解决大的问题
     * 方法定义：将一个字符串按照运算符分割
     * @param expression
     * @return
     */
    public List<Integer> diffWaysToCompute(String expression) {
        // 当此分割方式在map中存在，直接返回
        if(memo.containsKey(expression)){
            return memo.get(expression);
        }
        // 结果集，每一层的结果集都不同
        List<Integer> res=new LinkedList<>();
        // 遍历整个字符串，从所有具有运算符的位置进行分割，会形成多种分割方式
        for (int i = 0; i < expression.length(); i++) {
            char c=expression.charAt(i);
            // 当是运算符，将此位置前后进行分割
            if(c=='-'||c=='+'||c=='*'){
                // 从宏观的角度来看(不进栈)，此left应该包含此位置分隔后，之前字符串按照不同位置分割后的所有计算结果
                // 在将此运算符之前的字符串当成新的字符串，递归进入方法
                List<Integer> left=diffWaysToCompute(expression.substring(0,i));
                // 从宏观的角度来看(不进栈)，此left应该包含此位置分隔后，之后字符串按照不同位置分割后的所有计算结果
                // 在将此运算符之后的字符串当成新的字符串，递归进入方法
                List<Integer> right=diffWaysToCompute(expression.substring(i+1));
                // 再将所有结果按照当前运算符组合起来
                for (int a:left){
                    for (int b: right) {
                        if(c=='+'){
                            res.add(a+b);
                        }
                        else if(c=='-'){
                            res.add(a-b);
                        }
                        else if(c=='*'){
                            res.add(a*b);
                        }
                    }
                }
            }
        }
        // base case 当递归执行到最底层，割到最后，字符中都只包含一个数字，此时还会递归调用，但是res中自然不会被添加值
        // 因为其中没有运算符，此时将此字符转为数字返回
        if(res.isEmpty()){
            res.add(Integer.parseInt(expression));
        }
        // 返回前加入结果集
        memo.put(expression,res);
        return res;
    }

    public static void main(String[] args) {
        Leetcode241 leetcode241 = new Leetcode241();
        leetcode241.diffWaysToCompute("0+1");
    }
}
