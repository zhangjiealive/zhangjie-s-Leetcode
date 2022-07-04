//875.爱吃香蕉的珂珂

/** 力扣875题 https://leetcode.cn/problems/koko-eating-bananas/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode875 {
    /**
     * 利用了二分法缩小区间，注意最大速度被设定为题目给的最大值，因为要找最小的，所以用找左侧区间方法
     * 关联1011 410
     * @param piles
     * @param h
     * @return
     */
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1000000000 + 1;
        while (left< right) {
            int mid= left + (right - left) / 2;
            if(canFinish(piles,h,mid)){
                right=mid;
            }
            else {
                left=mid+1;
            }
        }
        return left;
    }

    /**
     * 求在当前速度下，吃掉这一堆香蕉需要多少天，如果小于规定时间返回true，否则返回false
     * @param piles
     * @param h
     * @param speed
     * @return
     */
    public boolean canFinish(int[] piles,int h,int speed){
        int time=0;
        for (int a:piles) {
            time+=timeOf(a,speed);
        }
        return time<=h;
    }

    /**
     * 求这一堆香蕉在当前速度下几天吃完
     * @param a
     * @param speed
     * @return
     */
    public int timeOf(int a,int speed){
        return (a/speed) + (a % speed>0?1:0);
    }
}
