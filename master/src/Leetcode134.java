/** 134. 加油站 https://leetcode.cn/problems/gas-station/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode134 {
    /**
     * 贪心算法
     * 思路：当i点到j点不可达，i到j中的任意一点k必不可达j，当i无法到j，只能从j后面出发
     * 因为解是唯一的
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=gas[i]-cost[i];
        }
        // 如果汽油总和小于消耗的总和，则不可达
        if(sum<0){
            return -1;
        }
        int tank=0;
        int start=0;
        for(int i=0;i<n;i++){
            // 将下一个加油站的汽油和过去需要的汽油加起来
            tank+=gas[i]-cost[i];
            // 如果小于0，则换成从下一点出发，重置tank
            if(tank<0){
                start=i+1;
                tank=0;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Leetcode134 leetcode134 = new Leetcode134();
        leetcode134.canCompleteCircuit(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2});
    }
}
