import java.util.Arrays;
import java.util.HashMap;

/** 1. 两数之和 https://leetcode.cn/problems/two-sum/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode1 {
    public int[] twoSum(int[] nums, int target) {
        int n= nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<n;i++) {
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return nums;
    }

    public static void main(String[] args) {
        Leetcode1 leetcode1 = new Leetcode1();
        int[] a=new int[]{3,2,4};
        leetcode1.twoSum(a,6);
    }
}
