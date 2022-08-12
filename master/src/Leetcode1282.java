import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 1282. 用户分组 https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode1282 {
    /**
     * 思路：遍历一次数组，利用map存储对应数字的下标
     * @param groupSizes
     * @return
     */
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        // 遍历一次数组
        for (int i = 0; i < groupSizes.length; i++) {
            // 从map中获取此数的list，不存在的话新建一个list
            List<Integer> orDefault = map.getOrDefault(groupSizes[i], new ArrayList<>());
            // 将此下标加入list
            orDefault.add(i);
            // 将此下标位置的数和此下标位置数的list放入map
            map.put(groupSizes[i], orDefault);
        }
        // res集合
        List<List<Integer>> res = new ArrayList<>();
        // 遍历一次map
        for (int k : map.keySet()) {
            // 依次从map中取出list
            List<Integer> integers = map.get(k);
            // 如果取出的list大小和k相同，直接加入res即可
            if(integers.size()==k){
                res.add(integers);
            }
            // 否则list的大小应该是k的倍数，需要进行拆分
            else {
                // 新建一个list(此list为放入res的)
                List<Integer> track = new ArrayList<>();
                // 遍历integer
                for (int i = 0; i < integers.size(); i++) {
                    // 加入track
                    track.add(integers.get(i));
                    // 如果track的大小等于k，就是装满了一个list，将此list加入res，并且新建一个，开始下一轮装填
                    if (track.size() == k) {
                        res.add(track);
                        track = new ArrayList<>();
                    }
                }
            }
        }
        return res;
    }
}
