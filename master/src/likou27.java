
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

    public static void main(String[] args) {
        likou27 likou27 = new likou27();
        int[] a={1};
        likou27.removeElement(a,1);
    }
}
