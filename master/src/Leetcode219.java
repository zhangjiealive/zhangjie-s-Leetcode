//219. 存在重复元素 II

import java.util.HashMap;

/** 力扣219题 https://leetcode.cn/problems/contains-duplicate-ii/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int right=0;
        while (right<nums.length){
            int a=nums[right];
            if(map.containsKey(a)){
                if(Math.abs(map.get(a)-right)<=k){
                    return true;
                }
            }
            map.put(a,right);
            right++;
        }
        return false;
    }
}
