import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

/** 773. 滑动谜题 https://leetcode.cn/problems/sliding-puzzle/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode773 {
    /**
     * BFS：广度优先遍历暴力破解
     * @param board
     * @return
     */
    public int slidingPuzzle(int[][] board) {
        // 二维数组映射到一维上的邻居
        int[][] neighbor=new int[][]{{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
        // 目标值
        String target="123450";
        // 访问过的元素
        HashSet<String> visited = new HashSet<>();
        // bfs核心队列
        Queue<String> queue=new ArrayDeque();
        StringBuilder sb=new StringBuilder();
        int step=0;
        // 将目前局面按照一维拼接成字符串
        for (int i = 0; i <6 ; i++) {
            sb.append(board[i/3][i%3]);
        }
        // 把起点放入队列
        queue.offer(sb.toString());
        // 加入已访问集合
        visited.add(sb.toString());
        while (!queue.isEmpty()){
            int size=queue.size();
            // 类似于层序遍历
            for (int j = 0; j < size; j++) {
                String s=queue.poll();
                if(s.equals(target)){
                    return step;
                }
                int i=0;
                // 找到此局面中0的位置
                for (; s.charAt(i)!='0'; i++);
                // 从此0位置交换0和邻居生成新的几种局面
                for (int a: neighbor[i] ) {
                    String s1=move(s,i,a);
                    // 防止走回头路，只有在这种局面没有经历过，才放入队列
                    if(!visited.contains(s1)){
                        visited.add(s1);
                        queue.add(s1);
                    }
                }
            }
            step++;
            }
            return -1;
        }

        // 互换字符串中两个位置的元素，并返回一个新字符串
        public String move(String s,int i,int j){
            char[] chars = s.toCharArray();
            char c=chars[i];
            chars[i]=chars[j];
            chars[j]=c;
            return new String(chars);
        }

    public static void main(String[] args) {
        Leetcode773 leetcode773 = new Leetcode773();
        leetcode773.slidingPuzzle(new int[][]{{1,2,3},{5,4,0}});
    }
    }

