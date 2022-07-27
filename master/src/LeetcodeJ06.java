import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/** 剑指 Offer 06. 从尾到头打印链表 https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class LeetcodeJ06 {
    List<Integer> res;

    /**
     * 递归实现后序遍历
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        // 频繁插入使用list
        res=new LinkedList<>();
        // 递归调用
        help(head);
        // 将list中元素移到数组中
        int[] r=new int[res.size()];
        // 使用迭代器加快运行速度
        Iterator<Integer> iterator = res.iterator();
        int i=0;
        while (iterator.hasNext()){
            r[i++]=iterator.next();
        }
        return r;
    }

    /**
     * 类似于二叉树的后序遍历，在后序位置将val加入list
     * @param head
     */
    public void help(ListNode head){
        // 递归出口，当head为空返回
        if(head==null){
            return;
        }
        // 一直往深处递归
        help(head.next);
        // 后序位置加入list
        res.add(head.val);
    }

    public static void main(String[] args) {
        LeetcodeJ06 leetcodeJ06 = new LeetcodeJ06();
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3,node2);
        ListNode node1 = new ListNode(1,node3);
        leetcodeJ06.reversePrint(node1);
    }
}
