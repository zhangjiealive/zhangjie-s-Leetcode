
public class Leetcode31 {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        if(n<=1){
            return;
        }
        int i=nums.length-2;
        int j=nums.length-1;
        int k=nums.length-1;
        while (i>=0&&nums[i]>=nums[j]){
            i--;
            j--;
        }
        if(i>=0){
            while (nums[i]>=nums[k]){
                k--;
            }
            swap(nums,i,k);
        }
        reverse(nums,j,n-1);
        return;
    }

    public void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    public void reverse(int[] nums,int i,int j){
        while (i<j){
            swap(nums,i++,j--);
        }
    }

    public static void main(String[] args) {
        Leetcode31 leetcode31 = new Leetcode31();
        leetcode31.nextPermutation(new int[]{1,1});
    }
}
