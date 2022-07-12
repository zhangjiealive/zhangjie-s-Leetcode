import java.util.List;

/** 677. 键值映射 https://leetcode.cn/problems/implement-trie-prefix-tree/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode677 {
    class MapSum {
        TrieMap<Integer> trieMap=new TrieMap<>();
        public MapSum() {

        }

        public void insert(String key, int val) {
            trieMap.put(key,val);
        }

        public int sum(String prefix) {
            int sum=0;
            List<String> strings = trieMap.keysWithPrefix(prefix);
            for (String s: strings) {
                Integer integer = trieMap.get(s);
                sum=sum+integer;
            }
            return sum;
        }
    }
}
