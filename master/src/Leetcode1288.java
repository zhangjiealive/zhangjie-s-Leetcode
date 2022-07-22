import java.util.Arrays;
import java.util.Comparator;

/** 1288. 删除被覆盖区间 https://leetcode.cn/problems/remove-covered-intervals/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode1288 {
    /**
     * 删除被覆盖的区间，首先找到重叠的区间个数，剩下的就是不重叠的区间数
     * 先排序，然后开始寻找被覆盖区间
     * @param intervals
     * @return
     */
    public int removeCoveredIntervals(int[][] intervals) {
        int n=intervals.length;
        // res为被覆盖的区间
        int res=0;
        // 排序，按起点升序排列，起点相同，按终点降序排列
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o2[1]-o1[1];
                }
                return o1[0]-o2[0];
            }
        });
        // 将left和right初始化为第一个区间的值
        int left=intervals[0][0];
        int right=intervals[0][1];
        // 循环从1开始
        for (int i = 1; i <n ; i++) {
            // 如果当前区间被left和right包含，被覆盖区间+1
            if(intervals[i][0]>=left&&intervals[i][1]<=right){
                res++;
            }
            // 如果当前区间与left和right相交，（当前区间起点小于right，终点大于right）则将右侧更新，因为之前经过排序，所以左侧不用更新，左侧默认为小的在前
            if(right>=intervals[i][0]&&right<=intervals[i][1]){
                right=intervals[i][1];
            }
            // 如果当前区间左边界都大于right，则更新区间，继续从此区间判定
            if(intervals[i][0]>right){
                left=intervals[i][0];
                right=intervals[i][1];
            }
        }
        // 用区间的数量减去被覆盖的数量就是剩余的数量
        return n-res;
    }
}
