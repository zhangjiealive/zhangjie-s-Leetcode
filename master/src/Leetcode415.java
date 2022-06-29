//415. 字符串相加
/** 力扣415题 https://leetcode.cn/problems/add-strings/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode415 {
    public String addStrings(String num1, String num2) {
        StringBuilder s = new StringBuilder();
        int num1Tail=num1.length()-1;
        int num2Tail=num2.length()-1;
        int flag=0;
        int replace=0;
        while(num1Tail>-1||num2Tail>-1||flag!=0){
            if(num1Tail<=-1&&num2Tail<=-1&&flag!=0){
                s.insert(0,flag);
            }
            if(num1Tail==-1){
                replace=(num2.charAt(num2Tail)-'0')+flag;
                flag=0;
                if(replace>9){
                    replace=replace-10;
                    flag=1;
                }
                s.insert(0,replace);
            }
            else if(num2Tail==-1){
                replace=(num1.charAt(num1Tail)-'0')+flag;
                flag=0;
                if(replace>9){
                    replace=replace-10;
                    flag=1;
                }
                s.insert(0,replace);
            }
            else {
                replace=(num1.charAt(num1Tail)-'0'+num2.charAt(num2Tail)-'0')+flag;
                flag=0;
                if(replace>9){
                    replace=replace-10;
                    flag=1;
                }
                s.insert(0,replace);
            }
            num2Tail--;
            num1Tail--;
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Leetcode415 leetcode415 = new Leetcode415();
        leetcode415.addStrings("456","77");
    }
}
