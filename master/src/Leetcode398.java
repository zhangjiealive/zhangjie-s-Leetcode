import java.util.*;

/** 398. 随机数索引 https://leetcode.cn/problems/random-pick-index/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode398 {
    public static void main(String[] args) {
        Solution3 solution2 = new Solution3(new int[]{1});
        solution2.pick(1);
    }
}

/**
 * 水塘抽样算法:有时提交会超时,因为每次取都要遍历一遍数组，复杂度O(N)当取的次数多了，就会超时
 * 构造开销小，pick开销大
 * 当数据量大，pick的次数少，适合
 */
class Solution2 {
    Random random;
    int[] nums;
    int n;
    // 初始化：时间复杂度O(1)
    public Solution2(int[] nums) {
        this.nums=nums;
        random=new Random();
        n=this.nums.length;
    }

    // pick:时间复杂度O(N)
    public int pick(int target) {
        int res=0;
        int count=0;
        for (int i = 0; i < n; i++) {
            // 当当前指针指向target值
            if(nums[i]==target){
                // 记录数组中有多少个target
                count++;
                // nextInt(count)随机生成一个0到count，包含0，不包含count
                // nextInt(1)一定为0，在此数只有一个的时候，一定会把i赋值给res
                if(random.nextInt(count)==0){
                    res=i;
                }
            }
        }
        return res;
    }
}

/**
 * map记录法
 * 构造开销大，pick开销小
 * 当调用pick次数多，比较快
 */
class Solution3 {
    Random random;
    int[] nums;
    int n;
    HashMap<Integer,ArrayList<Integer>> map;

    // 构造的时间复杂度为O(N)
    public Solution3(int[] nums) {
        this.nums=nums;
        random=new Random();
        n=this.nums.length;
        map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            // 当map中不存在此key，则插入
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new ArrayList<>());
            }
            // 把此下标放进去
            map.get(nums[i]).add(i);
        }
    }
    // pick的时间复杂度为0(1)
    public int pick(int target) {
        ArrayList<Integer> integers = map.get(target);
        return integers.get(random.nextInt(integers.size()));
    }
}
