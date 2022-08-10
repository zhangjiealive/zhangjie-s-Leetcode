/** 640. 求解方程 https://leetcode.cn/problems/solve-the-equation/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode640 {
    /**
     * 解题思路：模拟
     * @param s
     * @return
     */
    public String solveEquation(String s) {
        // x的个数
        int x = 0;
        // 数的和
        int num = 0;
        // 字符串的长度
        int n = s.length();
        // 当前的符号，第一位默认为"+"
        char symbol='+';
        // 等于号是否出现，出现过的话，加变成减，减变成加
        boolean apper=false;
        // 字符串转char数组
        char[] cs = s.toCharArray();
        // 初始化临时值
        int temp=-1;
        for (int i = 0; i < n;) {
            // 遇到=号，将标志位置true，符号重置为+，继续循环
            if(cs[i]=='='){
                apper=true;
                symbol='+';
                i++;
                continue;
            }
            // 遇到+号，将符号置+，继续循环
            else if(cs[i]=='+'){
                symbol='+';
                i++;
                continue;
            }
            // 遇到-号，将符号置-，继续循环
            else if(cs[i]=='-'){
                symbol='-';
                i++;
                continue;
            }
            // 遇到x，如果temp中为有效值，则加上temp个x，否则+1
            else if(cs[i]=='x'){
                if(temp!=-1){
                    if(!apper){
                        x=symbol=='+'?x+temp:x-temp;
                    }
                    else {
                        x=symbol=='-'?x+temp:x-temp;
                    }
                    // 使用后，置为无效值
                    temp=-1;
                }
                else {
                    if(!apper){
                        x=symbol=='+'?x+1:x-1;
                    }
                    else {
                        x=symbol=='-'?x+1:x-1;
                    }
                }
                i++;
            }
            // 当为数字的话
            else {
                // 新建一个指针
                int j=i;
                // 找到下一个不为数字的位置
                while (j<n&&cs[j]!='-'&&cs[j]!='+'&&cs[j]!='='&&cs[j]!='x'){
                    j++;
                }
                // 对i-j之间的数字进行截取
                temp=Integer.parseInt(s.substring(i,j));
                // 当j指针指向数字末尾或者j位置不为x，就是纯数字
                if(j==n||!(cs[j]=='x')){
                    // 根据等于号是否出现的标志位来进行加减操作
                    if(!apper){
                        num=symbol=='+'?num+temp:num-temp;
                    }
                    else {
                        num=symbol=='-'?num+temp:num-temp;
                    }
                    // 使用后将temp置为无效值
                    temp=-1;
                }
                // 将i指针移到j指针的位置，因为i-j之间的都已经操作过了
                i=j;
            }
        }
        // 如果x为0，num也为0，为Infinite solutions，x为0，num不为0，为No solution
        if (x == 0) return num == 0 ? "Infinite solutions" : "No solution";
        // 其他情况-num/x
        else return "x=" + (-num / x);
    }

    public static void main(String[] args) {
        Leetcode640 leetcode640 = new Leetcode640();
        leetcode640.solveEquation("0x=0");
    }
}
