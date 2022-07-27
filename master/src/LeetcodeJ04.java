import java.util.HashSet;
import java.util.Set;

/** 剑指 Offer 04. 二维数组中的查找 https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class LeetcodeJ04 {
    int n;
    int m;
    // visited集合，避免走回头路
    Set<String> set;

    /**
     * 思路：将二维数组当成一个图，从图的起点开始深搜，使用一个set使用O(1)复杂度的contains方法避免走回头路
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 当二维数组中没有元素，直接返回false
        if(matrix.length==0){
            return false;
        }
        n=matrix.length;
        m=matrix[0].length;
        set=new HashSet<>();
        // 从0，0点出发，开始DFS
        return DFS(matrix,0,0,target);
    }

    /**
     * 递归DFS
     * @param matrix
     * @param i
     * @param j
     * @param target
     * @return
     */
    public boolean DFS(int[][] matrix,int i,int j,int target){
        // 超出边界的情况，直接返回false
        if(i<0||j<0||i>n-1||j>m-1){
            return false;
        }
        // 如果存在代表以及访问过，直接返回false
        if(set.contains(i+"+"+j)){
            return false;
        }
        // 找到target值返回true
        if(matrix[i][j]==target){
            return true;
        }
        // set中加入i+j字符串，代表访问过
        set.add(i+"+"+j);
        // 从此点向四周发散
        return DFS(matrix,i-1,j,target)||DFS(matrix,i+1,j,target)||DFS(matrix,i,j-1,target)||DFS(matrix,i,j+1,target);
    }

    public static void main(String[] args) {
        LeetcodeJ04 leetcodeJ04 = new LeetcodeJ04();
        int[][] a=new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        leetcodeJ04.findNumberIn2DArray(a,5);
    }
}
