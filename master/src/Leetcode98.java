//: Leetcode98.java

/** 力扣98. 验证二叉搜索树 https://leetcode.cn/problems/validate-binary-search-tree/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode98 {
    /**
     * 通过中序遍历元素递增的性质
     * 将每个前节点和目前节点的值进行对比，如果目前节点小于前面的节点则标识位false，返回标识位
     * 测例中最小的值是Integer的最小值，出现错误，所以将中间变量设置为Long的最小值
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        isValidBSTHelp(root);
        return mark;
    }
    long replace=Long.MIN_VALUE;
    boolean mark=true;
    public void isValidBSTHelp(TreeNode root) {
        if(root==null){
            return;
        }
        isValidBSTHelp(root.left);
        if(root.val>replace){
            replace=root.val;
        }
        else {
            mark=false;
            return;
        }
        isValidBSTHelp(root.right);
    }
}
