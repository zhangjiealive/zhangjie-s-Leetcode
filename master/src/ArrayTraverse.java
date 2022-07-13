// 动态规划数组遍历技巧
public class ArrayTraverse {
    public static void main(String[] args) {
        int[][] a={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        int n=5;
        // 都是从对角线发散出去
        // 对角线右上角向下斜着遍历
        for (int l = 2; l <=n; l++) {
            for (int i = 0; i <= n-l; i++) {
                int j=l+i-1;
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        // 对角线左下角向下斜着
        for (int l = 2; l <=n; l++) {
            int j=0;
            for (int i = l-1; i <=n-1; i++) {
                System.out.print(a[i][j++]+" ");
            }
            System.out.println();
        }
        // 对角线从下往上横着
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        // 对角线从上往下横着
        for (int i = 0; i <n; i++) {
            for (int j = i-1; j >=0; j--) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}
