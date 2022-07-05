//297. 二叉树的序列化与反序列化

import java.util.LinkedList;

/** 力扣297题 https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode297 {
    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3,t4,t5);
        TreeNode t2 = new TreeNode(2);
        TreeNode t1 = new TreeNode(1,t2,t3);
        codec.serialize(t1);
    }
}
class Codec {

    // Encodes a tree to a single string.
    String NULL="#";
    String SEP=",";

    /**
     * 通过前序遍历序列化（前序遍历，走到节点就直接执行，然后往左走，往左走，知道左为空，往右走）
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelp(root,sb);
        return sb.toString();
    }

    /**
     *
     * @param root
     * @param sb
     */
    public void serializeHelp(TreeNode root,StringBuilder sb) {
        //如果为空，拼接#,
        if(root==null){
            sb.append(NULL).append(SEP);
            // 返回
            return;
        }
        // 正常的话拼接root.val，
        sb.append(root.val).append(SEP);
        // 递归实现左子树
        serializeHelp(root.left,sb);
        // 递归实现右子树
        serializeHelp(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes=new LinkedList<>();
        // 通过，切割字符串，并全部放到list中
        for (String s : data.split(",")) {
            nodes.addLast(s);
        }
        return deserializeHelp(nodes);
    }

    public TreeNode deserializeHelp(LinkedList<String> strings) {
        if(strings.isEmpty()){
            return null;
        }
        // 每次都从列表头部拿
        String first=strings.removeFirst();
        if(first.equals(NULL)){
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(first));
        root.left=deserializeHelp(strings);
        root.right=deserializeHelp(strings);
        return root;
    }

}