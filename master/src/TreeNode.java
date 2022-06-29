import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

    /**递归查询此二叉树的深度
     *
     * @param root
     * @return
     */
      public int maxDepth(TreeNode root) {
          if(root==null){
            return 0;
          }
          else {
              int a=maxDepth(root.left);
              int b=maxDepth(root.right);
              if(a>b){
                  return a+1;
              }
              else{
                  return b+1;
              }
          }
      }

      public int NodeCount(TreeNode root){
          if(root==null){
              return 0;
          }
          else{
              return NodeCount((root.left))+NodeCount(root.left)+1;
          }
      }

    public List<List<Object>> levelOrder(TreeNode root){
          Queue<TreeNode> queue=new LinkedList<>();
          List<List<Object>> res = new LinkedList<>();
          if(root==null){
              return res;
          }
          TreeNode p = new TreeNode();
          queue.offer(root);
          while (!queue.isEmpty()){
              int size=queue.size();
              List<Object> objects = new LinkedList<>();
              for (int i = 0; i < size; i++) {
                  p=queue.poll();
                  objects.add(p.val);
                  if(p.left!=null){
                      queue.offer(p.left);
                  }
                  if(p.right!=null){
                      queue.offer(p.right);
                  }
              }
              res.add(objects);
          }
          return res;
      }

}
