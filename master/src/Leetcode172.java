/** 172. 阶乘后的零 https://leetcode.cn/problems/factorial-trailing-zeroes/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode172 {
    /**
     * 思路，在乘法中，每有一个2和5就会产生一个0，那么只需要查找2和5的数量即可，2的数量一定是多于5的，所以直接找5的数量
     * 和5*5和5*5*5和5*5*5*5的数量
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        long divisor=5;
        int res=0;
        // 只要divisor不大于n
        while(divisor<=n){
            res+=n/divisor;
            // divisor在乘5继续计算
            divisor=divisor*5;
        }
        return res;
    }
}
