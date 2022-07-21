/** 191. 位1的个数(汉明重量)https://leetcode.cn/problems/number-of-1-bits/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode191 {
    /**
     * 因为n&n-1操作会消除最后一个1
     * 这样用一个计数器 只要执行一次n&n-1操作就+1，整个二进制串中就少一个1,直到整个二进制中没有1，整个二进制串等于0时，返回计数器的值就是1的数量
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int res=0;
        while (n!=0){
            n=n&(n-1);
            res++;
        }
        return res;
    }
}
