//  Leetcode167.java

/** 力扣167题 https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode167 {
    /**
     * 左右指针解法
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int left=0;
        int right=numbers.length-1;
        // 左右指针，只要两个指针不相交就循环
        while (left<right){
            int count=numbers[left]+numbers[right];
            // 当左右指针加起来等于target，直接返回left，right，因为下标是从1开始，所以都要+1
            if(count==target){
                return new int[]{left+1,right+1};  // 或者将这里break，触发最下面的返回值
            }
            // 当左右指针加起来小于target，左指针往右移，使count增大
            else if(count<target){
                left++;
            }
            // 当左右指针加起来大于target，右指针往左移，使count减小
            else {
                right--;
            }
        }
        return new int[]{left+1,right+1};
    }
}
