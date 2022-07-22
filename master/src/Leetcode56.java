import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/** 56. 合并区间 https://leetcode.cn/problems/merge-intervals/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode56 {
    /**
     * 合并重叠区间
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        // 先用list存储，因为不知道具体有多少，无法确定数组大小
        List<int[]> res=new LinkedList<>();
        int n=intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        int left=intervals[0][0];
        int right=intervals[0][1];
        for (int i = 1; i < n; i++) {
            // 如果当前区间完全被left和right给覆盖，则跳过
            if(intervals[i][0]>=left&&intervals[i][1]<=right){
                continue;
            }
            // 如果当前区间与left和right相交，（当前区间起点小于right，终点大于right）则将右侧更新，因为之前经过排序，所以左侧不用更新，左侧默认为小的在前
            else if(right>=intervals[i][0]&&right<=intervals[i][1]){
                right=intervals[i][1];
            }
            // 没有执行以上任何操作就将left和right加入res，并且更新left和right，继续从此区间判定
            else {
                res.add(new int[]{left,right});
                left=intervals[i][0];
                right=intervals[i][1];
            }
        }
        // 因为i=n-1时，会对最后一个区间与left与right的关系进行判定并处理，会导致最后一次的left和right结果没有加入res，所以加上一个res.add
        res.add(new int[]{left,right});
         // 根据List大小，创建数组，并挨个放入数组
        int[][] r=new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            int[] ints = res.get(i);
            r[i]=ints;
        }
        return r;
    }

    public static void main(String[] args) {
        Leetcode56 leetcode56 = new Leetcode56();
        int[][] a={{1,3},{2,6},{8,10},{9,18}};
        leetcode56.merge(a);
    }
}
