/** 37. 解数独 https://leetcode.cn/problems/sudoku-solver/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode37 {
    int m=9;
    int n=9;
    public void solveSudoku(char[][] board) {
        backtrack(board,0,0);
    }

    /**
     * 回溯解决解数独问题
     * 思想：不断去试，穷举所有结果
     * 设置返回值，在适当位置返回可以加快程序运行
     * @param board
     * @param i
     * @param j
     * @return
     */
    public boolean backtrack(char[][] board,int i,int j){
        // 当j==9，代表这一行已经执行完了，递归去执行下一行
        if(j==n){
            // 这种操作能加速程序运行
            return backtrack(board,i+1,0);
        }
        // 当i==m了，代表i==9(第9行已经执行完了，下标从0开始)，返回true
        if(i==m){
            return true;
        }
        // 当这一位不为.，已经存在值，递归去执行下一位
        if(board[i][j]!='.'){
            // 这种操作能加速程序运行
            return backtrack(board,i,j+1);
        }
        // 依次去试1-9
        for (char ch = '1'; ch <= '9'; ch++) {
            // 当此数字在行或列或3*3网格中存在，执行下一次循环
            if(!isVaild(board,i,j,ch)){
                continue;
            }
            // 先放上去
            board[i][j]=ch;
            // 递归去执行下一位，如果为true直接返回，不回溯，代表解数独结束
            if(backtrack(board,i,j+1)){
                // 这种操作能加速程序运行
                return true;
            }
            // 回溯
            board[i][j]='.';
        }
        return false;
    }

    /**
     * 判断此字符在列，行，3*3格子中是否存在
     * @param board
     * @param i
     * @param j
     * @param c
     * @return
     */
    public boolean isVaild(char[][] board,int i,int j,char c) {
        // 循环9次，因为行，列，3*3都是9个
        for (int k = 0; k < 9; k++) {
            // 遍历第i行
            if(board[i][k]==c){
                return false;
            }
            // 遍历第j列
            if(board[k][j]==c){
                return false;
            }
            // 使用3将他控制在3*3网格中
            if(board[(i/3)*3+k/3][(j/3)*3+k%3]==c){
                return false;
            }
        }
        return true;
    }
}
