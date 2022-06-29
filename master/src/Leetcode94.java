import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
//94. 二叉树的中序遍历  思想：将所有节点当成新二叉树
/** 力扣94题
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> integers = new LinkedList<>();
        inorderTraversalHelp1(root,integers);
        return integers;
    }
    public void inorderTraversalHelp(TreeNode root,List<Integer> integers) {  // 递归算法
        if(root!=null){
            inorderTraversalHelp(root.left,integers);
            integers.add(root.val);
            inorderTraversalHelp(root.right,integers);
        }
    }

    /**先一直往左子树找，root=root.left,如果root为空，栈顶出栈(回到前驱(此左子树的双亲结点))插入链表，而后往右子树找，循环此操作，从而达到左中右的遍历顺序
     *
     * @param root
     * @param integers
     */
    public void inorderTraversalHelp1(TreeNode root,List<Integer> integers){  // 非递归算法
        Stack<TreeNode> treeNodes = new Stack<>();
        while(root!=null||!treeNodes.isEmpty()){
            if(root!=null){
                treeNodes.push(root);
                root=root.left;
            }
            else {
                root=treeNodes.pop();
                integers.add(root.val);
                root=root.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3,null,null);
        TreeNode treeNode2 = new TreeNode(2,treeNode3,null);
        TreeNode treeNode1 = new TreeNode(1,null,treeNode2);
        Leetcode94 leetcode94 = new Leetcode94();
        leetcode94.inorderTraversal(treeNode1);
    }
}
