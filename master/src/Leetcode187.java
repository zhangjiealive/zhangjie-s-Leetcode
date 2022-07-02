//187. 重复的DNA序列

import java.util.*;

/** 力扣187题
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode187 {
    public List<String> findRepeatedDnaSequences(String s) {
        int length=s.length();
        if(s.length()<=10){
            return new ArrayList<>();
        }
        int oneleft=0;
        int oneright=9;
        int tworight=length-1;
        int twoleft=tworight-9;
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet();
        while(tworight>oneright){
            String a=s.substring(oneleft,oneright+1);
            String b=s.substring(twoleft,tworight+1);
            oneleft++;
            oneright++;
            twoleft--;
            tworight--;
            map.put(a,map.getOrDefault(a,0)+1);
            map.put(b,map.getOrDefault(b,0)+1);
            if(map.get(a)>1&&!set.contains(a)){
                set.add(a);
            }
            if(map.get(b)>1&&!set.contains(b)){
                set.add(b);
            }
        }
        return new LinkedList<>(set);
    }

    public static void main(String[] args) {
        Leetcode187 leetcode187 = new Leetcode187();
        String a="AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        leetcode187.findRepeatedDnaSequences(a);
    }
}
