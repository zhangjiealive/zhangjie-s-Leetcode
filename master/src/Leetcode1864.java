/** 1864. 构成交替字符串需要的最小交换次数 https://leetcode.cn/problems/minimum-number-of-swaps-to-make-the-binary-string-alternating/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode1864 {
    /**
     * 当0和1的数量差大于1，一定不能构成交替字符串
     * 当数量相等，有两种情况，1010和0101，只需要在偶数位0和偶数位1中找最小的，返回即可（因为谁少，就把谁换掉，因为求最短步数）
     * 当数量不等，有两种情况，当0的数量多应该是01010，返回偶数位上1的数量(因为偶数位应该都为0，偶数位的1占了0的位置，需要换掉)
     *                    当1的数量多应该是10101，返回偶数位上0的数量(因为偶数位应该都为1，偶数位的0占了1的位置，需要换掉)
     * @param s
     * @return
     */
    public int minSwaps(String s) {
        int n = s.length();
        // 奇数位1的数量
        int jOneCount = 0;
        // 偶数位1的数量
        int oOneCount = 0;
        // 奇数位0的数量
        int jZeroCount = 0;
        // 偶数位0的数量
        int oZeroCount = 0;
        // 遍历字符串进行计数
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                if (i % 2 == 0) {
                    oZeroCount++;
                } else {
                    jZeroCount++;
                }
            } else {
                if (i % 2 == 0) {
                    oOneCount++;
                } else {
                    jOneCount++;
                }
            }
        }
        // 当0和1的数量差大于1，一定不能构成交替字符串
        if (Math.abs((jOneCount + oOneCount) - (jZeroCount + oZeroCount)) > 1) {
            return -1;
        }
        // 0和1的数量差一定不大于1，所以为字符串为偶数就是相等的情况
        if (n % 2 == 0) {
                return Math.min(oOneCount,oZeroCount);
        }
        // 不等的情况
        else {
            // 1更多的情况
            if((oOneCount+jOneCount)>(oZeroCount+jZeroCount)){
                // 返回偶数位0的数量
                return oZeroCount;
            }
            // 0更多的情况
            else {
                // 返回偶数位1的数量
                return oOneCount;
            }
        }
    }
}
