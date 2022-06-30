import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

public class Leetcode40 {
    List<List<Integer>> res=new LinkedList<>();
    LinkedList<Integer> track=new LinkedList<>();
    int trackSum=0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length==0){
            return res;
        }
        Arrays.sort(candidates);
        combinationSum2Help(candidates,0,target);
        return res;
    }
    public void combinationSum2Help(int[] candidates,int start, int target) {
        if(trackSum==target){
            res.add(new LinkedList<>(track));
            return;
        }
        if(trackSum>target){
            return;
        }
        for (int i = start; i <candidates.length; i++) {
            if(i>start&&candidates[i]==candidates[i-1]){
                continue;
            }
            track.addLast(candidates[i]);
            trackSum+=candidates[i];
            combinationSum2Help(candidates,i+1,target);
            track.removeLast();
            trackSum-=candidates[i];
        }
    }
}
