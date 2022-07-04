//528. 按权重随机选择

import java.util.Random;

/** 力扣528题 https://leetcode.cn/problems/random-pick-with-weight/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode528 {

}

/**
 * 根据权重值返回
 */
class Solution {
    // 前缀和数组
    private int[] preSum;
    // 随机数对象
    private Random rand = new Random();

    /**
     * 构造函数
     * @param w w为一维数组，里面是各个下标的权重 例如[1,3]意思为下标0的权重为1，下标1的权重为3
     */
    public Solution(int[] w) {
        int n = w.length;
        // 前缀和数组应该比原数组大1
        preSum = new int[n + 1];
        // 前缀和数组的第一位为0，因为第0位没有前缀
        preSum[0] = 0;
        // 遍历数组，前缀和数组的每个元素为，前一个前缀和加对应数组下标位置的数（因为前缀和数组比原数组大1，所以原数组的索引位置-1）
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + w[i - 1];
        }
    }

    public int pickIndex() {
        int n = preSum.length;
        // 在前缀和最大值到1之间取一个随机数，因为在前缀和数组中0是一个占位符，所以要加1
        int target = rand.nextInt(preSum[n - 1]) + 1;
        // 使用二分查找，注意是找左侧边界（可能target值在前缀和数组中找不到）
        /*
        左侧边界查找找不到元素的情况
        1、返回的这个值是 nums 中大于等于 target 的最小元素索引。

        2、返回的这个值是 target 应该插入在 nums 中的索引位置。

        3、返回的这个值是 nums 中小于 target 的元素个数。

        右侧边界查找要比左侧边界情况小1
         */
        return leftBoundSearch(preSum, target) - 1;
    }

    public int leftBoundSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }
        return left;
    }
}
