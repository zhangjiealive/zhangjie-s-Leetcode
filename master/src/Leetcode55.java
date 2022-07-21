/** 55. 跳跃游戏 https://leetcode.cn/problems/jump-game/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode55 {
    /**
     * 贪心算法
     * 思路：找到可移动的长度
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int farthest=0;
        for (int i = 0; i < n - 1; i++) {
            // 找他们当中的最长步数（nums[i]代表这一位上可以走的步数+i是他所在的位置）
            farthest=Math.max(nums[i]+i,farthest);
            // 当出现0（nums[i]+i就等于i），并且前面的所有步数都跨不过这个0（之前的fartherst还小于或等于0位的nums[i]+i），直接返回false
            if(farthest<=i){
                return false;
            }
        }
        // 循环结束，看看是否到达数组末尾
        return farthest>=n-1;
    }

    public static void main(String[] args) {
        Leetcode55 leetcode55 = new Leetcode55();
        leetcode55.canJump(new int[]{3,2,1,0,4});
    }
}
