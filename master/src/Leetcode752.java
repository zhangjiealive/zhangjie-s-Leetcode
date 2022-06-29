//: Leetcode752.java
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
// 单向BFS用于只知道起点的找最短距离的题目
/** 力扣752题打开转盘锁 使用单向BFS计算最短距离https://leetcode.cn/problems/open-the-lock/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode752 {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue=new LinkedList<>();
        // 用来存储已访问的节点
        Set<String> visited=new HashSet<>();
        // 将初始点放入
        queue.offer("0000");
        // 已访问初始点
        visited.add("0000");
        // 将不允许出现的可能直接放进访问过的元素
        for (String s:deadends) {
            // 如果不允许的可能等于目标或者出发点，直接返回-1
            if(target==s||target.equals(s)||s=="0000"||s.equals("0000")) return -1;
            visited.add(s);
        }
        int step=0;
        // 只有队列不为空
        while (!queue.isEmpty()){
            // 下次循环的次数和队列中的元素有关，可以看成n叉树的层序
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                // 从队尾拿出节点
                String a=queue.poll();
                // 如果和目标相等，返回步数
                if(a==target||a.equals(target)){
                    return step;
                }
                String[] strings=new String[8];
                // 将本次队尾拿出的下次8种变化放进一个字符串数组
                for (int k=0, j = 0; j < 4; j++,k=k+2) {
                    strings[k]=plusOne(a,j);
                    strings[k+1]=minusOne(a,j);
                }
                for (String s :
                        strings) {
                    // 只要他们没有被访问过或者不等于不允许访问的可能，就放入队列，并且放进被访问过的集合
                    if(!visited.contains(s)){
                        queue.offer(s);
                        visited.add(s);
                    }
                }
            }
            step++;
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
        Leetcode752 leetcode752 = new Leetcode752();
        String[] ss={"5557","5553","5575","5535","5755","5355","7555","3555","6655","6455","4655","4455","5665","5445","5645","5465","5566","5544","5564","5546","6565","4545","6545","4565","5656","5454","5654","5456","6556","4554","4556","6554"};
        System.out.println(leetcode752.openLock(ss, "5555"));
    }

}
