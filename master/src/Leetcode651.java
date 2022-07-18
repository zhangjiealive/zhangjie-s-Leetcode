/** 651. 四键键盘 https://leetcode.cn/problems/4-keys-keyboard/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode651 {
    /**
     * 动态规划：自底向上
     * 状态：剩余的可操作数
     * base case 当可操作数为0，输入字符为0
     * 选择：
     * 第一种：当n比较小:一直输入A
     * 第二种，当n比较大，输入一定的A，开始Ctrl A Ctrl C，然后Ctrl V
     * @param n
     * @return
     */
    public int maxA(int n){
        // dp数组，存储每一步最大的字符数
        int[] nums=new int[n+1];
        // base case当n为0，字符为0，输入字符为0
        for (int i = 1; i < n+1; i++) {
            // 第一种，一直输入A
            nums[i]=nums[i-1]+1;
            // 在第一种一直输入A和在不同的地方进行Ctrl A Ctrl C的结果中取最大
            // j从2开始，因为总要给Ctrl A Ctrl C留2步，而且num[j-2]也会越界，i一定要大于j，因为必须给i留一次Ctrl V的机会，不然前面的Ctrl A Ctrl C就是无效操作，不可能得到最优的值
            for (int j = 2; j < i; j++) {
                // nums[j-2]是因为Ctrl A Ctrl C需要占2步，j-2到j之间的2步留给它们，所以只剩下i-j步可以Ctrl V，+1是因为之前已经输入了一些A，加上那些A
                nums[i]=Math.max(nums[i],nums[j-2]*(i-j+1));
            }
        }
        return nums[n];
    }
}
