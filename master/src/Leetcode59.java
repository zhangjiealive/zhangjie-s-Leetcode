//59. 螺旋矩阵II

/** 力扣59题 https://leetcode.cn/problems/spiral-matrix-ii/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode59 {
    /**
     * 根据54题的格式修改而来，需要修改的是while循环的结束条件，因为元素个数从1开始，每次递增1，给出的是长宽相等的矩阵，所以是n*n个元素
     * 所以当1增长到大于n*n时，循环结束
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int length=n;
        int wide=n;
        int up=0;
        int left=0;
        int down=n-1;
        int right=n-1;
        int[][] matrix=new int[n][n];
        int num=1;
        while (num<=n*n){
            if(up<=down){
                for (int i = left; i <=right; i++) {
                    matrix[up][i]=num;
                    num++;
                }
                up++;
            }
            if(left<=right){
                for (int i = up; i <=down; i++) {
                    matrix[i][right]=num;
                    num++;
                }
                right--;
            }
            if(up<=down){
                for (int i = right; i >=left ; i--) {
                   matrix[down][i]=num;
                   num++;
                }
                down--;
            }
            if(left<=right){
                for (int i = down; i >=up; i--) {
                    matrix[i][left]=num;
                    num++;
                }
                left++;
            }
        }
        return matrix;
    }
}
