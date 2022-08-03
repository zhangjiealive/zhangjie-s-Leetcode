/** 36. 有效的数独 https://leetcode.cn/problems/valid-sudoku/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode36 {
    int m=9;
    int n=9;

    /**
     * 遍历整个数组，保证每个有数字的格子上，除了该格子本身，它的行和列以及3*3中没有出现过此数字
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char a=board[i][j];
                // 当此位置的数不为.，则判断
                if(a!='.'){
                    // 如果除了该格子本身，所在的行，列以及3*3中也出现了此数字，返回false
                    if(!isVaild(board, i, j, a)){
                        return false;
                    }
                }
            }
        }
        // 遍历完整个数组都没有返回false后，返回true
        return true;
    }

    /**
     * 判断此字符在列，行，3*3格子中有几个:应该是为3个，因为行，列，3*3各一个
     * 所以当大于3时，代表除了原本位置上，在行，列，3*3的其他位置上也有此数
     * @param board
     * @param i
     * @param j
     * @param c
     * @return
     */
    public boolean isVaild(char[][] board,int i,int j,char c) {
        int count=0;
        // 循环9次，因为行，列，3*3都是9个
        for (int k = 0; k < 9; k++) {
            // 遍历第i行
            if(board[i][k]==c){
                count++;
            }
            // 遍历第j列
            if(board[k][j]==c){
                count++;
            }
            // 使用3将他控制在3*3网格中
            if(board[(i/3)*3+k/3][(j/3)*3+k%3]==c){
                count++;
            }
        }
        if(count>3){
            return false;
        }
        else {
            return true;
        }
    }

    public static void main(String[] args) {
        Leetcode36 leetcode36 = new Leetcode36();
        leetcode36.isValidSudoku(new char[][]{{'5','3','.','.','7','.','.','.','.'}
,{'6','.','.','1','9','5','.','.','.'}
,{'.','9','8','.','.','.','.','6','.'}
,{'8','.','.','.','6','.','.','.','3'}
,{'6','.','.','1','9','5','.','.','.'}
,{'6','.','.','1','9','5','.','.','.'}
,{'6','.','.','1','9','5','.','.','.'}});
    }
}
