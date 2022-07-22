import java.util.LinkedList;
import java.util.List;

/** 986. 区间列表的交集 https://leetcode.cn/problems/interval-list-intersections/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode986 {
    /**
     * 计算数组中区间的交集，用两个指针在两个数组间移动
     * @param firstList
     * @param secondList
     * @return
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // 用list存储结果
        List<int []> res=new LinkedList<>();
        // firstList下标指针
        int i=0;
        // secondList下标指针
        int j=0;
        int n=firstList.length;
        int m=secondList.length;
        // 当两个指针都在有效范围内
        while (i<n&&j<m){
            int a1=firstList[i][0];
            int a2=firstList[i][1];
            int b1=secondList[j][0];
            int b2=secondList[j][1];
            // 只要a区间的终点大于b区间的起点并且b区间终点大于a区间的起点，则代表有重叠的位置
            if(a2>=b1&&b2>=a1){
                // 交集的起点是两个起点的最大值，交集的终点是两个终点的最小值（自己画线或者思考）
                res.add(new int[]{Math.max(a1,b1),Math.min(a2,b2)});
            }
            // 当a的终点大于b的终点，secondList的指针后移
            if(a2>b2){
                j++;
            }
            // 当b的终点大于或者等于a的终点，firstList的指针后移
            else {
                i++;
            }
        }
        // 根据List大小，创建数组，并挨个放入数组
        int[][] r=new int[res.size()][2];
        for (int k = 0; k < res.size(); k++) {
            r[k]=res.get(k);
        }
        return r;
    }

}
