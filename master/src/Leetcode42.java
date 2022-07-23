/** 42. 接雨水 https://leetcode.cn/problems/trapping-rain-water/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode42 {
    /**
     * 接雨水，当前点可以接的雨水为左边最大的，和右边最大的中取最小值，减去当前的高度
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int n= height.length;
        // 左边最大的备忘录数组：记录在各点左边最大的值
        int[] leftMax=new int[n];
        // 右边最大的备忘录数组，记录在各点右边最大的值
        int[] rightMax=new int[n];
        // 左边第一位最大的就是高度，只有一个值
        leftMax[0]=height[0];
        // 右边第一位最大的就是高度
        rightMax[n-1]=height[n-1];
        // 根据之前一位的最大值和这一位的高度，得出新一位的最大值（类似动态规划思想）
        for (int i = 1; i < n; i++) {
            leftMax[i]=Math.max(leftMax[i-1],height[i]);
            rightMax[n-i-1]=Math.max(rightMax[n-i],height[n-i-1]);
        }
        int res=0;
        // 遍历数组，从当前点左侧的最大值和右侧最大值中取最小的，减去当前点的高度，就是此位置可以装的雨水，进行累加
        // （当当前这位就是左侧或者右侧的最大值时不用担心，会从中取出最小的，在减去这位，或者想象一下当前柱子为左侧或右侧最大，所以不可能装的了雨水）
        for (int i = 1; i <n-1 ; i++) {
            res=res+Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode42 leetcode42 = new Leetcode42();
        leetcode42.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}
