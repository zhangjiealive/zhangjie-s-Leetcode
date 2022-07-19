/** 45. 跳跃游戏 II https://leetcode.cn/problems/jump-game-ii/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode45 {
    public int jump(int[] nums) {
        int n=nums.length;
        int end=0;
        int farthest=0;
        int step=0;
        for (int i = 0; i < n - 1; i++) {
            farthest=Math.max(nums[i]+i,farthest);
            if(end==i){
                step++;
                end=farthest;
            }
        }
        return step;
    }
}
