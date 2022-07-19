import java.util.Arrays;
import java.util.Comparator;

/** 452. 用最少数量的箭引爆气球 https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode452 {
    /**
     * 与435题类似，区间问题
     * 贪心算法
     * 每多一个不重叠区间就需要多一把箭
     * 当区间开始值和其他区间结束值相同，也算重叠，箭头擦过去气球就破了
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        // 升序排列
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 使用 return o1[1]-o2[1]; 可能会导致溢出
                // 解决排序溢出问题方法1
                if(o1[1]>o2[1]){
                    return 1;
                }
                if(o1[1]<o2[1]){
                    return -1;
                }
                return 0;
                // 解决排序溢出问题方法2
                // return Integer.compare(o1[1],o2[1]);
            }
        });
        // 至少有一个不重叠区间
        int count=1;
        int x_end=points[0][1];
        for (int[] a:points) {
            // 因为区间结束和区间开始相同时，也算区间重合，所以条件改成>
            if(a[0]>x_end){
                count++;
                x_end=a[1];
            }
        }
        // 返回不重叠区间的数量就是需要的箭数
        return count;
    }

    public static void main(String[] args) {
        Leetcode452 leetcode452 = new Leetcode452();
        leetcode452.findMinArrowShots(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}});
    }
}
