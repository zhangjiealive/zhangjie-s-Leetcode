import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/** 1863. 找出所有子集的异或总和再求和 https://leetcode.cn/problems/sum-of-all-subset-xor-totals/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode1863 {
    List<LinkedList<Integer>> res;
    LinkedList<Integer> track;

    /**
     * 思路：回溯算法，计算所有子集，然后挨个相异或后结果相加
     * @param nums
     * @return
     */
    public int subsetXORSum(int[] nums) {
        // 存储所有子集
        res=new LinkedList<>();
        // 每次的结果
        track=new LinkedList<>();
        int result=0;
        DFS(nums,0);
        // 使用迭代器遍历所有
        Iterator<LinkedList<Integer>> iterator = res.iterator();
        while (iterator.hasNext()){
            LinkedList<Integer> next = iterator.next();
            // 内部的list再用一个迭代器
            Iterator<Integer> iterator1 = next.iterator();
            int a=0;
            while (iterator1.hasNext()){
                // a于list中所有元素相异或
                a=a^iterator1.next();
            }
            // 用每个list子集的异或结果加到result上
            result+=a;
        }
        return result;
    }

    // DFS回溯算法
    public void DFS(int[] nums,int i){
        // 超出边界，直接返回
        if(i>nums.length){
            return;
        }
        res.add(new LinkedList<>(track));
        // j==i,避免重复，一直往后走，1只会加入1和1后面的，2只会加入2和2后面的，不会存在1，2和2，1的问题
        // 遍历所有选择
        for (int j = i; j < nums.length; j++) {
            // 选择
            track.addLast(nums[j]);
            DFS(nums,j+1);
            // 撤销选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        Leetcode1863 leetcode1863 = new Leetcode1863();
        leetcode1863.subsetXORSum(new int[]{1,3});
    }
}
