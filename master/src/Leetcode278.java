/** 278. 第一个错误的版本 https://leetcode.cn/problems/first-bad-version/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode278 {
    /**
     * 二分查找（两头闭）
     * 思路：因为要找第一个错误的版本，所以要使用左侧边界的二分查找
     * 找到错误的版本后，会不断压缩区间，去找左侧边界
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        // 左指针，版本从1开始
        int left=1;
        // 右指针，版本到n结束
        int right=n;
        while(left<=right){
            // mid为left和right的中间值，二进制右移一位等于除以2
            int mid=left+(right-left)/2;
            // 如果不是错误的版本，代表错误版本还在后面，左指针移到中点+1的位置
            if(!isBadVersion(mid)){
                left=mid+1;
            }
            // 如果是错误的版本，代表已经找到错误的版本了，但是还不是第一个错误的版本，右指针移到mid-1的位置继续搜索
            else if(isBadVersion(mid)){
                right=mid-1;
            }
        }
        return left;
    }

    boolean isBadVersion(int version){
        return true;
    }
}
