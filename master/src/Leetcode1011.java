//1011.在 D 天内送达包裹的能力

/** 力扣1011题 https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode1011 {
    /**
     * 二分法 关联875 410
     * @param weights
     * @param days
     * @return
     */
    public int shipWithinDays(int[] weights, int days) {
        // 注意观察题目中提示的区间
        int left=1;
        // 注意可能在一天内让运完，所以最大值要为包裹的最大数*每个包裹的最大重量
        int right=(5*10000+1)*500;
        while (right>left){
            int mid=left + (right - left) / 2;
            // 如果能完成，则去找更小的（左侧区间二分法）
            if(canFinish(weights,days,mid)){
                right=mid;
            }
            // 如果完成不了，则取找大的
            else {
                left=mid+1;
            }
        }
        // 最后返回最左侧区间
        return left;
    }

    /**
     * 检测在当前运输重量下能否完成规定任务
     * @param weight
     * @param days
     * @param min
     * @return
     */
    public boolean canFinish(int[] weight,int days,int min){
        // 默认至少是1
        int time=1;
        int replace=min;
        int i=0;
        while (i<weight.length){
            // 因为包裹不可拆分，所以当包裹重量大于目前承载重量，直接返回false
            if(min<weight[i]){
                return false;
            }
            // 如果小于或等于就从replace中减去
            if(replace>=weight[i]){
                replace=replace-weight[i];
                i++;
            }
            // 如果replace被用完了，则天数加1，重置replace
            else {
                replace=min;
                time++;
            }
        }
        return time<=days;
    }

    public static void main(String[] args) {
        Leetcode1011 leetcode1011 = new Leetcode1011();
        int[] a=new int[]{1,2,3,4,5,6,7,8,9,10};
        leetcode1011.shipWithinDays(a,5);
    }
}
