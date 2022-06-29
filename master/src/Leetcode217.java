//: Leetcode217.java

import java.util.HashSet;
import java.util.Set;

/** 力扣217题 https://leetcode.cn/problems/contains-duplicate/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> integers = new HashSet<>();
        for (int a:nums) {
            if(!integers.add(a)){
                return true;
            }
        }
        return false;
    }
}
