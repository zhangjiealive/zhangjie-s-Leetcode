//: Leetcode90.java

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/** 力扣90题子集2 https://leetcode.cn/problems/subsets-ii/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode90 {
    List<List<Integer>> res=new LinkedList<>();
    LinkedList<Integer> track=new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsetsWithDupHelp(nums,0);
        return res;
    }

    public void subsetsWithDupHelp(int[] nums,int start) {
            res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            if(i>start&&nums[i]==nums[i-1]){
                continue;
            }
            track.addLast(nums[i]);
            subsetsWithDupHelp(nums,i+1);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] a={4,4,4,1,4};
        Leetcode90 leetcode90 = new Leetcode90();
        leetcode90.subsetsWithDup(a);
    }
}
