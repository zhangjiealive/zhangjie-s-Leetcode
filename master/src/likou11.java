/** 11. 盛最多水的容器 https://leetcode.cn/problems/container-with-most-water/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */

public class likou11 {
    /**
     * 思路：双指针控制区间，乘水的容量左右指针中最小的，乘以区间长度
     * 使用双指针不断更新区间，更新max
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        // 左指针
        int i=0;
        // 右指针
        int j=height.length-1;
        // 最大值
        int max=0;
        while (i<j){
            // 取指针位置上较小的，在计算结束后移动较小位置的指针
            if(height[i]>height[j]){
                max=Math.max(max,(j-i)*height[j]);
                j--;
            }
            else {
                max=Math.max(max,(j-i)*height[i]);
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        likou11 likou11=new likou11();
        int[] a= {1,8,6,2,5,4,8,3,7};
        System.out.println(likou11.maxArea(a));
    }
}
