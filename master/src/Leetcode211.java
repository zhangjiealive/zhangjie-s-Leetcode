/** 211. 添加与搜索单词 - 数据结构设计 https://leetcode.cn/problems/implement-trie-prefix-tree/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode211 {
    class WordDictionary {
        TrieSet trieSet=new TrieSet();
        public WordDictionary() {

        }

        public void addWord(String word) {
            trieSet.add(word);
        }

        public boolean search(String word) {
            return trieSet.hasKeyWithPattern(word);
        }
    }
}
