//116. 填充每个节点的下一个右侧节点指针

import java.util.ArrayDeque;
import java.util.Queue;

/** 力扣116题 https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode116 {
    /**
     * 将第三层看成一个三叉树来进行遍历，递归把之后所有都看成三叉树，目的是将node1.right和node2.left这条线连起来
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if(root==null) return null;
        traverse(root.left,root.right);
        return root;
    }

    public void traverse(Node node1,Node node2){
        if(node1==null||node2==null){
            return;
        }
        node1.next=node2;

        traverse(node1.left,node1.right);
        traverse(node1.right,node2.left);
        traverse(node2.left,node2.right);
    }

    /**
     * 利用层序遍历的特点，因为是完全二叉树，所以在每一层判定是否是最后一个元素
     * @param root
     * @return
     */
    public Node connect1(Node root) {
        Node replace=root;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size= queue.size();
            for (int i = 0; i < size; i++) {
                Node node=queue.poll();
                // 如果不是最后一个元素，则next为队列头的元素
                if(i<size-1){
                    node.next=queue.peek();
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
}
