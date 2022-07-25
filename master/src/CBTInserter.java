import java.util.ArrayDeque;
import java.util.Queue;

/** 919. 完全二叉树插入器 https://leetcode.cn/problems/complete-binary-tree-inserter/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class CBTInserter {
    /**
     * 思路：使用数组存储，因为完全二叉树的索引满足左子树索引是父节点的2倍，右子树的索引是父节点的2倍+1
     */
    TreeNode root;
    // 数组存储完全二叉树
    TreeNode[] treeNodes=new TreeNode[2500];
    // BFS核心数据结构
    Queue<TreeNode> deque=new ArrayDeque<>();
    // index，保存现在存储到数组的哪个位置，0位不使用
    int w=1;

    /**
     * 使用队列初始化完全二叉树数组
     * @param root
     */
    public CBTInserter(TreeNode root) {
        this.root=root;
        deque.offer(root);
        // BFS框架
        while (!deque.isEmpty()){
            int size=deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode=deque.poll();
                // 按下标位置存入数组
                treeNodes[w++]=treeNode;
                if(treeNode.left!=null){
                    deque.offer(treeNode.left);
                }
                if(treeNode.right!=null){
                    deque.offer(treeNode.right);
                }
            }
        }
    }

    /**
     * 插入方法
     * @param val
     * @return
     */
    public int insert(int val) {
        // 根据当前插入到的位置w/2，找出此次插入到哪个父节点下
        TreeNode r = treeNodes[w / 2];
        // 如果w%2==0则是左子树位置，插入到父节点的左子树
        if(w%2==0){
            r.left=new TreeNode(val);
            treeNodes[w++]=r.left;
        }
        // 否则插入到右子树
        else {
            r.right=new TreeNode(val);
            treeNodes[w++]=r.right;
        }
        // 返回父节点的值
        return r.val;
    }
    // 返回根节点，直接返回数组第2位，索引为1
    public TreeNode get_root() {
        return treeNodes[1];
    }

    public static void main(String[] args) {
        TreeNode b=new TreeNode(2);
        TreeNode a=new TreeNode(1,null,null);
        CBTInserter cbtInserter = new CBTInserter(a);
        cbtInserter.insert(2);
        cbtInserter.insert(3);
        cbtInserter.insert(4);
        cbtInserter.insert(5);
        cbtInserter.insert(6);
        cbtInserter.get_root();
    }
}
