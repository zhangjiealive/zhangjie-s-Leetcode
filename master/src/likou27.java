
//: likou27.java

/** 力扣1108题 https://leetcode.cn/problems/remove-element/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class likou27 {
    public int removeElement(int[] nums, int val) {
        int count=0;
        int replace;
        int head=0;
        int tail=nums.length-1;
        while(head<=tail){
            if (nums[head]==val){
                if(nums[tail]!=val){
                    replace=nums[head];
                    nums[head]=nums[tail];
                    nums[tail]=replace;
                    head++;
                    tail--;
                    count++;
                }
                else {
                    tail--;
                    count++;
                }
            }
            else{
                head++;
            }
        }
        if(nums.length==1&&nums[0]==val){
            return 0;
        }
        return nums.length-count;
    }

    /**
     * 快慢指针 本方法也可以解283题，移动零(只需要把val改成0)
     * @param nums
     * @param val
     * @return
     */
    public int removeElement1(int[] nums, int val) {
        int slow=0;
        int fast=0;
        // 让快指针遍历整个数组
        while (fast<nums.length){
            // 如果慢指针指向目标值，快指针不为目标值就进行交换，如果慢指针指向目标值，但快指针不为目标值就让快指针去找非目标值，并且每次交换后快慢指针都往前走一步
            if(nums[slow]==val&&nums[fast]!=val){
                int temp=nums[slow];
                nums[slow]=nums[fast];
                nums[fast]=temp;
                slow++;
            }
            // 如果慢指针不为目标值，则去找目标值
            if(nums[slow]!=val){
                slow++;
            }
            // 并且因为一直交换，并没有删除，一直会把目标值往后移，直到快指针遍历完数组后，慢指针后都为目标值了
            fast++;
        }
        return slow;
    }

    public int removeElement2(int[] nums, int val) {
        int fast=0;
        int slow=0;
        while(fast<nums.length){
            // 只要fast指针不为目标值，就交换。
            if(nums[fast]!=val){
                nums[slow]=nums[fast];
                slow++;
            }
            // 当fast为目标值时，fast往后找非目标值，这样目标值一直会被抛弃，直到数组遍历完
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        likou27 likou27 = new likou27();
        int[] a={1,2,2,2,3,3,4,4,5};
        likou27.removeElement1(a,2);
    }
}
