import java.util.Arrays;
import java.util.Comparator;

/** 435. 无重叠区间 https://leetcode.cn/problems/non-overlapping-intervals/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode435 {
    /**
     * 贪心算法
     * 先找出不重叠的区间，把其他重叠的删除
     * 思路：找最早结束的区间，对所有区间开始的值大于等于此区间结束值的区间进行计数，并从这些区间再去寻找，直到遍历完整个数组
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        // 升序排列
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        // 始终有一个不重叠的区间
        int count=1;
        // 此为结束最早的
        int x_end=intervals[0][1];
        for (int[] a: intervals) {
            // 只要有开始值大于等于最小的结束值
            if(a[0]>=x_end){
                // 不重叠区间+1
                count++;
                // 再从此区间继续开始查找
                x_end=a[1];
            }
        }
        // 最后用区间的个数减去不重叠区间的数量，就是需要删除的区间数
        return intervals.length-count;
    }

    public static void main(String[] args) {
        new Leetcode435().eraseOverlapIntervals(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}});
    }
}
