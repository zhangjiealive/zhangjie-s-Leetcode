/**
 * 对称矩阵的压缩
 */
public class SymmetricMatrix {
    int[] compress;
    int height;

    public SymmetricMatrix(int[][] matrix) {
        this.height=matrix.length;
        int[] replace=new int[height*(height+1)/2];
        int j=0;
        int k=1;
        for (int i = 0; i < height; i++) {
            while (j<k){
                replace[i*(i+1)/2+j]=matrix[i][j];
                j++;
            }
            j=0;
            k++;
        }
        this.compress=replace;
    }
    public int getValue(int i,int j){
        if(j>i){
            return this.compress[j*(j+1)/2+i];
        }
        else {
            return this.compress[i*(i+1)/2+j];
        }
    }

    public static void main(String[] args) {
        int[][] a={{0,1,3,6,10},{1,2,4,7,11},{3,4,5,8,12},{6,7,8,9,13},{10,11,12,13,14}};
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        SymmetricMatrix symmetricMatrix = new SymmetricMatrix(a);
        System.out.println(symmetricMatrix.getValue(3, 3));
    }
}
