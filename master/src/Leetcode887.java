/** 887. 鸡蛋掉落 https://leetcode.cn/problems/super-egg-drop/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode887 {
    int[][] memo;

    /**
     * 动态规划：自顶向下的递归
     * 思路:与1884题基本一致，但是因为多个鸡蛋，复杂度太高无法accpet
     * 所以用二分法进行优化
     * @param k
     * @param n
     * @return
     */
    public int superEggDrop(int k, int n) {
        memo = new int[n+1][k+1];
        return dp(n, k);
    }

    public int dp(int n, int k){
        // base case 楼层为0，只需要0次
        if(n == 0){
            return 0;
        }
        // base case 当只剩一个鸡蛋时，需要剩余楼层数的次数，依次从1到n
        if(k == 1){
            return n;
        }
        // 当备忘录中为有效值，取查询备忘录
        if(memo[n][k] != 0){
            return memo[n][k];
        }

        int left=1;
        int right=n;
        int res=Integer.MAX_VALUE;
        // 二分法
        while(right>=left) {
            int mid = (left + right) / 2;
            // dp(i-1,k-1)意为此时鸡蛋碎了，楼层的范围就从i缩小到了i-1，同时鸡蛋数量减1(例如本来鸡蛋为2，楼层为8，i为4，那么现在dp(i-1,k-1)就是1-3楼，1个鸡蛋)当成一个新的楼来看(1-3)
            int broke = dp(mid - 1, k - 1);
            // dp(n-i, k)意为此时鸡蛋没碎，范围可以缩小到扔鸡蛋没碎的这一层i到n之间(例如本来鸡蛋为2，楼层为8，i为4，那么现在dp(n-i, k)就是5-8楼，2个鸡蛋)当成一个新的楼(1-4)来看，在新的递归中，他不知道自己在原来是几楼
            int not_broke = dp(n - mid, k);
            // 选择两个中最大的（因为题目要找的最坏情况）
            if(broke>not_broke){
                // 根据谁是最坏情况决定下次的查找区间
                // 当碎了是最坏情况，直接右区间向左移
                right=mid-1;
                // 在所有结果中取最小值
                res=Math.min(res,broke+1);
            }
            else {
                // 当没碎是最坏情况，直接左区间向右移
                left=mid+1;
                // 在所有结果中取最小值
                res=Math.min(res,not_broke+1);
            }
        }
        // 更新备忘录
        memo[n][k] = res;
        return res;
    }
}
