//: Leetcode77.java

import java.util.LinkedList;
import java.util.List;

/** 力扣77. 组合 https://leetcode.cn/problems/combinations/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode77 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        combineHelp(1,n, k);
        return res;
    }

    public void combineHelp(int start,int n, int k) {
        // 如果size等于k代表里面元素为k，加入结果集
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }
            // 通过start控制层数
            for (int i = start; i <= n; i++) {
                track.addLast(i);
                combineHelp(i+1,n, k);
                track.removeLast();
            }
    }
}
