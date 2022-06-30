//: Leetcode47.java

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/** 力扣47题全排列II https://leetcode.cn/problems/permutations-ii/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode47 {
    List<List<Integer>> res=new LinkedList<>();
    LinkedList<Integer> track=new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used=new boolean[nums.length];
        permuteUniqueHelp(nums);
        return res;
    }

    public void permuteUniqueHelp(int[] nums) {
        if(track.size()==nums.length){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i]){
                continue;
            }
            if(i>0&&nums[i]==nums[i-1]&&!used[i-1]){
                continue;
            }
            track.add(nums[i]);
            used[i]=true;
            permuteUniqueHelp(nums);
            track.removeLast();
            used[i]=false;
        }
    }

    public static void main(String[] args) {
        Leetcode47 leetcode47 = new Leetcode47();
        int[] a={1,1,2};
        leetcode47.permuteUnique(a);
    }
}
