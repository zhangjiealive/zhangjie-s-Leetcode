//48. 图像旋转

/** 力扣48题 https://leetcode.cn/problems/rotate-image/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode48 {
    /**
     * 顺时针旋转90度 注意：需要原地旋转
     * 首先将除对角线之外的，按照对称进行元素交换，而后对一行进行逆置，达到顺时针旋转的目的
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(j==i){
                    continue;
                }
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for (int[] row:matrix) {
            reverse(row);
        }
    }

    public void reverse(int[] arr){
        int i=0;
        int j=arr.length-1;
        while (j>i){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }


    /**
     * 逆时针旋转90度
     * @param matrix
     */
    public void antirotate(int[][] matrix) {
        int n=matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-j-1][n-i-1];
                matrix[n-j-1][n-i-1]=temp;
            }
        }
        for (int[] row:matrix) {
            reverse(row);
        }
    }
}
