//410.分割数组的最大值

/** 力扣410题 https://leetcode.cn/problems/split-array-largest-sum/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode410 {
    /**
     * 二分法，关联1011 875
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        // 注意题目给出的提示
        int left=0;
        int right=1000000000+1;
        while (right>left){
            int mid=left+(right-left)/2;
            if(canFinish(nums,m,mid)){
                right=mid;
            }
            else {
                left=mid+1;
            }
        }
        return left;
    }

    /**
     * 检测在当前数值下，是否能完成规定任务（参考Leetcode1011下面的方法）
     * @param weight
     * @param days
     * @param min
     * @return
     */
    public boolean canFinish(int[] weight,int days,int min){
        int time=1;
        int replace=min;
        int i=0;
        while (i<weight.length){
            if(min<weight[i]){
                return false;
            }
            if(replace>=weight[i]){
                replace=replace-weight[i];
                i++;
            }
            else {
                replace=min;
                time++;
            }
        }
        return time<=days;
    }
}
