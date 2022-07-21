//: Leetcode136.java

/** 力扣136题 https://leetcode.cn/problems/single-number/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode136 {
    /**
     * 位运算
     * 一个数与本身异或^结果为0，一个数与0做异或，结果为本身
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int s=0;
        for (int i = 0; i < nums.length; i++) {
            s=s^nums[i];
            }
        return s;
    }

    public static void main(String[] args) {
        int[] a=new int[]{6,4,2,4,6};
        System.out.println(new Leetcode136().singleNumber(a));
    }
}
