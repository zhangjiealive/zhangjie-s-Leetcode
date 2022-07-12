import java.util.List;

/** 648. 单词替换 https://leetcode.cn/problems/replace-words/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode648 {
    /**
     * 思路，每个单词找字典中是否有对应的前缀，如果有则替换，通过TrieMap前缀树来匹配前缀
     * @param dictionary
     * @param sentence
     * @return
     */
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieSet trieSet = new TrieSet();
        // 将字典中所有元素放入set
        for (String s: dictionary) {
            trieSet.add(s);
        }
        StringBuilder sb = new StringBuilder();
        // 根据单词划分单词
        String[] s = sentence.split(" ");
        // 找对应单词的最短前缀
        for (int i = 0; i < s.length; i++) {
            String s1 = trieSet.shortestPrefixOf(s[i]);
            // 如果前缀存在，则放入前缀
            if(!s1.isEmpty()){
                sb.append(s1);
            }
            // 如果前缀不存在，则放入原本的单词
            else {
                sb.append(s[i]);
            }
            // 只要不是最后一个单词，都在后面插入空格
            if(i!=s.length-1){
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
