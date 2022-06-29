//: Leetcode58.java

/** 力扣58题 https://leetcode.cn/problems/length-of-last-word/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode58 {
    public int lengthOfLastWord(String s) {
        int index=s.length()-1;
        int worldlength=0;
        while (s.charAt(index)==' '){
            index--;
        }
        while (index>=0&&s.charAt(index)!=' '){
            worldlength++;
            index--;
        }
        return worldlength;
    }

    public static void main(String[] args) {
        Leetcode58 leetcode58 = new Leetcode58();
        leetcode58.lengthOfLastWord(" A");
    }

}
