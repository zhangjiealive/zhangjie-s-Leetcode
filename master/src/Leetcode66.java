//66. 加一
/** 力扣53题 https://leetcode.cn/problems/maximum-subarray/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode66 {
    public int[] plusOne(int[] digits) {
        int length=digits.length-1;
        int[] n=new int[length+1];
        int nine=1;
        for (int a :
                digits) {
            if(a!=9){
                nine=0;
                break;
            }
        }
        if(nine==1){
            n=new int[length+2];
        }
        int flag=0;
        if(digits[length]!=9){
            digits[length]=digits[length]+1;
            return digits;
        }
        else {
            int nlength=n.length-1;
            while(length>=0) {
                if (digits[length] == 9) {
                    n[nlength] = 0;
                    flag = 1;
                    length--;
                    nlength--;
                } else if (digits[length] != 9) {
                    n[nlength] = digits[length] + 1;
                    flag = 0;
                    length--;
                    nlength--;
                    break;
                }
            }
            while (length>=0){
                n[nlength]=digits[length]+n[nlength];
                length--;
                nlength--;
            }
            if(flag==1){
                n[nlength]=1;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Leetcode66 leetcode66 = new Leetcode66();
        int[] a={2,4,9,3,9};
        leetcode66.plusOne(a);
    }
}
