/** 1541. 平衡括号字符串的最少插入次数 https://leetcode.cn/problems/minimum-insertions-to-balance-a-parentheses-string/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode1541 {
    /**
     * 遍历一次字符串
     * 一个左括号，匹配两个右括号
     * @param s
     * @return
     */
    public int minInsertions(String s) {
        // 需要右括号的数量
        int need=0;
        // 插入左括号和右括号的和
        int res=0;
        for (char c: s.toCharArray()) {
            // 当c为左括号
            if(c=='('){
                // 对右括号的需求量+2
                need=need+2;
                // 当对右括号的需求为奇数，则插入一个右括号(要把右括号的需求量控制为偶数，因为一个左括号匹配两个右括号)
                if(need%2==1){
                    // 插入一个右括号
                    res++;
                    // 右括号的需求-1
                    need=need-1;
                }
            }
            // 当c为右括号
            else if(c==')'){
                // 对右括号的需求-1
                need--;
                // 如果对右括号的需求为-1，则插入一个左括号
                if(need==-1){
                    // 插入一个左括号
                    res++;
                    // 右括号的需求为1 （-1+2=1）
                    need=1;
                }
            }
        }
        // 字符串遍历结束后，插入左右括号的数量和对右括号的需求量加起来就是结果
        return res+need;
    }
}
