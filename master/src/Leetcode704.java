//: Leetcode704.java

/** 力扣704. 二分查找 https://leetcode.cn/problems/binary-search/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode704 {
    // 普通二分查找(两头闭)
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                right=mid-1;
            }
            else if(nums[mid]<target){
                left=mid+1;
            }
        }
        return -1;
    }
    /*寻找左侧边界的二分查找(两头闭)
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }
            else if(nums[mid]>target){
                right=mid-1;
            }
            else if(nums[mid]==target){
                right=mid-1;
            }
        }
        // 为了检测是否越界，因为left为nums.length或者大于就是空指针异常，但是这个left返回值可以用来判定有多少小于target的数,但是此处如果找不到元素返回-1
        if(left>=nums.length||nums[left]!=target){
        return -1;
        }
        return left;
    * */
    // 寻找左侧边界的二分查找(左闭右开)
    public int leftBoundSearch(int[] nums, int target) {
        if(nums.length==0){
            return -1;
        }
        int left=0;
        int right=nums.length;

        while (left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                right=mid;
            }
            else if(nums[mid]<target){
                left=mid+1;
            }
            else if(nums[mid]>target){
                right=mid;
            }
        }
        if(left==nums.length) return -1;
        return nums[left]==target?left:-1;
    }
    /*寻找右侧边界的二分查找(两头闭)
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }
            else if(nums[mid]>target){
                right=mid-1;
            }
            else if(nums[mid]==target){
                left=mid+1;
            }
        }
        // 为了检测是否越界，因为right小于0就是空指针异常，但是这个right返回值可以用来判定有多少小于target的数，但是此处如果找不到元素返回-1
        if(right<0||nums[right]!=target){
        return -1;
        }
        return right;
    * */
    // 寻找右侧边界的二分查找(左闭右开)
    public int rightBoundSearch(int[] nums, int target) {
        if(nums.length==0){
            return -1;
        }
        int left=0;
        int right=nums.length;

        while (left<right){
            int mid=left+(right-left)/2;

            if(nums[mid]==target){
                left=mid+1;
            }
            else if(nums[mid]<target){
                left=mid+1;
            }
            else if(nums[mid]>target){
                right=mid;
            }
        }
        if(left==0) return -1;
        return nums[left-1]==target?(left-1):-1;
    }

    public int[] searchRange(int[] nums, int target) {
        int a=leftBoundSearch(nums,target);
        int b=rightBoundSearch(nums,target);
        return new int[]{a,b};
    }

    public static void main(String[] args) {
        Leetcode704 leetcode704 = new Leetcode704();
        int[] a={2,3,9,10,11,23,24};
        leetcode704.searchRange(a,12);
    }
}
