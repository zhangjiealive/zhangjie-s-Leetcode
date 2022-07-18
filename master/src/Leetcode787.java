import java.util.Arrays;
/** 787. K 站中转内最便宜的航班 https://leetcode.cn/problems/cheapest-flights-within-k-stops/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // dp数组 k+2代表可以走的步数，+2是因为，如果k为1，代表只能转机1次，代表有2次飞机可以做，dp[0]代表没有坐飞机dp[1]代表做了一次飞机dp[2]代表做了两次飞机
        int[][] dp=new int[k+2][n];
        // 填充数组 填充为无效值，不可以为int的最大值，因为会进行加法，会溢出
        for (int[] a:dp) {
            Arrays.fill(a,1000000);
        }
        // base case:还没做航班，在起点时，价格为0
        dp[0][src]=0;
        // 从第一次航班开始：选择
        for (int t = 1; t <=k+1 ; t++) {
            // 可供选择的路线(第一次航班可选择的必须由起点开始，第二次可选择的航班起点必须由第一次航班的终点开始
            // 每次的起点都必须是上次的终点 以此类推
            // 例如起点为src，那么t=1代表第一次航班，只有from是src的航班才有结果，因为此时起点只有从src
            // 从src开出后t=2，代表第二次航班，只有从0开出的航班(0,1),(0,2)，那么代表目前可以从1，2开始
            for (int[] a:flights) {
                int from=a[0];
                int to=a[1];
                int price=a[2];
                // dp[t][to]根据dp[t-1][from]转移而来，如果dp[t-1][from]为100000，则代表前缀子问题无解
                // 去找上次航班的终点为此次航班起点的航班的值，如果为100000则代表不存在
                dp[t][to]=Math.min(dp[t][to],dp[t-1][from]+price);
            }
        }
        int res=1000000;
        // 从dst位置，不论几次航班只要从中取出最小值即可
        for (int t = 0; t <=k+1 ; t++) {
            res=Math.min(res,dp[t][dst]);
        }
        // 当res还为1000000时代表无法到达目的地
        return res==1000000?-1:res;
    }

    public static void main(String[] args) {
        Leetcode787 leetcode787 = new Leetcode787();
        leetcode787.findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 1);
    }
}
