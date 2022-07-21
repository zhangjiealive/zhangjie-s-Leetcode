/** 645. 错误的集合 https://leetcode.cn/problems/set-mismatch/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode645 {
    /**
     * 思路，将出现的数字的下标位置置为负数，代表此位元素出现过，如果检测到此位已经为负数，则此位是重复元素，为正数的位置就是缺失的元素
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        // 先将重复的下标设为无效值-1
        int dup=-1;
        for (int i = 0; i < n; i++) {
            // 取当前数组位置，并取绝对值，因为后面可能会处理负数，直接取绝对值为正
            int index=Math.abs(nums[i])-1;
            // 如果已经小于0，则是重复元素
            if(nums[index]<0){
                dup=Math.abs(nums[i]);
            }
            // 不小于0代表，没有重复，将此位变为负数
            else {
                nums[index]=nums[index]*-1;
            }
        }
        int missing=-1;
        // 最后遍历数组找到唯一一个为正数的
        for (int i = 0; i < n; i++) {
            if(nums[i]>0){
                missing=i+1;
            }
        }
        return new int[]{dup,missing};
    }

    public static void main(String[] args) {
        Leetcode645 leetcode645 = new Leetcode645();
        int[] a=new int[]{3,2,3,4,6,5};
        leetcode645.findErrorNums(a);
    }
}
