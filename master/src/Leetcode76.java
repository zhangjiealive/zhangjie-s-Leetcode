//: Leetcode76.java

import java.util.HashMap;

/** 力扣76. 最小覆盖子串 https://leetcode.cn/problems/minimum-window-substring/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode76 {
    /**滑动窗口思想：将需要匹配的串，所有字符放进map中，统计相应个数，从主串中依次向后滑动扩大窗口，直到窗口中拥有所有需匹配串的值，此时存储目前串的位置
     * 接下来开始缩小窗口，当往后缩小后不拥有所有需匹配串的值时，继续扩大窗口，循环这个过程，直到找到最小的串。
     *
     * @param s 主串
     * @param t 需要匹配的字符串
     * @return
     */
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        // 将需匹配的所有字符放进一个map
        for (int i = 0; i < t.length(); i++) {
            char c1 = t.charAt(i);
            need.put(c1, need.getOrDefault(c1,0)+1);
        }
        int left=0;
        int right=0;
        int vaild=0;
        int start=0;
        int len=Integer.MAX_VALUE;
        while (right<s.length()){
            char c=s.charAt(right);
            // 向后扩大窗口
            right++;
            // 当目前窗口指针指向的值是需要匹配的字符时，存储到window的map中
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c,0)+1);
                // 当窗口中拥有此字符的数量和需要匹配的数量相同时，vaild++代表已经将一个字符匹配完成
                if(window.get(c).equals(need.get(c))){
                    vaild++;
                }
            }
            // 当所有字符匹配完成（vaild等于需要匹配的字符种类个数）
            // 判断左侧窗口是否要收缩
            while(vaild==need.size()){
                // 只要此次的窗口大小小于之前最小的，即进行替换
                if(right-left<len){
                    start=left;
                    len=right-left;
                }

                char d=s.charAt(left);

                left++;
                // 当此次缩小窗口缩小掉的字符正好是需要匹配的字符时，获取此字符在窗口中的个数和需要的个数，如果相等，则此时匹配完成的字符又少了一个vaild--
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))){
                        vaild--;
                    }
                    // 无论vaild变不变化都需要把窗口中的这个字符的个数-1
                    window.put(d, window.get(d)-1);
                }
            }
        }
        // 如果最后len的长度还为初始值，返回空，否则返回之前存储的最小窗口
        return len==Integer.MAX_VALUE?"":s.substring(start,start+len);
    }

    public static void main(String[] args) {
        Leetcode76 leetcode76 = new Leetcode76();
        String a="ADOBECODEBANC";
        String b="ABC";
        leetcode76.minWindow(a,b);
    }
}
