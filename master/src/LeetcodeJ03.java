import java.util.HashSet;

/** 剑指 Offer 03. 数组中重复的数字 https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class LeetcodeJ03 {
    /**
     * 运用hashset的contains判断
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        int n=nums.length;
        HashSet<Integer> set=new HashSet<>();
        // 遍历一次数组
        for (int i = 0; i < n; i++) {
            // 如果已经存在，直接返回
            if(set.contains(nums[i])){
                return nums[i];
            }
            // 正常加入set
            set.add(nums[i]);
        }
        return -1;
    }

}
