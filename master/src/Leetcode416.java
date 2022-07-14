import java.util.Arrays;

/** 416. 分割等和子集 https://leetcode.cn/problems/partition-equal-subset-sum/
 * 子集背包问题，可分解为01背包问题
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode416 {
    int[][] memo;

    /**
     * 自顶向下的递归，有问题
     * 备忘录有时不能发挥作用
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int count=0;
        for (int a : nums) {
            count=count+a;
        }
        if(count%2!=0){
            return false;
        }
        count=count/2;
        memo=new int[nums.length+1][count+1];
        for (int[] a: memo) {
            Arrays.fill(a,-666);
        }

        return dp(nums,count,nums.length-1)==1?true:false;
    }

    public int dp(int[] nums,int count,int i) {
        if(count==0){
            return 1;
        }
        if(count<0||i<0){
            return -666;
        }
        if(memo[i][count]!=-666){
            return memo[i][count];
        }
        if(count-nums[i]<0){
            memo[i][count]= dp(nums,count,i-1);
        }
        else {
            if(dp(nums,count,i-1)==1||dp(nums, count-nums[i], i-1)==1)
            memo[i][count]=1;
            }
        return memo[i][count];
    }

    /**
     * 自底向下的迭代
     * 得到最终的结果是不断依赖之前的结果转移而来
     * 分割成两个等和子集可以分解为01背包问题
     * 将所有和加起来除以2，就是背包可承载的重量
     * 数组中所有的值就是背包可选择的物品
     * @param nums
     * @return
     */
    public boolean canPartition1(int[] nums) {
        int count=0;
        int n=nums.length;
        for (int a : nums) {
            count=count+a;
        }
        // 如果和是奇数，一定不能分解成2个和相同的子集
        if(count%2!=0){
            return false;
        }
        count=count/2;
        // memo[0][j]代表没有物品可选择，memo[i][0]代表背包已经装满
        // dp数组，因为base case为memo[0][j] memo[i][0]所以二维数组各扩大1
        // dp[i][j]=x表示，前i个物品，i从1开始计数，当前背包容量为j时，若x为true，则刚刚好把背包装满，否则不能装满
        boolean[][] memo=new boolean[n+1][count+1];
        // 设置base case当j（背包容量为0时，已经装满，为true）,当i为0，已经没有任何可选择的物品，为false，因为boolean类型默认初始化为false，所以这里不用初始化
        for (int i = 0; i <= n; i++) {
            memo[i][0]=true;
        }
        // 先得到[1][1]在计算[2][2]时会需要[1][1]
        // i代表着有几个可选择的物品(注意物品数组的下标要-1)
        for (int i = 1; i <= n; i++) {
            // j代表着背包的容量
            for (int j = 1; j <= count; j++) {
                // 当目前的背包容量，容不下当前物品的重量
                if(j-nums[i-1]<0){
                    // 选择不将此物品放入背包，此状态通过memo[i-1][j]转移而来
                    memo[i][j]=memo[i-1][j];
                }
                // 当前背包容量容得下
                else {
                    // 可以选择不放入此物品(此状态通过memo[i-1][j]转移而来)或将此物品放入背包(此状态通过memo[i-1][j-nums[i-1]])
                    // memo[i-1][j]代表不选择此物品，物品指针向前，容量不变，memo[i-1][j-nums[i-1]]代表选择此物品，物品指针向前，容量减去放入物品的重量
                    memo[i][j]=memo[i-1][j]||memo[i-1][j-nums[i-1]];
                }
            }
        }
        // 返回n个物品，count重量是否能放下的结果
        return memo[n][count];
    }

    public static void main(String[] args) {
        int[] a={100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97};
        Leetcode416 leetcode416 = new Leetcode416();
        System.out.println(leetcode416.canPartition1(a));
    }
}
