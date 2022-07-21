/** 382. 链表随机节点 https://leetcode.cn/problems/linked-list-random-node/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
import java.util.Random;

public class Leetcode382 {

}

/**
 * 水塘抽样算法
 */
class Solution1 {
    ListNode head;
    Random random;

    // 构造参数
    public Solution1(ListNode head) {
        this.head = head;
        random = new Random();
    }

    /**
     * 水塘抽样算法：只遍历一次，按等概率返回各元素
     * 一般的随机抽样方法需要事先知道数据规模，再用随机数从n个元素中随机抽样k个。
     * 但当数据规模特别大且难以用现有的存储空间保存它时，我们无法事先知道数据规模，这时水塘抽样算法就很适合解决这种问题。
     * 思路：一直往里走，只有等于0，才赋值给结果，直到走到最后
     * 不断往里走，不断渐进
     * @return
     */
    public int getRandom() {
        int i=0;
        int res=0;
        ListNode p=head;
        // 此节点不为空
        while (p!=null){
            // 元素数量自增
            i++;
            // 随机数为0，就赋值给res
            if(0== random.nextInt(i)){
                res= p.val;
            }
            // 一直往里走
            p=p.next;
        }
        // 走到末尾才返回
        return res;
    }
}