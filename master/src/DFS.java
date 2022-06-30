public class DFS {  // 树的深度优先遍历
    void DFS(TreeNode root) {
        if (root == null) {
            return;
        }
        //在这两行递归中插入需要的相应操作改造代码
        DFS(root.left);
        DFS(root.right);
    }
}
