package likou;
//: Leetcode136.java

/** 力扣136题 https://leetcode.cn/problems/single-number/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode136 {
    public int singleNumber(int[] nums) {
        int s=0;
        for (int i = 0; i < nums.length; i++) {
            s=s^nums[i];
            }
        return s;
    }
}
