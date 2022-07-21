/** 45. 跳跃游戏 II https://leetcode.cn/problems/jump-game-ii/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode45 {
    /**
     * 贪心算法
     * 求到达终点的最短步数
     * 思路：在每次的范围中找到最大的可移动范围，最终得到最短的步数
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int n=nums.length;
        // end控制区间，
        int end=0;
        int farthest=0;
        int step=0;
        for (int i = 0; i < n - 1; i++) {
            // 在范围内找最大的可移动范围
            farthest=Math.max(nums[i]+i,farthest);
            // 到达一段的终点就更新查找范围和步数
            // 例如第一次，end=0；i=0，将end更新至nums[i]+i和farthest中的最大值，第一次肯定是nums[i]+i大，因为此时farthest=0
            // 那么下次在i==end时，再次更新，直到循环结束
            if(end==i){
                step++;
                // 更新下次查找的范围
                end=farthest;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        Leetcode45 leetcode45 = new Leetcode45();
        leetcode45.jump(new int[]{2,3,1,1,4});
    }
}
