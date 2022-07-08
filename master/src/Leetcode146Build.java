import java.util.HashMap;
// 造轮子法
/** 146. LRU (最近最少使用) 缓存 https://leetcode.cn/problems/lru-cache/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode146Build {
    class Node{
        // 节点key的值
        public int key;
        // 节点val的值
        public int val;
        // 后继指针
        public Node next;
        // 前驱指针
        public Node prev;
        // 构造函数默认前驱和后继为空
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    // 双向链表
    class DoubleList{
        // 虚拟头节点
        private Node head;
        // 虚拟尾节点
        private Node tail;
        // 链表大小
        private int size;
        // 构造函数
        public DoubleList() {
            // 虚拟头指针
            head=new Node(0,0);
            // 虚拟尾指针
            tail=new Node(0,0);
            // 虚拟头指针的后继指向尾
            head.next=tail;
            // 虚拟尾指针的前驱指向头
            tail.prev=head;
            // 大小默认为0
            size=0;
        }
        // 在链表尾插入
        public void addLast(Node x){
            x.prev=tail.prev;
            x.next=tail;
            tail.prev.next=x;
            tail.prev=x;
            size++;
        }
        // 移除某节点
        public void remove(Node x){
            x.prev.next=x.next;
            x.next.prev=x.prev;
            size--;
        }
        // 移除头元素，并返回此元素
        public Node removeFirst(){
            // 如果虚拟头指针的后继为虚拟尾指针，代表链表为空
            if(head.next==tail){
                return null;
            }
            Node first=head.next;
            remove(first);
            return first;
        }
        // 返回链表大小
        public int size(){
            return size;
        }
    }

    /**
     *  LRU (最近最少使用) 缓存
     *  基于双向队列
     *  队头是最近最少使用的，队尾是最近使用的
     *  缓存满会自动删除最近最少使用的
     */
    class LRUCache{
        // 使用hashmap在O(1)时间内判定是否存在此元素
        private HashMap<Integer,Node> map;
        // 双向链表实现头尾任意插入删除
        private DoubleList cache;
        // LRU最大容量
        private int cap;

        public LRUCache(int capacity){
            this.cap=capacity;
            map=new HashMap<>();
            cache=new DoubleList();
        }
        // 将一个已经在缓存中的元素，放到队尾(意为刚刚最近刚刚使用)
        private void makeRecently(int key){
            // 先从map中根据key取出这个节点
            Node x=map.get(key);
            // 先删除这个节点
            cache.remove(x);
            // 而后重新插入到队尾
            cache.addLast(x);
        }
        // 插入一个新使用的缓存
        private void addRecently(int key,int val){
            // 新建节点
            Node x=new Node(key,val);
            // 放入队尾
            cache.addLast(x);
            // 并将key和节点放入map
            map.put(key,x);
        }
        // 删除节点
        private void deleteKey(int key){
            // 先根据key在map中取出节点
            Node x=map.get(key);
            // 移除此节点
            cache.remove(x);
            // 并在map中也移除
            map.remove(key);
        }
        // 删除使用最久没使用的
        private void removeLeastRecently(){
            // 根据含义，最久没使用的在队头，删除队头元素并返回此节点
            Node deletedNode=cache.removeFirst();
            int deletedKey=deletedNode.key;
            // 在根据key在map中也删除
            map.remove(deletedKey);
        }
        // 根据key获取value
        public int get(int key){
            // 如果map不存在此key，返回-1
            if(!map.containsKey(key)){
                return -1;
            }
            // 如果存在则将此设置为最近使用过
            makeRecently(key);
            // 返回对应的val
            return map.get(key).val;
        }
        // 将值放入缓存
        public void put(int key,int val){
            // 如果本来就存在
            if(map.containsKey(key)){
                // 则先删除本来的
                deleteKey(key);
                // 将新的重新放入缓存，也会起到更新的作用
                addRecently(key,val);
                return;
            }
            // 如果内存满了，则删除最近没使用的，也就是队头的
            if(cap==cache.size()){
                removeLeastRecently();
            }
            // 如果不存在以上情况，则正常插入
            addRecently(key,val);
        }
    }
}
