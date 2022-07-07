//315. 计算右侧小于当前元素的个数

import java.util.LinkedList;
import java.util.List;

/** 力扣315题 https://leetcode.cn/problems/count-of-smaller-numbers-after-self/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode315 {
    /**
     * 本来想通过map来确定索引位置，结果数组是有重的，没办法用map
     * 归并排序从最小的一个元素开始归并
     */
    private class Pair {
        int val, id;
        Pair(int val, int id) {
            // 记录数组的元素值
            this.val = val;
            // 记录元素在数组中的原始索引
            this.id = id;
        }
    }

    // 归并排序所用的辅助数组
    private Pair[] temp;
    // 记录每个元素后面比自己小的元素个数
    private int[] count;

    // 主函数
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new int[n];
        temp = new Pair[n];
        Pair[] arr = new Pair[n];
        // 记录元素原始的索引位置，以便在 count 数组中更新结果
        for (int i = 0; i < n; i++)
            //把nums的值赋值给arr
            arr[i] = new Pair(nums[i], i);

        // 执行归并排序，本题结果被记录在 count 数组中
        sort(arr, 0, n - 1);

        List<Integer> res = new LinkedList<>();
        for (int c : count) res.add(c);
        return res;
    }

    // 归并排序
    private void sort(Pair[] arr, int lo, int hi) {
        if (lo == hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    // 合并两个有序数组
    private void merge(Pair[] arr, int lo, int mid, int hi) {
        // 一个copy数组，用来预存值
        for (int i = lo; i <= hi; i++) {
            temp[i] = arr[i];
        }
        int i = lo, j = mid + 1;
        for (int p = lo; p <= hi; p++) {
            if (i == mid + 1) {
                arr[p] = temp[j++];
                /**
                 * 当j插入完了之后
                 * 此时代表i的指针位置的数大于j中所有的数
                 */
            } else if (j == hi + 1) {
                arr[p] = temp[i++];
                // 更新 count 数组
                // 通过arr[p].id可以确定唯一位置的索引
                count[arr[p].id] += j - mid - 1;
            } else if (temp[i].val > temp[j].val) {
                arr[p] = temp[j++];
            } else {
                /**
                 * 当插入j中的元素时
                 * 代表i目前位置的数大于j目前指针已经之前之前的所有数
                 */
                arr[p] = temp[i++];
                // 更新 count 数组
                // 通过arr[p].id可以确定唯一位置的索引
                count[arr[p].id] += j - mid - 1;
            }
        }
    }
}
