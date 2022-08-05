/** 31. 下一个排列 https://leetcode.cn/problems/next-permutation/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode31 {
    /**
     * 找下一个字典集大的排列，要找到下一个大的字典集，应该从后向前找到较小的数，就是后面比前面大的
     * 然后再从较小数到末尾中，找出较大数（不能找最大的，因为只是下一个字典集大的）
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        // nums长度
        int n=nums.length;
        // n小于等于1直接返回
        if(n<=1){
            return;
        }
        // i为倒数第二个(区间内较小数的位置)
        int i=nums.length-2;
        // j为最后一个(区间内最大数的位置)
        int j=nums.length-1;
        // k为最后一个(区间内较大数的位置)
        int k=nums.length-1;
        // 找到两个数，满足nums[i]<nums[j]升序序列,因为在之前nums[i]都是>=nums[j]的，现在nums[j]的位置也是刚刚nums[i]呆过的，所以nums[j]-n一定是降序序列
        while (i>=0&&nums[i]>=nums[j]){
            i--;
            j--;
        }
        if(i>=0){
            // 在较小数到n之间去找较大数，因为nums[j]-n是递减的，所以找到的第一个满足nums[k]>nums[i]一定是较小的，是nums[j]-n中最小的大于nums[i]的
            while (nums[i]>=nums[k]){
                k--;
            }
            // 将较小数和较大数互换，字典集就变大了
            swap(nums,i,k);
        }
        // 因为nums[j]-n是递减的，那么将nums[j]-n逆置，又可以在将字典集增大的情况下做到较小字典集
        reverse(nums,j,n-1);
        return;
    }

    // 交换数组a，b位置上的元素
    public void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    // 反转数组i到j的元素
    public void reverse(int[] nums,int i,int j){
        while (i<j){
            swap(nums,i++,j--);
        }
    }

    public static void main(String[] args) {
        Leetcode31 leetcode31 = new Leetcode31();
        leetcode31.nextPermutation(new int[]{1,1});
    }
}
