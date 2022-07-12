
/** 208. 实现 Trie (前缀树) https://leetcode.cn/problems/implement-trie-prefix-tree/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode208 {
    class Trie {

        TrieSet set=new TrieSet();

        public Trie() {

        }

        public void insert(String word) {
            set.add(word);
        }

        public boolean search(String word) {
            return set.contains(word);
        }

        public boolean startsWith(String prefix) {
            return set.hasKeyWithPrefix(prefix);
        }
    }
}
