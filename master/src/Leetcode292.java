/** 292. Nim 游戏 https://leetcode.cn/problems/nim-game/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode292 {

    /**
     * 动态规划，有些测例不能通过
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        // 当n为1，2，3一定赢
        if(n<=3){
            return true;
        }
        // dp数组定义 memo[0][n]为我先手，石子为n的状态 memo[1][n]为我先手，石子为n对手的状态
        boolean[][] memo=new boolean[2][n+1];
        // base case 设置，当n为1，2，3我一定赢，对手一定输
        for (int i = 1; i<4 ; i++) {
            memo[0][i]=true;
            memo[1][i]=false;
        }
        // 从n=4开始
        for (int i = 4; i <=n ; i++) {
            // 可以理解为我可以选择拿一个石子，两个石子，三个石子后，把局面交给对手，只要有一种选择会让对手输，我就选择这种局面
            // memo[0][i]由memo[1][i-1]||memo[1][i-2]||memo[1][i-3]
            memo[0][i]=(memo[1][i-1]||memo[1][i-2]||memo[1][i-3]);
            // 当我们输了，对手一定赢了，当我们赢了对手一定输
            memo[1][i]=!memo[0][i];
        }
        return memo[0][n];
    }

    /**
     * 数学规律
     * 当为4个石子时，我一定会输，因为我一定要拿走一个，只剩3个对手会赢
     * 可以理解为，当剩4个时，轮到谁拿，谁输，但是当为5，6，7时，我可以拿走1，2，3个，把石子为4个的局面交给对面，那么我一定会赢
     * 但是当石子为8，我就无法控制了，对方可以控制住局面
     * 所以当石子为4的倍数，我一定输，否则我一定赢
     * @param n
     * @return
     */
    public boolean canWinNim1(int n) {
        return n%4!=0;
    }


    public static void main(String[] args) {
        Leetcode292 leetcode292 = new Leetcode292();
        leetcode292.canWinNim(100);
    }
}
