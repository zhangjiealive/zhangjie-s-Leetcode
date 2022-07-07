//: Leetcode96.java

/** 力扣96. 不同的二叉搜索树 https://leetcode.cn/problems/unique-binary-search-trees/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode96 {
    int[][] memo;
    public int numTrees(int n) {
        memo=new int[n+1][n+1];
        return numTreesHelp(n,1,n);
    }

    public int numTreesHelp(int n,int start,int end) {
        if(start>end){
            return 1;
        }
        if(memo[start][end]!=0){
            return memo[start][end];
        }
        int res=0;
        for (int i = start; i <= end; i++) {
            int left=numTreesHelp(n,start,i-1);
            int right=numTreesHelp(n,i+1,end);
            res+=left*right;
        }
        memo[start][end]=res;
        return res;
    }
}
