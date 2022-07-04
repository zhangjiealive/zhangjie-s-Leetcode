//54. 螺旋矩阵

import java.util.LinkedList;
import java.util.List;

/** 力扣54题 https://leetcode.cn/problems/spiral-matrix/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode54 {
    /**
     * 遍历螺旋矩阵
     * 根据上边界，下边界，左边界，右边界思路
     * 先从第一行左往右，第一行遍历完缩小上边界，而后遍历最后一列，缩小右边界，而后遍历最后一行，缩小下边界，而后遍历第一列，缩小左边界
     * 一直循环直到res的容量等于矩阵元素的个数
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int up=0;
        int left=0;
        int down=m-1;
        int right=n-1;
        List<Integer> res=new LinkedList<>();
        while (res.size()<m*n){
            if(up<=down){
                for (int i = left; i <=right; i++) {
                    res.add(matrix[up][i]);
                }
                up++;
            }
            if(left<=right){
                for (int i = up; i <=down; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
            }
            if(up<=down){
                for (int i = right; i >=left ; i--) {
                    res.add(matrix[down][i]);
                }
                down--;
                }
            if(left<=right){
                for (int i = down; i >=up; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}
