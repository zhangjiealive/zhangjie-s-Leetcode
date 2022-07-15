import java.util.Arrays;

public class Leetcode787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] dp=new int[k+2][n];
        for (int[] a:dp) {
            Arrays.fill(a,1000000);
        }
        dp[0][src]=0;
        for (int t = 1; t <=k+1 ; t++) {
            for (int[] a:flights) {
                int from=a[0];
                int to=a[1];
                int price=a[2];
                dp[t][to]=Math.min(dp[t][to],dp[t-1][from]+price);
            }
        }
        int res=1000000;
        for (int t = 0; t <=k+1 ; t++) {
            res=Math.min(res,dp[t][dst]);
        }
        return res==1000000?-1:res;
    }

    public static void main(String[] args) {
        Leetcode787 leetcode787 = new Leetcode787();
        leetcode787.findCheapestPrice(
                3,
                new int[][]{{0,1,100},{1,2,100},{0,2,500}},
        0,
        2,
        1);
    }
}
