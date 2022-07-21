import java.util.Arrays;

/** 698. 划分为k个相等的子集 https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode698 {
    boolean[] used;

    /**
     * DFS回溯算法
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        used=new boolean[nums.length];
        int count=0;
        for (int a:nums) {
            count+=a;
        }
        Arrays.sort(nums);
        int target=count/k;
        // 当排序后的数组最大的数大于目标数直接返回false，代表这个数放不进子集中
        // 当数组总和对k取余数不为0，直接返回false，代表分不均匀
        if(nums[nums.length-1]>target||count%k!=0){
            return false;
        }
        return canPartitionKSubsets(nums,0,count/k,0,k);
    }

    /**
     * dfs
     * @param nums
     * @param i 从哪里开始遍历
     * @param target 目标值
     * @param curSum 当前值
     * @param k 需要凑几个子集
     * @return
     */
    public boolean canPartitionKSubsets(int[] nums,int i,int target,int curSum, int k) {
        // 剪枝：当k剩余1，剩余的一定可以凑成（因为之前计算过，nums数组的和余k是等于0的）
        if(k==1){
            return true;
        }
        // 当当前值等于目标值
        if(curSum==target){
            // 从0重新开始dfs，将需要凑的子集-1，当前值置0
            return canPartitionKSubsets(nums,0,target,0,k-1);
        }
        // 这里还可以进行优化，将遍历顺序修改为倒序（因为经过排序后，后面比较大，凑出的速度也就更快，但是需要修改遍历开始的位置）
        for (int j = i; j < nums.length; j++) {
            // 当被使用过，跳过
            if(used[j]){
                continue;
            }
            // 剪枝：当加上此元素大于目标值，跳过
            if(curSum+nums[j]>target){
                continue;
            }
            used[j]=true;
            // 加上当前元素，开始位置+1继续dfs
            if(canPartitionKSubsets(nums,j+1,target,curSum+nums[j],k)){
                return true;
            }
            // 回溯
            used[j]=false;
            // 剪枝：每个元素不可以重复使用，经过排序后相同的元素在一起，进行剪枝
            while (j<nums.length-1&&nums[j]==nums[j+1]){
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode698 leetcode698 = new Leetcode698();
        leetcode698.canPartitionKSubsets(new int[]{1,1,1,1,2,2,2,2},2);
    }
}
