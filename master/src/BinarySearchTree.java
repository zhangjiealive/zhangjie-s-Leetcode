/**
 * 二叉搜索树
 */
public class BinarySearchTree {
    /**
     * 在BST插入一个数
     * 找到他所在的区间的空子树
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root,int val){
        // 如果按照条件找到一个空位，则插入
        if(root==null){
            return new TreeNode(val);
        }
        // 如果val大于root.val则去右子树找位置
        if(root.val<val){
            root.right=insertIntoBST(root.right,val);
        }
        // 如果val小于root.val则去左子树找位置
        if(root.val>val){
            root.left=insertIntoBST(root.left,val);
        }
        return root;
    }

    /**
     * 在BST中查找一个值
     * @param root
     * @param target
     * @return
     */
    public TreeNode searchBST(TreeNode root,int target){
        if(root==null){
            return null;
        }
        // 如果target小于root.val则去左子树找
        if(root.val>target){
            return searchBST(root.left,target);
        }
        // 如果target大于root.val则去右子树找
        if(root.val<target){
            return searchBST(root.right,target);
        }
        // 当上面两个都不符合的时候，返回当前节点
        return root;
    }

    /**
     * 在BST中删除一个值
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root,int key){
        if(root==null){
            return null;
        }
        // 如果root.val匹配上后
        if(root.val==key){
            // 第一种情况，左子树和右子树都为空，直接删除即可
            // 第二种情况，左子树或者右子树为空，直接返回那个不为空的子树
            if(root.left==null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }
            // 第三种情况，左子树和右子树都不为空
            // 从右子树找到最小的节点
            TreeNode minNode=getMin(root.right);
            // 删除右子树最小的节点
            root.right=deleteNode(root.right, minNode.val);
            // 用右子树最小的节点替换root节点
            minNode.left=root.left;
            minNode.right=root.right;
            root=minNode;
        }
        // 这里是二叉搜索树搜索元素的过程
        else if(root.val>key){
            root.left=deleteNode(root.left,key);
        }
        else if(root.val<key){
            root.right=deleteNode(root.right,key);
        }
        return root;
    }

    /**
     * 找当前子树最小的
     * @param node
     * @return
     */
    public TreeNode getMin(TreeNode node){
        //BST最左边就是最小的
        while(node.left!=null){
            node=node.left;
        }
        return node;
    }
}
