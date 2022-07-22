import java.util.HashMap;

/** 986. 区间列表的交集 https://leetcode.cn/problems/interval-list-intersections/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode659 {
    /**
     * 思路：遍历一次数组，对所有元素计数
     * 之后再次遍历数组，可以看作只有两种操作
     * 1.将此值插入已经存在的序列
     * 2.用此值新建一个序列
     * @param nums
     * @return
     */
    public boolean isPossible(int[] nums) {
        // 记录需要每个值的个数
        HashMap<Integer,Integer> need=new HashMap<>();
        // 记录拥有每个值的个数
        HashMap<Integer,Integer> have=new HashMap<>();
        // 遍历一遍数组，对每个值进行计数
        for (int a: nums) {
            have.put(a,have.getOrDefault(a,0)+1);
        }
        // 遍历数组
        for (int a : nums) {
            // 当此元素已经用完了，跳过此次循环
            if(have.get(a)==0){
                continue;
            }
            // 先试着将此值插到已有序列后面（当对此值有需求的话）
            if(need.containsKey(a)&&need.get(a)>0){
                // 将此值的拥有数量-1
                have.put(a,have.getOrDefault(a,0)-1);
                // 将此值的需求数量-1
                need.put(a,need.getOrDefault(a,0)-1);
                // 将a+1的需求值+1
                need.put(a+1,need.getOrDefault(a+1,0)+1);
            }
            // 不能插到后面的话试着重新创建一个序列，以此值作为头（要求拥有此值，此值+1和此值+2的数量至少为1）
            else if(have.getOrDefault(a,0)>0&&have.getOrDefault(a+1,0)>0&&have.getOrDefault(a+2,0)>0){
                // 将此值的拥有数量-1
                have.put(a,have.getOrDefault(a,0)-1);
                // 将此值+1的拥有数量-1
                have.put(a+1,have.getOrDefault(a+1,0)-1);
                // 将此值+2的拥有数量-1
                have.put(a+2,have.getOrDefault(a+2,0)-1);
                // 将此值+3的需求数量+1
                need.put(a+3,need.getOrDefault(a+3,0)+1);
            }
            // 当无法进行以上任何操作，直接返回false
            else {
                return false;
            }
        }
        // 在遍历完整个数组都没有返回false后，返回true
        return true;
    }
}
