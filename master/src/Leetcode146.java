import java.util.LinkedHashMap;
// 用轮子法
/** 146. LRU (最近最少使用) 缓存 https://leetcode.cn/problems/lru-cache/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode146 {

}

class LRUCache {
    int cap;
    LinkedHashMap<Integer,Integer> cache=new LinkedHashMap<>();
    public LRUCache(int capacity) {
        this.cap=capacity;
    }

    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.put(key,value);
            makeRecently(key);
            return;
        }
        if(cache.size()>=this.cap){
            int oldestKey=cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        cache.put(key,value);
    }

    public void makeRecently(int key){
        int val=cache.get(key);
        cache.remove(key);
        cache.put(key,val);
    }
}
