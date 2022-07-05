//652. 寻找重复的子树

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/** 力扣652题 https://leetcode.cn/problems/find-duplicate-subtrees/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode652 {
    List<TreeNode> res=new LinkedList<>();
    HashMap<String,Integer> map=new HashMap<>();

    /**
     * 通过后序遍历，将二叉树序列化（因为后序遍历二叉树可以得到所有子树的结果）
     * 而后将所有子树都加入map，查询是否存在重复的子树
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        findDuplicateSubtreesHelp(root);
        int[] a={1,4,3,4};
        Arrays.sort(a);
        return res;
    }

    public String findDuplicateSubtreesHelp(TreeNode root) {
        if(root==null){
            return "#";
        }
        // 通过分解问题的递归
        String left=findDuplicateSubtreesHelp(root.left);
        String right=findDuplicateSubtreesHelp(root.right);

        String subTree=left+","+right+","+root.val;
        // get subTree的值，如果不存在默认为0
        int freq=map.getOrDefault(subTree,0);
        // 如果为1，则代表有重复的，将此子树加入结果集
        if(freq==1){
            res.add(root);
        }
        // 将subTree 和对应出现的次数放入map，注意，如果>1则不会重复加入结果集
        map.put(subTree,freq+1);
        // 并且把每次的子树序列化结果返回给上层
        return subTree;
    }
}
