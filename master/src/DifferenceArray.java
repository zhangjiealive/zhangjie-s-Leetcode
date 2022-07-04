/**
 * 差分数组，通过差分数组可以达到给一个区间加减
 */
public class DifferenceArray {
    private int[] diff;

    /**
     * 差分数组构造函数
     * 差分数组第0个数和源数组第0个数相同
     * 差分数组其他的第i个数等于（源数组i）-（源数组i-1）
     * @param nums
     */
    public DifferenceArray(int[] nums) {
        assert nums.length>0;
        diff=new int[nums.length];
        diff[0]=nums[0];
        for (int i=1;i<nums.length;i++){
            diff[i]=nums[i]-nums[i-1];
        }
    }

    /**
     * 使i，j区间的所有都加val，差分数组的i位加val，会使i位和之后所有位+val，如果j+1>=diff.length,代表所有i位之后都+val
     * 如果j+1<diff.length，就要在j+1位再减去val
     * @param i
     * @param j
     * @param val
     */
    public void increment(int i,int j,int val){
        diff[i]+=val;
        if(j+1<diff.length){
            diff[j+1]-=val;
        }
    }

    /**
     * 还原时，差分数组和源数组的第1个值相同
     * 其他原数组的第i个值等于，(原数组i-1)+(差分数组i) 所以差分数组一个位置+3，还原后后面的所有位置都会因为前面的一位+3
     * 直到在差分数组的一位-3，对应的此位就不发生变化
     * @return
     */
    public int[] result(){
        int[] res=new int[diff.length];

        res[0]=diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i]=res[i-1]+diff[i];
        }
        return res;
    }
}
