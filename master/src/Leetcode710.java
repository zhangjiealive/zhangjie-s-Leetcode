//710. 黑名单中的随机数

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/** 力扣710题 https://leetcode.cn/problems/random-pick-with-blacklist/
 * 关联380
 * 通过map存入黑名单的值，并且将黑名单的索引改为非黑名单的值，并且通过size-黑名单长度来减小范围
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode710 {
    private HashMap<Integer, Integer> mapping;
    private Random random;
    private int size;

    public Leetcode710(int n, int[] blacklist) {
        mapping = new HashMap();
        random = new Random();
        // n-黑名单长度，代表有多少个有效的值
        size = n - blacklist.length;
        // 先把所有黑名单元素加入map
        for (int black: blacklist) {
            mapping.put(black, 666);
        }
        // 根据题目提示，左开右闭，不包含右侧区间，所以减1
        int last = n - 1;
        for (int black: blacklist) {
            // 如果黑名单的值大于size-1，代表此区间都不会取到也就不需要修改黑名单的对应索引了
            if (black > size - 1) {
                continue;
            }
            // 去找不在黑名单中的值
            while(mapping.containsKey(last)) {
                last--;
            }
            // 将黑名单的索引改成不是黑名单的值
            mapping.put(black, last);
            last--;
        }

    }

    /**
     * 例如n为7，就是0，1，2，3，4，5，6不包括7，黑名单中有3个值，那么有效值就是4个，把前个区间全部换成有效值，
     * 如果这个值在黑名单中，那么就去map中找此黑名单对应的索引，如果不在，正常返回这个值即可
     * @return
     */
    public int pick() {
        int index = random.nextInt(size);
        return mapping.containsKey(index) ? mapping.get(index) : index;
    }
    public static void main(String[] args) {
        int[] black={2,3,5};
        Leetcode710 leetcode710 = new Leetcode710(7,black);
        leetcode710.pick();
    }
}

