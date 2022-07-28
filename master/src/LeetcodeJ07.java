import java.util.HashMap;
import java.util.Map;

/** 剑指 Offer 07. 重建二叉树 https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class LeetcodeJ07 {
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        int m=inorder.length;
        // key为中序遍历的值，value为下标，使用map更快的取下标
        map=new HashMap<>();
        // 遍历中序遍历数组，放入map
        for (int i = 0; i < m; i++) {
            map.put(inorder[i],i);
        }
        // 调用递归函数
        return buildTreeHelp(preorder,0,n-1,inorder,0,m-1);
    }

    /**
     * 递归函数
     * @param preorder
     * @param preStart 前序的起点
     * @param preEnd 前序的终点
     * @param inorder
     * @param inStart 后序的起点
     * @param inEnd 后序的终点
     * @return
     */
    public TreeNode buildTreeHelp(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd){
        // 递归出口，当前序的起点大于终点，代表没有节点了
        if(preStart>preEnd){
            return null;
        }
        // 前序的第一个是根节点
        int root=preorder[preStart];
        // 从map中找到中序中根节点的下标
        int w = map.get(root);
        // 从而确定左子树的大小，在确定右子树的大小
        int leftBound=w-inStart;
        // 根节点
        TreeNode r=new TreeNode(root);
        // 递归生成根节点的左子树
        r.left=buildTreeHelp(preorder,preStart+1,preStart+leftBound,inorder,inStart,w-1);
        // 递归生成根节点的右子树
        r.right=buildTreeHelp(preorder,preStart+leftBound+1,preEnd,inorder,w+1,inEnd);
        return r;
    }

    public static void main(String[] args) {
        int[] a=new int[]{3,9,20,15,7};
        int[] b=new int[]{9,3,15,20,7};
        LeetcodeJ07 leetcodeJ07 = new LeetcodeJ07();
        leetcodeJ07.buildTree(a,b);
    }
}
