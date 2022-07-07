//: Leetcode493.java

/** 力扣493. 翻转对  https://leetcode.cn/problems/reverse-pairs/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode493 {
    int count=0;

    /**
     * 翻转对：需要nums[i]>nums[j]*2,利用每次归并排序合并
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        sort(nums);
        return count;
    }

    private int[] temp;

    public void sort(int[] nums) {
        // 先给辅助数组开辟内存空间
        temp = new int[nums.length];
        // 排序整个数组（原地修改）
        sort(nums, 0, nums.length - 1);
    }

    // 定义：将子数组 nums[lo..hi] 进行排序
    private void sort(int[] nums, int lo, int hi) {
        if (lo == hi) {
            // 单个元素不用排序
            return;
        }
        // 这样写是为了防止溢出，效果等同于 (hi + lo) / 2
        int mid = lo + (hi - lo) / 2;
        // 先对左半部分数组 nums[lo..mid] 排序
        sort(nums, lo, mid);
        // 再对右半部分数组 nums[mid+1..hi] 排序
        sort(nums, mid + 1, hi);
        // 将两部分有序数组合并成一个有序数组
        merge(nums, lo, mid, hi);
    }

    // 将 nums[lo..mid] 和 nums[mid+1..hi] 这两个有序数组合并成一个有序数组
    private void merge(int[] nums, int lo, int mid, int hi) {
        // 先把 nums[lo..hi] 复制到辅助数组中
        // 以便合并后的结果能够直接存入 nums
        for (int i = lo; i <= hi; i++) {
            temp[i] = nums[i];
        }
        // 两个表没合并前
        int end=mid+1;
        // 因为数组是有序的，所以当nums[i]>nums[end]*2时，num[i+1]一定是>nums[end]*2
        // i往后找，end也往后找，所以只要维护一个mid到end的区间，如果nums[i]>nums[end]*2时，end往后找扩大区间，当nums[i]<=nums[end]*2时
        // i往后找，在判断nums[i]是否>nums[end]*2,直到所有归并结束
        for (int i = lo; i <=mid ; i++) {
            while (end<=hi&&(long)nums[i]>(long)nums[end]*2){
                end++;
            }
            count+=end-(mid+1);
        }
        // 数组双指针技巧，合并两个有序数组
        int i = lo, j = mid + 1;
        for (int p = lo; p <= hi; p++) {
            if (i == mid + 1) {
                // 左半边数组已全部被合并
                nums[p] = temp[j++];
            } else if (j == hi + 1) {
                // 右半边数组已全部被合并
                nums[p] = temp[i++];
            } else if (temp[i] > temp[j]) {
                nums[p] = temp[j++];
            } else {
                nums[p] = temp[i++];
            }
        }
        // 两个表合并后
    }
}
