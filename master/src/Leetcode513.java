public class Leetcode513 {
    public int findBottomLeftValue(TreeNode root) {
        int lastLeft = 0;
        if(root.left==null) {
            lastLeft=root.val;
        }
        while(root.left!=null){
            root=root.left;
            lastLeft=root.val;
        }
        return lastLeft;
    }
}
