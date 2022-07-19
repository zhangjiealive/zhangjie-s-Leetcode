/** 55. 跳跃游戏 https://leetcode.cn/problems/jump-game/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode55 {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int farthest=0;
        for (int i = 0; i < n - 1; i++) {
            farthest=Math.max(nums[i]+i,farthest);
            if(farthest<=i){
                return false;
            }
        }
        return farthest>=n-1;
    }

    public static void main(String[] args) {
        Leetcode55 leetcode55 = new Leetcode55();
        leetcode55.canJump(new int[]{3,2,1,0,4});
    }
}
