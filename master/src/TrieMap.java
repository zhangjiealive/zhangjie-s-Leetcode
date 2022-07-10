import java.util.LinkedList;
import java.util.List;

/**
 * 前缀树，根据字符进行索引，每一个节点上都有26个字母的子孩子(不过很多是为空的)
 * @param <V>
 */
public class TrieMap<V> {
    private static final int R=256;

    private int size=0;

    private static class TrieNode<V>{
        V val=null;
        TrieNode<V>[] children=new TrieNode[R];
    }

    private TrieNode<V> root=null;



    public void put(String key,V val){
        if(root==null){
            root=new TrieNode<>();
        }
        TrieNode<V> node = root;
        if(!containsKey(key)){
            size++;
        }
        for (char c:key.toCharArray()) {
            if(node.children[c]==null){
                node.children[c]=new TrieNode<V>();
            }
            node=node.children[c];
        }
        node.val=val;
        return;
    }

    public void put1(String key,V val){
        if(!containsKey(key)){
            size++;
        }
        root=put(root,key,val,0);
    }
    /**
     * 递归方法
     * @param node
     * @param key
     * @param val
     * @param i
     * @return
     */
    private TrieNode<V> put(TrieNode<V> node,String key,V val,int i){
        if(node==null){
            node=new TrieNode<>();
        }
        if(i==key.length()){
            node.val=val;
            return node;
        }
        char c=key.charAt(i);
        node.children[c]=put(node.children[c],key,val,i+1);
        return node;
    }

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
        if(i==key.length()){
            node.val=null;
        }
        else {
            char c=key.charAt(i);
            node.children[c]=remove(node.children[c],key,i+1);
        }
        if(node.val!=null){
            return node;
        }
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

    public V get(String key){
        TrieNode<V> x=getNode(root,key);
        if(x==null||x.val==null){
            return null;
        }
        return x.val;
    }

    public boolean containsKey(String key){
        return get(key)!=null;
    }

    public String shortestPrefixOf(String query){
        TrieNode<V> p=root;
        for (int i = 0; i < query.length(); i++) {
            if(p==null){
                return "";
            }
            if(p.val!=null){
                return query.substring(0,i);
            }
            char c=query.charAt(i);
            p=p.children[c];
        }
        if(p!=null&&p.val!=null){
            return query;
        }
        return "";
    }

    public String longestPrefixOf(String query){
        TrieNode<V> p=root;
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
        if(p!=null&&p.val!=null){
            return query;
        }
        return query.substring(0,max_len);
    }

    public List<String> keysWithPrefix(String prefix){
        List<String> res=new LinkedList<>();
        TrieNode<V> x=getNode(root,prefix);
        if(x==null){
            return res;
        }
        traverse(x,new StringBuilder(prefix),res);
        return res;
    }

    private void traverse(TrieNode<V> node,StringBuilder path,List<String> res){
        if(node==null){
            return;
        }
        if(node.val!=null){
            res.add(path.toString());
        }
        for (char c = 0; c < R ; c++) {
            path.append(c);
            traverse(node.children[c],path,res);
            path.deleteCharAt(path.length()-1);
        }
    }

    private void traverse(TrieNode<V> node,StringBuilder path,String pattern,int i,List<String> res){
        if(node==null){
            return;
        }
        if(i==pattern.length()){
            if(node.val!=null){
                res.add(path.toString());
            }
            return;
        }
        char c=pattern.charAt(i);
        if(c=='.'){
            for (char j = 0; j < R; j++) {
                path.append(j);
                traverse(node.children[j],path,pattern,i+1,res );
                path.deleteCharAt(path.length()-1);
            }
        }
        else {
            path.append(c);
            traverse(node.children[c],path,pattern,i+1,res );
            path.deleteCharAt(path.length()-1);
        }
    }

    public boolean hasKeyWithPrefix(String prefix){
        return getNode(root,prefix)!=null;
    }

    public List<String> keysWithPattern(String pattern){
        List<String> res=new LinkedList<>();
        traverse(root,new StringBuilder(),pattern,0,res);
        return res;
    }

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
        if(c!='.'){
            return hasKeyWithPattern(node.children[c],pattern,i+1 );
        }
        for (int j = 0; j < R; j++) {
            if(hasKeyWithPattern(node.children[j],pattern,i+1)){
                return true;
            }
        }
        return false;
    }

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
