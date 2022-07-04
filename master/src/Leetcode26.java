//26. 删除有序数组中的重复项

/** 力扣26题 https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode26 {
    /**
     * 快慢指针 因为是有序数据，所以当快指针和慢指针指向相同的元素时，让快指针去找一个不同的元素
     * 找到以后把慢指针后面一个元素修改为快指针指向的元素，当快指针走完，慢指针以及慢指针之前的元素都是不重复的，因为返回的是元素个数所以在索引的基础上+1
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int left=0;
        int right=0;
        while(right<nums.length){
            if(nums[left]!=nums[right]){
                left++;
                nums[left]=nums[right];
            }
            right++;
        }
        return left+1;
    }
}
