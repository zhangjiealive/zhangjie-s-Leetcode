import java.util.*;
/** 剑指 Offer 12. 矩阵中的路径 https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class LeetcodeJ12 {
    // 不走回头路，根据set判断是否走到此
    HashSet<String> set;
    int n;
    int m;
    Boolean a;

    /**
     * 回溯算法+剪枝
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        set=new HashSet<>();
        n=board.length;
        m=board[0].length;
        boolean result=false;
        // 遍历二维数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 找到此位置与字符串第一位相同的作为起点，开始DFS
                if(board[i][j]==word.charAt(0)){
                    // 只要在一次循环中result变为true，直接返回（剪枝）
                    if(result){
                        return true;
                    }
                    result=result||DFS(board,word,i,j,0);
                }
            }
        }
        return result;
    }


    public boolean DFS(char[][] board, String word,int i,int j,int k) {
        // 下标越界判定
        if(i>=n||i<0||j>=m||j<0){
            return false;
        }
        // 判断是否走回头路
        if(set.contains(i+""+j)){
            return false;
        }
        // 当k的大小等于字符串的长度，并且二维数组下标位置和一维数组的下标位置相同
        if(k==word.length()-1&&board[i][j]==word.charAt(k)){
            return true;
        }
        // 此位置上的字符不相同，直接返回false
        if(board[i][j]!=word.charAt(k)){
            return false;
        }
        // 相同的话
        else {
            // 在set中加入此i+j
            set.add(i+""+j);
            // 从此位置向四周扩散
            a=DFS(board,word,i+1,j,k+1)||DFS(board,word,i,j+1,k+1)||DFS(board,word,i-1,j,k+1)||DFS(board,word,i,j-1,k+1);
            // 撤销此位置
            set.remove(i+""+j);
        }
        return a;
    }

    public static void main(String[] args) {
        LeetcodeJ12 leetcodeJ12 = new LeetcodeJ12();
        char[][] chars=new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        leetcodeJ12.exist(chars,"AAB");
    }
}
