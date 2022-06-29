import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
// 二叉树的后序遍历
/** 力扣145题 https://leetcode.cn/problems/binary-tree-postorder-traversal/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> integers = new LinkedList<>();
        postorderTraversalHelp2(root,integers);
        return integers;
    }

    public void postorderTraversalHelp(TreeNode root,List<Integer> integers) {  // 递归算法
        if(root!=null){
            postorderTraversalHelp(root.left, integers);
            postorderTraversalHelp(root.right, integers);
            integers.add(root.val);
        }
    }

    public void postorderTraversalHelp1(TreeNode root,LinkedList<Integer> integers) {  // 非递归算法
        Stack<TreeNode> treeNodes = new Stack<>();
        if(root==null){
            return;
        }
        TreeNode tmp=new TreeNode();
        treeNodes.push(root);
        while(!treeNodes.isEmpty()) {
            tmp = treeNodes.pop();
            //注意，是放在第一个位置
            integers.addFirst(tmp.val);
            if(tmp.left!=null) {
                treeNodes.push(tmp.left);
            }
            if(tmp.right!=null) {
                treeNodes.push(tmp.right);
            }
        }
    }

    /**将后序遍历看错，中序遍历的逆置，先一直往右子树找，root=root.right,如果root为空，栈顶出栈(回到前驱(此左子树的双亲结点))插入链表，而后往左子树找，循环此操作，从而达到右中左的遍历顺序，在把结果逆置（将每次结果插入链表头，得到同样的效果）
     *
     * @param root
     * @param integers
     */
    public void postorderTraversalHelp2(TreeNode root,LinkedList<Integer> integers) {  // 非递归算法
        Stack<TreeNode> treeNodes = new Stack<>();
        while(root!=null||!treeNodes.isEmpty()){
            if(root!=null){
                integers.addFirst((root.val));
                treeNodes.push(root);
                root=root.right;
            }
            else {
                root=treeNodes.pop();
                root=root.left;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode t7 = new TreeNode(7,null,null);
        TreeNode t6 = new TreeNode(6,null,null);
        TreeNode t5 = new TreeNode(5,null,null);
        TreeNode t4 = new TreeNode(4,null,null);
        TreeNode t3 = new TreeNode(3,t6,t7);
        TreeNode t2 = new TreeNode(2,t4,t5);
        TreeNode t1 = new TreeNode(1,t2,t3);
        Leetcode145 leetcode145 = new Leetcode145();
        leetcode145.postorderTraversal(t1);
    }


}
