import java.util.LinkedList;
import java.util.List;

/**
 * 前缀树，根据字符进行索引，每一个节点上都有256个子孩子(不过很多是为空的)
 * @param <V>
 */
public class TrieMap<V> {
    // 孩子个数
    // 优化方法，根据题目需要缩小R，如果只包含小写字母，则只需要26位即可
    // 优化需要修改所有用到数组下标的位置，因为本来a存在数组第97位，现在存在0位了
    private static final int R=256;
    // 默认大小
    private int size=0;

    /**
     * 构造函数
     * @param <V>
     */
    private static class TrieNode<V>{
        // val默认为空
        V val=null;
        // 子孩子为数组大小为256
        TrieNode<V>[] children=new TrieNode[R];
    }
    // 全局参数，根节点，默认为空
    private TrieNode<V> root=null;


    /**
     * 往map中放置元素(迭代方法)
     * @param key
     * @param val
     */
    public void put(String key,V val){
        // 如果整个map目前为空，则在root上新建一个TrieNode
        if(root==null){
            root=new TrieNode<>();
        }
        TrieNode<V> node = root;
        if(!containsKey(key)){
            size++;
        }
        for (char c:key.toCharArray()) {
            // 如果此节点的对应孩子的node不存在，则新建一个node
            if(node.children[c]==null){
                node.children[c]=new TrieNode<V>();
            }
            // 每次都往下走
            node=node.children[c];
        }
        // 循环结束后，给val赋值
        node.val=val;
        return;
    }

    /**
     * 递归方法
     * @param key
     * @param val
     */
    public void put1(String key,V val){
        if(!containsKey(key)){
            size++;
        }
        root=put(root,key,val,0);
    }
    /**
     * 递归帮助方法
     * @param node
     * @param key
     * @param val
     * @param i
     * @return
     */
    // 参数列表加一个i,达到循环的效果
    private TrieNode<V> put(TrieNode<V> node,String key,V val,int i){
        if(node==null){
            node=new TrieNode<>();
        }
        // 如果i的大小，与key的长度相同了，代表已经到达相应长度位置
        if(i==key.length()){
            // 进行赋值
            node.val=val;
            return node;
        }
        char c=key.charAt(i);
        node.children[c]=put(node.children[c],key,val,i+1);
        return node;
    }

    /**
     * 移除map中某个key
     * 注意，因为可能这一条路径上没有其他元素，所以在删除时，需要把不需要存在的树枝给删除
     * @param key
     */
    public void remove(String key){
        if(!containsKey(key)){
            return;
        }
        root=remove(root,key,0);
        size--;
    }

    private TrieNode<V> remove(TrieNode<V> node,String key,int i){
        if(node==null){
            return null;
        }
        // 如果i的长度与字符串长度相同，则已经到达相应位置
        if(i==key.length()){
            // 删除
            node.val=null;
        }
        else {
            // 根据i的增长不断往后匹配字符
            char c=key.charAt(i);
            // 根据逐层删除node.children[c]最终删除最终需要删除的
            node.children[c]=remove(node.children[c],key,i+1);
        }
        // 后序位置，递归路径上的节点可能需要被清理，如果val有值则不能清理
        if(node.val!=null){
            return node;
        }
        // 检测目前这一子树上的其他节点是否为空，如果为空则可以清理这整个子树
        for (int c = 0; c < R; c++) {
            if(node.children[c]!=null){
                return node;
            }
        }
        return null;
    }
    public void remove1(String key){
        if(key==null||key==""){
            return;
        }
        if(!containsKey(key)){
            return;
        }
        size--;
        int i=key.length();
        TrieNode<V> node = getNode(root, key.substring(0, i));
        node.val=null;
        while (i>0){
            node = getNode(root, key.substring(0, i));
            for (char c=0;c<R;c++) {
                if(node.children[c]!=null){
                    return;
                }
            }
            node=null;
            i--;
        }
        return;
    }

    /**
     * 获取某个key的val
     * @param key
     * @return
     */
    public V get(String key){
        // 根据getNode工具方法，得到该节点
        TrieNode<V> x=getNode(root,key);
        if(x==null||x.val==null){
            return null;
        }
        return x.val;
    }
    // 根据get方法，获取此key的val如果为空
    public boolean containsKey(String key){
        return get(key)!=null;
    }
    // 最短前缀匹配，在所有键中寻找query的最短前缀
    public String shortestPrefixOf(String query){
        TrieNode<V> p=root;
        for (int i = 0; i < query.length(); i++) {
            if(p==null){
                return "";
            }
            // 找到一个键是query的前缀
            if(p.val!=null){
                return query.substring(0,i);
            }
            char c=query.charAt(i);
            p=p.children[c];
        }
        // 循环结束，如果p不为空，则query本身就是一个键
        if(p!=null&&p.val!=null){
            return query;
        }
        return "";
    }
    // 在所有键中寻找query的最长前缀
    public String longestPrefixOf(String query){
        TrieNode<V> p=root;
        // 不断向下找更新最大值
        int max_len=0;
        for (int i = 0; i < query.length(); i++) {
            if(p==null){
                break;
            }
            if(p.val!=null){
                max_len=i;
            }
            char c=query.charAt(i);
            p=p.children[c];
        }
        // 如果循环结束，p最后不为空，最长前缀最长的应该是自己
        if(p!=null&&p.val!=null){
            return query;
        }
        // 根据最大值，切割字符串
        return query.substring(0,max_len);
    }
    // 搜索前缀为prefix的所有键
    public List<String> keysWithPrefix(String prefix){
        // 存储结果
        List<String> res=new LinkedList<>();
        // 先得到此prefix节点，从这下面开始找（前缀本身是最小的前缀）
        TrieNode<V> x=getNode(root,prefix);
        if(x==null){
            return res;
        }
        // DFS遍历这个节点
        traverse(x,new StringBuilder(prefix),res);
        return res;
    }
    // DFS
    private void traverse(TrieNode<V> node,StringBuilder path,List<String> res){
        if(node==null){
            return;
        }
        // 只要不为空，全部加入结果集
        if(node.val!=null){
            res.add(path.toString());
        }
        // 回溯算法
        for (char c = 0; c < R ; c++) {
            // 先增加c
            path.append(c);
            // 带着c去遍历
            traverse(node.children[c],path,res);
            // 遍历结束删除c，继续下一次循环
            path.deleteCharAt(path.length()-1);
        }
    }
    // 通配符.匹配任意字符
    public List<String> keysWithPattern(String pattern){
        List<String> res=new LinkedList<>();
        traverse(root,new StringBuilder(),pattern,0,res);
        return res;
    }

    private void traverse(TrieNode<V> node,StringBuilder path,String pattern,int i,List<String> res){
        if(node==null){
            return;
        }
        // 只加入长度相符的
        if(i==pattern.length()){
            if(node.val!=null){
                res.add(path.toString());
            }
            return;
        }
        char c=pattern.charAt(i);
        // 把.当成任意字符去遍历
        if(c=='.'){
            for (char j = 0; j < R; j++) {
                path.append(j);
                traverse(node.children[j],path,pattern,i+1,res );
                path.deleteCharAt(path.length()-1);
            }
        }
        // 不是.则当成他本身
        else {
            path.append(c);
            traverse(node.children[c],path,pattern,i+1,res );
            path.deleteCharAt(path.length()-1);
        }
    }
    // 判断是否存在前缀为prefix的键，直接getNode此prefix，看看是否为空
    public boolean hasKeyWithPrefix(String prefix){
        return getNode(root,prefix)!=null;
    }
    // 判断是否存在前缀为pattern的键，含通配符
    public boolean hasKeyWithPattern(String pattern){
        return hasKeyWithPattern(root,pattern,0);
    }

    private boolean hasKeyWithPattern(TrieNode<V> node,String pattern,int i){
        if(node==null){
            return false;
        }
        if(i==pattern.length()){
            return node.val!=null;
        }
        char c=pattern.charAt(i);
        // 不为通配符直接当成本身去遍历
        if(c!='.'){
            return hasKeyWithPattern(node.children[c],pattern,i+1 );
        }
        // 为通配符，当成任意去遍历
        for (int j = 0; j < R; j++) {
            if(hasKeyWithPattern(node.children[j],pattern,i+1)){
                return true;
            }
        }
        return false;
    }
    // 返回大小
    public int size(){
        return size;
    }
    // 从节点node开始搜索key，如果存在返回对应节点，否则返回null
    private TrieNode<V> getNode(TrieNode<V> node,String key){
        TrieNode<V> p=node;
        // 从节点node开始搜索key
        for (int i = 0; i < key.length(); i++) {
            // 如果头节点为空
            if(p==null){
                // 返回空
                return null;
            }
            // 按照字符串的字符顺序开始查找子节点，循环次数为字符串的长度
            char c=key.charAt(i);
            // 根据ascii码下标，找此字母位的子孩子，并在下次循环中判定是否为空
            p=p.children[c];
        }
        return p;
    }

    public static void main(String[] args) {
        TrieMap<Integer> Map = new TrieMap<>();
        Map.put("abc",1);
    }
}
