public class Leetcode6101 {
    public boolean checkXMatrix(int[][] grid) {
            int n=grid.length;
            int i=0;
            for (int j = 0; j <n; j++) {
                for (int k = 0; k <n; k++) {
                    if(j==k||j+k==n-1){
                        if(grid[j][k]==0){
                            return false;
                        }
                    }
                    else if(grid[j][k]!=0){
                        return false;
                    }
                }
            }
            return true;
        }


    public static void main(String[] args) {
        Leetcode6101 leetcode6101 = new Leetcode6101();
        int[][] a={{2,0,0,1},{0,3,1,0},{0,5,2,0},{4,0,0,2}};
        System.out.println(leetcode6101.checkXMatrix(a));
    }

}
