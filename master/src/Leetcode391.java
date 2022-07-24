import java.util.HashSet;
import java.util.Set;
/** 391. 完美矩形 https://leetcode.cn/problems/perfect-rectangle/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode391 {
    /**
     * 给一些小的矩形，看看这些矩形是否能构成一个完整的矩形
     * 思路：从两个角度入手：面积角度，顶点的角度
     * 面积的角度：从这些点中找到最左下的点，和最右上的点，可以求出这个完整矩阵的面积，并这些小的矩形的面积相加和比较，如果不相等，则一定不是完整的矩形
     * 顶点的角度：用一些小的矩形拼出的大的矩形，那么可以想象如果存在相交点，那么此点的出现个数一定是偶数，如果是奇数，则代表此点是不相交的点或者顶点，利用这个性质，来去除重复的相交点
     * 最后只将这些小的矩阵组成的大矩阵的所有顶点和不相交的点找出来，看看是否和原本我们找的最左下的点，和最右上的点的点一致
     * @param rectangles
     * @return
     */
    public boolean isRectangleCover(int[][] rectangles) {
        // 找最小的点，左下角的x坐标系
        int X1=Integer.MAX_VALUE;
        // 找最小的点，左下角的y坐标系
        int Y1=Integer.MAX_VALUE;
        // 找最大的点，右上角的x坐标系
        int X2=Integer.MIN_VALUE;
        // 找最大的点，右上角的y坐标系
        int Y2=Integer.MIN_VALUE;
        // 哈希集合用于O(1)时间的查找
        Set<String> points=new HashSet<>();
        // 实际面积
        int actual_area=0;
        // 遍历所有小矩阵的点，找左下角和右上角的点，并计算小矩阵的面积总和
        for (int[] item:rectangles) {
            int x1=item[0];
            int y1=item[1];
            int x2=item[2];
            int y2=item[3];
            X1=Math.min(x1,X1);
            Y1=Math.min(y1,Y1);
            X2=Math.max(x2,X2);
            Y2=Math.max(y2,Y2);
            actual_area+=(x2-x1)*(y2-y1);
            int[] p1=new int[]{x1,y1};
            int[] p2=new int[]{x2,y2};
            int[] p3=new int[]{x1,y2};
            int[] p4=new int[]{x2,y1};
            // 将小矩形的4个点依次加入哈希集合
            for (int[] p:new int[][]{p1,p2,p3,p4}) {
                String s=p[0]+","+p[1];
                // 如果已经存在了，则从集合中删除
                if(points.contains(s)){
                    points.remove(s);
                }
                // 否则加入集合
                else {
                    points.add(p[0]+","+p[1]);
                }
                // 这样做最后会使出现偶数位的点不会出现在集合中，集合中只会保留出现奇数位的
            }
        }
        // 判断小矩形的面积合起来是不是和大矩形相同，不同直接返回false
        int expected_area=(X2-X1)*(Y2-Y1);
        if(expected_area!=actual_area){
            return false;
        }
        // 如果最后顶点数和不相交的点数不为4，直接返回false
        if(points.size()!=4){
            return false;
        }
        // 判断set中保存的是否和左下角和右上角的点一致
        if(!points.contains(X1+","+Y1)||!points.contains(X1+","+Y2)||!points.contains(X2+","+Y1)||!points.contains(X2+","+Y2)){
            return false;
        }
        // 只有符合以上所有条件，才返回true
        return true;
    }

    public static void main(String[] args) {
        Leetcode391 leetcode391 = new Leetcode391();
        int[][] a=new int[][]{{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
        leetcode391.isRectangleCover(a);
    }
}
