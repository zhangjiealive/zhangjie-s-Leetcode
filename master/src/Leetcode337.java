import java.util.HashMap;
import java.util.Map;

/** 337. 打家劫舍 III https://leetcode.cn/problems/house-robber-iii/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode337 {
    // 备忘录，用来解决重叠子问题
    Map<TreeNode,Integer> map=new HashMap<>();

    /**
     * 二叉树的打家劫舍
     * 递归的二叉树遍历
     * 递归的根本思路：从这个偷，从下面的子树开始偷，不断递归
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        // 节点为空，返回0
        if(root==null){
            return 0;
        }
        // 如果备忘录中存在此节点的值，直接取出
        if(map.containsKey(root)){
            return map.get(root);
        }
        // 如果偷根节点，就是根节点的val和继续递归偷左子树的左子树右子树，右子树的左子树右子树
        int do_=root.val+
                (root.left==null?0:rob(root.left.left)+rob(root.left.right))+
                (root.right==null?0:rob(root.right.left)+rob(root.right.right));
        // 如果不偷根节点，就去递归偷左子树和右子树
        int not_do=(rob(root.left)+rob(root.right));
        // 找出最大结果，存入map
        int big=Math.max(do_,not_do);
        map.put(root,big);
        return big;
    }
}
