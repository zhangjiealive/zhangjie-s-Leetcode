
import java.util.*;

public class likou16 {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int ans = nums[0] + nums[1] + nums[2];
            for(int i=0;i<nums.length;i++) {
                int start = i+1, end = nums.length - 1;
                while(start < end) {
                    int sum = nums[start] + nums[end] + nums[i];
                    if(Math.abs(target - sum) < Math.abs(target - ans))
                        ans = sum;
                    if(sum > target)
                        end--;
                    else if(sum < target)
                        start++;
                    else
                        return ans;
                }
            }
            return ans;
        }

    public static void main(String[] args) {
            int[] a={-3,-2,-5,3,-4};
        likou16 likou16 = new likou16();
        System.out.println(likou16.threeSumClosest(a, -1));
    }
}
