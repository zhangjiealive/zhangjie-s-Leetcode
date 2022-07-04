//  Leetcode5.java

/** 力扣5题 https://leetcode.cn/problems/longest-palindromic-substring/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode5 {
    /**
     * 循环，将每个位置都当成中心传入palindrome
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String res="";
        int length=s.length();
        for (int i = 0; i < s.length(); i++) {
                String s2=palindrome(s,i,i+1);
                res=res.length()>s2.length()?res:s2;
                String s1=palindrome(s,i,i);
                res=res.length()>s1.length()?res:s1;
        }
        return res;
    }

    /**
     * 传入的是字符串的中心位置，往两边扩散找
     * @param s
     * @param l
     * @param r
     * @return
     */
    public String palindrome(String s,int l,int r){
        while(l>=0 && r<s.length()&&s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        // 返回的时候因为有一次循环后l--，r++但是此时条件不满足退出循环，返回时本来是l，r+1(左闭右开)，但是因为l--了一次，r++了一次，所以变成了（l+1,r)
        return s.substring(l+1,r);
    }

    public static void main(String[] args) {
        Leetcode5 leetcode5 = new Leetcode5();
        leetcode5.longestPalindrome("babad");
    }
}
