/** 392. 判断子序列 https://leetcode.cn/problems/is-subsequence/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode392 {
    /**
     * 双指针
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int i=0;
        int j=0;
        // 两个指针分别在s和t上走
        while(i<s.length()&&j<t.length()){
            // 匹配上了，i往前走，继续下一次匹配
            if(s.charAt(i)==t.charAt(j)){
                i++;
            }
            // 无论是否匹配成功j都往前走
            j++;
        }
        // 看看i指针是否走完了s的全程，即可判断是否全部匹配上，是否是子序列
        return i==s.length();
    }
}
