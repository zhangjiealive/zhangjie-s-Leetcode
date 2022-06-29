
import java.util.*;

public class likou11 {
    public int maxArea(int[] height) {
    int i=0;
    int j=height.length-1;
    int max=0;
    while (i<j){
        max=height[i]<height[j]?
                Math.max(max,(j-i)*height[i++]):
                Math.max(max,(j-i)*height[j--]);
    }
    return max;
    }

    public static void main(String[] args) {
        likou11 likou11=new likou11();
        int[] a= {1,8,6,2,5,4,8,3,7};
        System.out.println(likou11.maxArea(a));
    }
}
