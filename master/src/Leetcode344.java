//  Leetcode344.java

/** 力扣344题 https://leetcode.cn/problems/reverse-string/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode344 {
    /**
     * 双指针分别从两端向中心靠近，每次循环交换一次
     * @param s
     */
    public void reverseString(char[] s) {
        int left=0;
        int right=s.length-1;
        while (left<right){
            char temp=s[right];
            s[right]=s[left];
            s[left]=temp;
            right--;
            left++;
        }
    }
}
