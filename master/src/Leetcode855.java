import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
/** 855. 考场就座 https://leetcode.cn/problems/exam-room/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode855 {
    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom(10);
        examRoom.seat();
        examRoom.seat();
        examRoom.seat();
        examRoom.seat();
        examRoom.leave(4);
        examRoom.seat();
    }
}

/**
 * 考场就坐问题:线段法，考场为空优先坐0，0坐了之后优先坐最后一个，其余情况安排一个距离其他考生最远的座位，当距离相同，优先坐靠0的位置
 *
 * 动态有序集合有二叉堆和平衡二叉搜索树，二叉堆实现取最值的负责度为O(logN)，但是只能删除最大值
 * 平衡二叉搜索树，也可以取最值，还可以修改，删除任意一个值，所以本题用平衡二叉搜索树
 */
class ExamRoom {

    private Map<Integer,int []> startMap;
    private Map<Integer,int []> endMap;
    // TreeSet，平衡二叉树
    private TreeSet<int []> pq;
    private int n;
    // 构造函数，n为座位数
    public ExamRoom(int n) {
        this.n=n;
        // 起点区间，以区间开始值为key，区间为value
        startMap=new HashMap<>();
        // 终点区间，以区间结束值为key，区间为value
        endMap=new HashMap<>();
        // 根据距离升序，如果距离相同，则根据起点降序，因为题目要求优先使用靠前的座位
        pq=new TreeSet<>((a,b)->{
            int distA=distance(a);
            int distB=distance(b);
            if(distA==distB){
                return b[0]-a[0];
            }
            return distA-distB;
        });
        // 将区间-1到n加入，-1和n为虚拟头节点和虚拟尾节点
        addInterval(new int[]{-1,n});

    }
    // 移除区间
    private void removeInterval(int[] intv){
        // 从平衡二叉树中移除这个区间
        pq.remove(intv);
        // 从起点区间中移除key为intv起点的value
        startMap.remove(intv[0]);
        // 从终点区间中移除key为intv终点的value
        endMap.remove(intv[1]);
    }
    // 增加区间
    private void addInterval(int[] intv){
        // 在平衡二叉树中增加这个区间
        pq.add(intv);
        // 在起点区间中加入key为intv起点的intv
        startMap.put(intv[0],intv);
        // 在终点区间中加入key为intv终点的intv
        endMap.put(intv[1],intv);
    }
    // 计算区间中点到端点的距离
    private int distance(int[] intv){
        int x=intv[0];
        int y=intv[1];
        // 如果这个线段起点为头节点（最前面的线段），大小为整个区间
        if(x==-1){
            return y;
        }
        // 如果这个线段终点为尾节点（最后面的线段），大小为整个区间
        if(y==n){
            return n-1-x;
        }
        // 否则为区间的一半
        return (y-x)/2;
    }
    // 给某考生安排一个座位
    public int seat() {
        // 拿出最大的区间
        int[] longest = pq.last();
        int x=longest[0];
        int y=longest[1];
        int seat;
        // 当区间起点为头节点，此时0为空，优先坐0
        if(x==-1){
            seat=0;
        }
        // 当区间终点为尾节点，此为n-1为空，优先坐n-1
        else if(y==n){
            seat=n-1;
        }
        // 正常就坐最长线段的中点
        else {
            seat=(y-x)/2+x;
        }
        // 把大区间分为两个小区间，从seat位置划分
        int[] left=new int[]{x,seat};
        int[] right=new int[]{seat,y};
        // 将大区间删除
        removeInterval(longest);
        // 加入两个小区间
        addInterval(left);
        addInterval(right);
        // 返回此轮坐的位置
        return seat;
    }
    // 此座位的考生离开教室
    public void leave(int p) {
        // 从终点区间中，取出key为p的，因为p在终点区间中为终点，所以取出的应该为左区间
        int[] left=endMap.get(p);
        // 从起点区间中，取出key为p的，因为p在起点区间中为起点，所以取出的应该为右区间
        int[] right=startMap.get(p);
        // 使用左区间的起点和右区间的终点，可以得到一个大的区间
        int[] merged=new int[]{left[0],right[1]};
        // 移除两个小的区间
        removeInterval(left);
        removeInterval(right);
        // 加入大的区间
        addInterval(merged);
    }
}
