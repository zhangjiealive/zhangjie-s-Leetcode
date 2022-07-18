/** 10. 正则表达式匹配 https://leetcode.cn/problems/regular-expression-matching/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode10 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        // dp数组
        boolean[][] f = new boolean[m + 1][n + 1];
        // base case 当两个都为空串，匹配成功 或者f[m+1][n+1]=true当两个同时匹配完
        f[0][0] = true;
        // 因为base case是[0][0]所以遍历从01开始，除了00其他i0都是false，因为s还没有匹配完所以i只要不为0都为false
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                // p的第j位置为*，则转移[i][j-2]的状态(因为a_可以匹配0个a和n个a)，所以直接无视他，将他当成0个a
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    // 如果*前面的元素和现在i的元素相同
                    if (matches(s, p, i, j - 1)) {
                        // 则从f[i][j-2]和f[i-1][j]中转移
                        // [i][j-2]的状态(因为a_可以匹配0个a和n个a)，所以直接无视他，将他当成0个a
                        // [i-1][j]的状态(因为a_可以匹配0个a和n个a)，所以直接先当成一个a，继续用此a*，并将s指针前移1继续进行比较
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                }
                else {
                    // 如果字符匹配能直接转移[i-1][j-1]，指针分别往前移1
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    // 备忘录
    boolean[][] memo;
    public boolean isMatch1(String s, String p) {
        int n=s.length();
        int m=p.length();
        memo=new boolean[n+1][m+1];
        return dp(s,n,p,m);
    }

    public boolean dp(String s,int i,String p,int j){
        // base case 当j为0，i也为0时为true，意为两个空串
        if(j==0){
            return i==0;
        }
        // 当指针指向的字符串匹配
        if (matches(s,p,i,j)) {
            // 指针都前移1去执行子问题
            memo[i][j] = dp(s, i - 1, p, j - 1);
            // 当p此时指向为*
        } else if (p.charAt(j - 1) == '*') {
            // 则从f[i][j-2]和f[i-1][j]中转移
            // [i][j-2]的状态(因为a_可以匹配0个a和n个a)，所以直接无视他，将他当成0个a，p指针向前移2位
            // [i-1][j]的状态(因为a_可以匹配0个a和n个a)，所以直接先当成一个a，继续用此a*，并将s指针前移1继续进行比较
            memo[i][j]=dp(s,i,p,j-2);
            if(matches(s,p,i,j-1)){
                // 两个结果只要一种满足就为true
                memo[i][j]=memo[i][j]||dp(s,i-1,p,j);
            }
        }
        return memo[i][j];
    }

    /**
     * 辅助函数
     * 对字符进行匹配
     * 因为传的是第几个，所以数组索引要-1
     * @param s
     * @param p
     * @param i
     * @param j
     * @return
     */
    public boolean matches(String s, String p, int i, int j) {
        // 如果i=0则代表第-1个，数组越界
        if (i == 0) {
            return false;
        }
        // 如果p为.则能匹配任何字符
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }


    public static void main(String[] args) {
        Leetcode10 leetcode10 = new Leetcode10();
        leetcode10.isMatch("aa","a*");
    }

}
