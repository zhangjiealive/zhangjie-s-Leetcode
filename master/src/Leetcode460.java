import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/** 460. LFU (最不经常使用)缓存 https://leetcode.cn/problems/lfu-cache/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode460 {
    /**
     * LFU最不经常使用缓存
     * 要对每个key的使用次数进行计数，并且通过链表来确实key的新旧
     * 当内存满了自动移除次数最多，并且最老的key
     */
    class LFUCache {
        // key to val集合(键值对)一对一
        HashMap<Integer,Integer> keyToVal;
        // key to freq结合(键：使用次数)一对一
        HashMap<Integer,Integer> keyToFreq;
        // freq to key list(使用次数：键的集合）一对多：使用链式hashset可以快速取并且可以直接取出队头元素(最老的)
        HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
        // 缓存中使用的最小次数
        int minFreq;
        // 容量
        int cap;
        public LFUCache(int capacity) {
            keyToVal=new HashMap<>();
            keyToFreq=new HashMap<>();
            freqToKeys=new HashMap<>();
            this.cap=capacity;
            this.minFreq=0;
        }

        public int get(int key) {
            // 如果kv中不包含直接返回-1
            if(!keyToVal.containsKey(key)){
                return -1;
            }
            // 将此key的使用次数+1
            increaseFreq(key);
            // 返回value
            return keyToVal.get(key);
        }

        public void put(int key, int value) {
            // 如果内存空间小于或等于0，无法插入
            if(this.cap<=0){
                return;
            }
            // 当包含此key时，更新值，并且更新使用次数
            if(keyToVal.containsKey(key)){
                keyToVal.put(key,value);
                increaseFreq(key);
                return;
            }
            // 当缓存已经满了时，移除使用次数最小，最老的元素
            if(this.cap<=keyToVal.size()){
                removeMinFreqKey();
            }
            // 上面几种处理完，直接插入kv
            keyToVal.put(key,value);
            // 插入kf，因为之前没有所以使用次数为1
            keyToFreq.put(key,1);
            // ?
            freqToKeys.putIfAbsent(1,new LinkedHashSet<>());
            // 在fk中使用次数为1的set中插入
            freqToKeys.get(1).add(key);
            // 将使用次数最小的置为1（新插入了元素）
            this.minFreq=1;
        }

        /**
         * 移除使用次数最小的，时间最老的（当缓存满了时）
         */
        private void removeMinFreqKey(){
            // 根据目前最小的使用次数得到LinkedHashset
            LinkedHashSet<Integer> keyList=freqToKeys.get(this.minFreq);
            // 使用次数最小的并且最老的，链表头部
            int deletedKey=keyList.iterator().next();
            // 在此表中删除此元素
            keyList.remove(deletedKey);
            // 当此使用频次的集合为空
            if(keyList.isEmpty()){
                // 直接在整个集合中删除此频次的集合
                freqToKeys.remove(this.minFreq);
            }
            // 在kv集合中删除这个
            keyToVal.remove(deletedKey);
            // 在kf集合中删除这个
            keyToFreq.remove(deletedKey);
        }

        /**
         * 增加此key的使用次数
         * @param key
         */
        private void increaseFreq(int key){
            // 获取此key的使用次数
            int freq=keyToFreq.get(key);
            // 在kf集合中将freq(使用次数)+1
            keyToFreq.put(key,freq+1);
            // 在fk集合中的frep次数的集合中移除此key
            freqToKeys.get(freq).remove(key);
            freqToKeys.putIfAbsent(freq+1,new LinkedHashSet<>());
            // 在fk集合中的freq+1次数的集合中加入此key
            freqToKeys.get(freq+1).add(key);
            // 如果fk集合中此freq的集合为空的话，直接删除
            if(freqToKeys.get(freq).isEmpty()){
                freqToKeys.remove(freq);
                // 并且将最小次数更新(因为原本此key的freq本来是最小的，但是此freq中移除此后为空，所以minFreq随着此key的freq增大而增大)
                if(freq==this.minFreq){
                    this.minFreq++;
                }
            }
        }
    }
}
