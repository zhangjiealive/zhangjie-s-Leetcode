/** 277. 搜寻名人 https://leetcode.cn/problems/find-the-celebrity/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode277 {
    /**
     * 图论问题，但是没有用图的方法来解决
     * @param n
     * @return
     */
    public int findCelebrity(int n){
        int cand=0;
        // 先将0假设为名人，从1到n开始搜寻
        for (int other = 1; other < n; other++) {
            // 如果cand认识other或者other不认识cand，代表cand不是名人
            if(knows(cand,other)||!knows(other,cand)){
                // 将cand和other交换
                cand=other;
            }
            // 否则上面的成立，cand暂时是名人
            else {

            }
        }
        // 当找到唯一一个cand预备成员后，从0开始遍历
        for (int other = 0; other < n; other++) {
            // 当他等于自己时跳过
            if(cand==other){
                continue;
            }
            // 如果有人不认识cand或者cand认识别人则本局没有名人
            if(!knows(other,cand)||knows(cand,other)){
                return -1;
            }
        }
        // 如果遍历结束还没有return，则返回这个cand
        return cand;
    }
    // 验证a是否认识b的方法
    public boolean knows(int a,int b){
        return true;
    }
}
