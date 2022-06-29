//: Leetcode752.java

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
/**
 * 双向BFS优化方法
 * while (!s1.isEmpty()&&!s2.isEmpty()){
 *     if(s1.size()>s2.size()){
 *         //交换s1和s2
 *         temp=s1;
 *         s1=s2;
 *         s2=temp;
 *         因为队列元素越多扩散的队列元素就越多，每次选择小的集合效率更高
 *     }
 * }
 */
// 双向BFS用于知道起点和终点的找最短距离的题目
/** 力扣752题打开转盘锁 使用双向BFS计算最短距离https://leetcode.cn/problems/open-the-lock/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode752Best {
    public int openLock(String[] deadends, String target) {
        Set<String> dead=new HashSet<>();
        Set<String> s1=new HashSet<>();
        Set<String> s2=new HashSet<>();
        Set<String> visited=new HashSet<>();
        // 将不允许出现的可能直接放入一个set集合
        for (String s:deadends) {
            // 如果不允许的可能等于目标或者出发点，直接返回-1
            if(target==s||target.equals(s)||s=="0000"||s.equals("0000")) return -1;
            dead.add(s);
        }
        s1.add("0000");
        s2.add(target);
        int step=0;
        // 同时从target点和出发点同时开始BFS
        while (!s1.isEmpty()&&!s2.isEmpty()){
            // 用来暂存本次存在的8种可能
            Set<String> temp=new HashSet<>();
            for (String cur:s1) {
                // 如果当前取出的元素为不允许出现的，直接进入下次循环
                if(dead.contains(cur)){
                    continue;
                }
                // 如果从target开始的bfs集合包含开始点目前进行到的位置，或者开始点开始的bfs集合包含target目前进行的位置，就返回步数
                if(s2.contains(cur)){
                    return step;
                }
                // 每次都将此次取出的元素放入已访问的集合
                visited.add(cur);
                // 将本次取出的元素的下次8种可能存入temp（并且保证8种都没有被访问过）
                for (int j = 0; j < 4; j++) {
                    String up=plusOne(cur,j);
                    String down=minusOne(cur,j);
                    if(!visited.contains(up)){
                        temp.add(up);
                    }
                    if(!visited.contains(down)){
                        temp.add(down);
                    }
                }
            }
            // 步数自增
            step++;
            // 将s1和s2交换，意义为如果本次从s1开始bfs，下次就会从s2
            s1=s2;
            // 将本次temp种的几种可能给s2(但是在下次循环中s2又会变为s1)
            s2=temp;
        }
        return -1;
    }
    public String plusOne(String s,int j){
        char[] ch=s.toCharArray();
        if(ch[j]=='9'){
            ch[j]='0';
        }
        else{
            ch[j]+=1;
        }
        return new String(ch);
    }

    public String minusOne(String s,int j){
        char[] ch=s.toCharArray();
        if(ch[j]=='0'){
            ch[j]='9';
        }
        else{
            ch[j]-=1;
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        Leetcode752Best leetcode752Best = new Leetcode752Best();
        String[] ss={"5557","5553","5575","5535","5755","5355","7555","3555","6655","6455","4655","4455","5665","5445","5645","5465","5566","5544","5564","5546","6565","4545","6545","4565","5656","5454","5654","5456","6556","4554","4556","6554"};
        System.out.println(leetcode752Best.openLock(ss, "5555"));
    }
}
