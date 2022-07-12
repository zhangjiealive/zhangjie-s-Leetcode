//316. 去除重复字母

import java.util.ArrayDeque;

/** 力扣316题 https://leetcode.cn/problems/remove-duplicate-letters/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode316 {
    /**单调栈
     * 对字符串进行去重（保持相对位置，不可以打乱顺序，所以不可以用set集合）
     * 并且保持字典序最小，意为ASCII码小的在前面
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        // 建立一个数组用来存储字符在字符串中是否还有
        int[] count=new int[256];
        for (char c: s.toCharArray()) {
            // 对每个字符进行计数
            count[c]++;
        }
        // 标记数组，用来判断某字符在栈中是否存在
        boolean[] remark=new boolean[256];
        // 队列用于栈，比stack快
        ArrayDeque<Character> stack = new ArrayDeque<>();
        // 遍历s字符串
        for (char c:s.toCharArray()) {
            // 每循环一次，都将计数数组此位置减小一个
            count[c]--;
            // 如果标记数组中此字符已经为true，说明栈里已经存在
            if(remark[c]){
                // 直接执行下一次循环
                continue;
            }
            // 当栈不为空，并且栈顶元素比目前字符的ascii码大
            while (!stack.isEmpty()&&stack.peek()>c){
                // 如果栈顶这个字符在后面没有了，跳出循环（因为后面没有这个字符了，会对去重结果造成影响）
                if(count[stack.peek()]==0){
                    break;
                }
                // 如果字符串后面还有的话，出栈，并且将此字符的标记位置false
                remark[stack.poll()]=false;
            }
            // 正常进栈
            stack.push(c);
            // 标志位记为true
            remark[c]=true;
        }
        // 使用一个stringbuffer用来拼接
        StringBuffer sb=new StringBuffer();
        while (!stack.isEmpty()){
            sb.append(stack.poll());
        }
        return sb.reverse().toString();
    }
}
