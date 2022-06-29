//: LeetcodeJ91.java

/** 力扣剑指 Offer II 091题 https://leetcode.cn/problems/JEj789/?show=1
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class LeetcodeJ91 {
    public int minCost(int[][] costs) {
        int n=costs.length;
        int a=costs[0][0];
        int b=costs[0][1];
        int c=costs[0][2];
        for (int i = 1; i < n; i++) {
            int d=costs[i][0]+Math.min(b,c);
            int e=costs[i][1]+Math.min(a,c);
            int f=costs[i][2]+Math.min(b,a);
            a=d;
            b=e;
            c=f;
        }
        return Math.min(Math.min(a,b),c);
    }

    public static void main(String[] args) {
        LeetcodeJ91 leetcodeJ91 = new LeetcodeJ91();
        int[][] a={{17,2,17},{16,16,5},{14,3,19}};
        leetcodeJ91.minCost(a);
    }
}
