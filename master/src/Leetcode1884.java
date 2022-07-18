/** 1884. 鸡蛋掉落-两枚鸡蛋 https://leetcode.cn/problems/egg-drop-with-2-eggs-and-n-floors/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode1884 {
    int[][] memo;

    /**
     * 动态规划自顶向下的递归
     * @param n
     * @return
     */
    public int twoEggDrop(int n) {
        // dp数组，n+1楼因为从0楼开始，3因为一共2个鸡蛋，012个
        memo = new int[n+1][3];
        return dp(n, 2);
    }
    // 自顶向下的动态规划
    public int dp(int n, int k){
        // base case 楼层为0，只需要0次
        if(n == 0){
            return 0;
        }
        // base case 当只剩一个鸡蛋时，需要剩余楼层数的次数，依次从1到n
        if(k == 1){
            return n;
        }
        // 当备忘录中为有效值，去查询备忘录
        if(memo[n][k] != 0){
            return memo[n][k];
        }

        int res = Integer.MAX_VALUE;
        // 从1到n楼开始遍历
        //Math.max(dp(i-1, k-1), dp(n-i, k))中
        // dp(i-1,k-1)意为此时鸡蛋碎了，楼层的范围就从i缩小到了i-1，同时鸡蛋数量减1(例如本来鸡蛋为2，楼层为8，i为4，那么现在dp(i-1,k-1)就是1-3楼，1个鸡蛋)当成一个新的楼来看(1-3)
        // dp(n-i, k)意为此时鸡蛋没碎，范围可以缩小到扔鸡蛋没碎的这一层i到n之间(例如本来鸡蛋为2，楼层为8，i为4，那么现在dp(n-i, k)就是5-8楼，2个鸡蛋)当成一个新的楼(1-4)来看，在新的递归中，他不知道自己在原来是几楼
        // 重点：可以把这两种状态看成分成两栋楼了
        for(int i = 1; i <= n; i++){
            // 因为求最坏值所以Math.max(dp(i-1, k-1), dp(n-i, k)求最大值在+1，但是在所有结果中取最小值
            res = Math.min(res, Math.max(dp(i-1, k-1), dp(n-i, k)) + 1);
        }
        // 备忘录避免重叠子问题
        memo[n][k] = res;
        return res;
    }
}
