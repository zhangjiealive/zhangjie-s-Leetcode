package likou;
//: Leetcode78.java

import java.util.LinkedList;
import java.util.List;

/** 力扣78题子集 https://leetcode.cn/problems/subsets/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode78 {
    List<List<Integer>> res=new LinkedList<>();
    LinkedList<Integer> track=new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        subsetsHelp(nums,0);
        return res;
    }

    public void subsetsHelp(int[] nums,int start) {
        res.add(new LinkedList<>(track));
        for(int i=start;i< nums.length;i++){
            track.addLast(nums[i]);
            subsetsHelp(nums,i+1);
            track.removeLast();
        }
    }
}
