import java.util.HashMap;
import java.util.Map;

public class likou03 {
    /**
     * 滑动窗口：窗口尾部指针遍历整个串，当遇到一个元素后存储他的下标位置+1进入map，在map中包含这个元素后直接将窗口左侧缩小至出现重复字符位置后面的一个字符，此时窗口又不重复了，并且每次更新big值
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int big=0;
        int head=0;
        int end=0;
        int length=s.length();
        while(end<length) {
            char a=s.charAt(end);
            end++;
            if(map.containsKey(a)){
                head=Math.max(map.get(a),head);
            }
                big=Math.max(big,end-head);
                map.put(a,end);
        }
        return big;
    }

    public int lengthOfLongestSubstring1(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int right=0;
        int left=0;
        int start=0;
        int length=0;
        int res=0;
        while (right<s.length()){
            char a=s.charAt(right);
            right++;
            map.put(a,map.getOrDefault(a,0)+1);
            while (map.get(a)>1){
                char b=s.charAt(left);
                left++;
                map.put(b,map.getOrDefault(b,0)+1);
            }
            res=Math.max(res,right-left);
        }
        return res;
    }

    public static void main(String[] args) {
        String s="dvdf";
        likou03 likou03=new likou03();
        System.out.println(likou03.lengthOfLongestSubstring(s));
    }

}
