public class Leetcode35 {
    public int searchInsert(int[] nums, int target) {
        int head=0;
        int tail=nums.length-1;
        while(head<=tail){
            int mid=(tail+head)/2;
            if(nums[mid]!=target){
                if(nums[mid]>target){
                    tail=mid-1;
                }
                else if(nums[mid]<target){
                    head=mid+1;
                    continue;
                }
            }
            else return mid;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] n={1,3,5,6};
        Leetcode35 leetcode35 = new Leetcode35();
        leetcode35.searchInsert(n,2);
    }
}
