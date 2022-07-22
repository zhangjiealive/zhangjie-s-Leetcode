/** 43. 字符串相乘 https://leetcode.cn/problems/multiply-strings/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode43 {
    /**
     * 字符串相乘，注意进位
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        int n=num1.length();
        int m=num2.length();
        // 结果数组，大小为num1的长度+num2的长度
        int[] res=new int[n+m];
        // num1的每一位，与num2所有相乘
        for (int i = n-1; i >=0 ; i--) {
            int n1=num1.charAt(i)-'0';
            for (int j = m-1; j >=0 ; j--) {
                int n2=num2.charAt(j)-'0';
                int mult=n1*n2;
                // 十位下标
                int p1=i+j;
                // 个位下标
                int p2=i+j+1;
                // sum的大小为两数相乘加上次的进位
                int sum=mult+res[p2];
                // 个位
                res[p2]=sum%10;
                // 进位
                res[p1]+=sum/10;
            }
        }
        int i=0;
        // 因为前面可能还存在0，所以找到第一个非0位置
        while (i<res.length&&res[i]==0){
            i++;
        }
        StringBuilder sb = new StringBuilder();
        // 开始拼接字符串
        for (; i<res.length; i++) {
            sb.append(res[i]);
        }
        // 如果字符串为空，直接返回字符串0，否则返回此字符串
        return sb.length()==0?"0":sb.toString();
    }

    public static void main(String[] args) {
        Leetcode43 leetcode43 = new Leetcode43();
        leetcode43.multiply("123","456");
    }
}
