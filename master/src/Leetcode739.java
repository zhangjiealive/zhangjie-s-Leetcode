import java.util.ArrayDeque;
import java.util.Deque;

/** 739. 每日温度 https://leetcode.cn/problems/daily-temperatures/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode739 {
    /**
     * 单调栈
     * 注意因为找的是在后面第几天，温度比今天高，所以应该把温度比今天高的数组下标存入栈
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int length=temperatures.length;
        int[] res=new int[length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = length-1; i >=0 ; i--) {
            // 栈不为空，并且目前指针指向的元素大于或等于栈顶的数组下标对应的元素，就将栈顶元素出栈（只能存大的，和当前指针的元素一样大或者小的通通出栈）
            while (!stack.isEmpty()&&temperatures[i]>=temperatures[stack.peek()]){
                stack.pop();
            }
            // 栈为空的话为0，不为空为数组下标的差距（对应着差几天）
            res[i]= stack.isEmpty()?0:(stack.peek()-i);
            stack.push(i);
        }
        return res;
    }

    /**
     * 暴力解法
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures1(int[] temperatures) {
        int length=temperatures.length;
        int[] res=new int[length];
        for (int i = 0; i < length; i++) {
            if(i==length-1){
                res[i]=0;
                break;
            }
            for (int j = i+1; j < length; j++) {
                if(temperatures[j]>temperatures[i]){
                    res[i]=j-i;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode739 leetcode739 = new Leetcode739();
        int[] a={73,74,75,71,69,72,76,73};
        leetcode739.dailyTemperatures1(a);
    }
}
