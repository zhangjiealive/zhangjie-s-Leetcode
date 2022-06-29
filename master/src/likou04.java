
import java.util.Arrays;

public class likou04 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a=nums1.length;
        int b=nums2.length;
        double d=0.0;
        int[] num=new int[a+b];
        System.arraycopy(nums1,0,num,0,a);
        System.arraycopy(nums2,0,num,a,b);
        Arrays.sort(num);
        if(num.length%2==0){
            d=((double) num[(a+b)/2]+(double) num[(a+b)/2-1])/2;
        }
        else {
            d=(num[((a+b)/2)]);
        }
        return d;
    }

    public static void main(String[] args) {
        likou04 likou04 = new likou04();
        int[] nums1={1,2};
        int[] nums2={3,4};
        System.out.println(likou04.findMedianSortedArrays(nums1, nums2));
    }
}
