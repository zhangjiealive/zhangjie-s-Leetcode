import java.util.LinkedList;
import java.util.List;
//: Leetcode39.java

/** 力扣39. 组合总和 https://leetcode.cn/problems/combination-sum/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode39 {
    List<List<Integer>> res=new LinkedList<>();
    LinkedList<Integer> track=new LinkedList<>();
    int trackSum=0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length==0){
            return res;
        }
        combinationSumHelp(candidates,0, target);
        return res;
    }

    public void combinationSumHelp(int[] candidates, int start,int target) {
        if(trackSum==target){
            res.add(new LinkedList<>(track));
            return;
        }
        if(trackSum>target){
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            trackSum+=candidates[i];
            track.add(candidates[i]);
            combinationSumHelp(candidates,i, target);
            trackSum-=candidates[i];
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        Leetcode39 leetcode39 = new Leetcode39();
        int[] a={2,3,6,7};
        leetcode39.combinationSum(a,7);
    }
}
