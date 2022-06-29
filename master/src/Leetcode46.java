package likou;
//: Leetcode46.java

/** 力扣46题全排列 https://leetcode.cn/problems/permutations/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
import java.util.LinkedList;
import java.util.List;

public class Leetcode46 {
    List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> once=new LinkedList<>();
        permuteHelp(nums,once);
        return res;
    }

    public void permuteHelp(int[] nums,LinkedList<Integer> once) {
        if(once.size()== nums.length){
            res.add(new LinkedList<>(once));
            return ;
        }
        for (int i = 0; i < nums.length ; i++) {
         if(once.contains(nums[i])){
             continue;
         }
         once.add(nums[i]);
         permuteHelp(nums,once);
         once.removeLast();
        }
    }

    public static void main(String[] args) {
        Leetcode46 leetcode46 = new Leetcode46();
        int[] a={1,2,3};
        System.out.println(leetcode46.permute(a));
    }
}
