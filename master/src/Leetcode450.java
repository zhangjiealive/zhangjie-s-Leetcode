/** 450. 删除二叉搜索树中的节点 https://leetcode.cn/problems/delete-node-in-a-bst/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode450 {
    /**
     * 递归思路：DFS找到需要删除的节点，将此节点的右子树插到此节点的左子树的最右子树上
     * 因为二叉排序树，右子树的大小比父节点大，父节点没有了，那么左子树中最大的，应该是最右子树，直接插到最右子树上，可以保证还是二叉排序树
     * 缺点:树的高度增大
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        // 边界情况，直接返回null
        if(root==null){
            return null;
        }
        // 当根节点的值等于key，找到需要删除的节点了
        if(root.val==key){
            // 如果左子树为空，直接返回右子树
            if(root.left==null){
                return root.right;
            }
            // 如果右子树为空，直接返回左子树
            else if(root.right==null){
                return root.left;
            }
            // 都不为空
            else {
                TreeNode t=root.left;
                // 去找左子树的最右子树
                while (t.right!=null){
                    t=t.right;
                }
                // 将根节点的右子树接到左子树的最右子树上
                t.right=root.right;
            }
            // 返回左子树
            return root.left;
        }
        // 如果根节点的值大于key，则取左子树找
        else if(root.val>key){
            root.left= deleteNode(root.left,key);
        }
        // 其余情况就是如果根节点的值小于key，则取右子树找
        else {
            root.right= deleteNode(root.right,key);
        }
        // 如果没在第一轮递归就返回结果，则删除的是左右子树上的某个节点，在第一轮递归中还是返回root
        return root;
    }
}
