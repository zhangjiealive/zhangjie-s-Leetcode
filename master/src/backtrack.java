import java.util.LinkedList;
import java.util.List;

public class backtrack {
    // 回溯算法模板
    List<List<Integer>> res=new LinkedList<>();
    LinkedList<Integer> track=new LinkedList<>();

    void backtrack(int[] nums,int start){
        for (int i = start; i < nums.length; i++) {
            track.addLast(nums[i]);
            backtrack(nums,i+1);
            track.removeLast();
        }
    }
}
