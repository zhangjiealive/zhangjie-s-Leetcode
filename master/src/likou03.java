package likou;

import java.util.HashMap;
import java.util.Map;

public class likou03 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int big=0;
        int head=0;
        int end=0;
        int length=s.length();
        for (;end<length; end++) {
            char a=s.charAt(end);
            if(map.containsKey(a)){
                head=Math.max(map.get(a),head);
            }
                big=Math.max(big,end-head+1);
                map.put(a,end+1);
        }
        return big;
    }

    public static void main(String[] args) {
        String s="dvdf";
        likou03 likou03=new likou03();
        System.out.println(likou03.lengthOfLongestSubstring(s));
    }
}
