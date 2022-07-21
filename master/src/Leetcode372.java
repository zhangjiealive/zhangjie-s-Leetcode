/** 372. 超级次方 https://leetcode.cn/problems/super-pow/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode372 {
    /**
     * 题目难点：指数由数组表示
     * 避免指数运算溢出
     * @param a
     * @param b
     * @return
     */
    public int superPow(int a, int[] b) {
        int length=b.length-1;
        return superPowHelp(a,b,length);
    }

    /**
     * 所有步骤都是(a%k)(b%k)%k=(a*b)%k
     * part1和part2就是(a%k)和(b%k)
     * @param a
     * @param b
     * @param i
     * @return
     */
    public int superPowHelp(int a,int[] b,int i){
        // 当前指针位置超出数组边界
        if(i==-1){
            return 1;
        }
        // 取出最后一位
        int last=b[i];
        // 先对最后一位做指数运算并对结果取模
        int part1=myPow(a,last);
        // 在对剩余的位递归做指数运算并对结果取模
        int part2=myPow(superPowHelp(a,b,i-1),10);
        // 最后在相乘取模
        return (part1*part2)%base;
    }

    int base=1337;

    /**
     * 递归计算a的k次方然后与base求模的结果
     * 因为(a*b)%k可能会导致过大溢出，所以使用下面的公式替代
     * 公式：(a%k)(b%k)%k=(a*b)%k
     * @param a
     * @param k
     * @return
     */
    public int myPow(int a,int k){
        // 递归出口，次方为0
        if (k==0){
            return 1;
        }
        // 直接用a与base求模
        a=a%base;
        // k为奇数
        if(k%2==1){
            // 奇数，因为a在上面已经取模，此时套用(a%k)(b%k)%k，递归使用myPow自动会对a^k-1取模，最后相乘在%base
            return (a*myPow(a,k-1))%base;
        }
        // k为偶数
        else {
            // 偶数，因为a在上面已经取模，因为k为偶数，所以执行myPow(a,k/2)，最后在相乘%base
            int sub=myPow(a,k/2);
            return (sub*sub)%base;
        }
    }
}
