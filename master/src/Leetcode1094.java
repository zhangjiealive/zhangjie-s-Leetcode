//1094. 拼车

import java.util.Arrays;

/** 力扣1094题 https://leetcode.cn/problems/car-pooling/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        DifferenceArray diff = new DifferenceArray(new int[1001]);
        for (int i = 0; i < trips.length; i++) {
            diff.increment(trips[i][1],trips[i][2]-1,trips[i][0]);
        }
        int[] result = diff.result();
        int count=0;
        for (int a : result) {
            if(a>capacity){
                return false;
            }
            if(a==0){
                count++;
            }
            if(count>10) return true;
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode1094 leetcode1094 = new Leetcode1094();
        int[][] a=new int[][]{{2,1,5},{3,5,7}};
        leetcode1094.carPooling(a,3);
    }
}
