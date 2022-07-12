/**
 * 优先级队列，基于二叉堆
 * 二叉堆是特殊的二叉树(完全二叉树)，存储在数组中
 * 二叉堆的主要操作：sink(下沉)和swim(上浮)
 * @param <Key>
 */
// Key为java的泛型，是任何一种可比较大小的数据类型
public class MaxPQ <Key extends Comparable<Key>>{
    // 存储元素的数组
    private Key[] pq;

    private int size=0;
    // 构造函数
    public MaxPQ(int cap){
        // 索引0空着不用，所以容量+1
        pq=(Key[])new Comparable[cap+1];
    }
    // 返回最大值，因为是大顶堆，第一个元素为最大
    public Key max(){
        return pq[1];
    }
    // 插入元素
    public void insert(Key e){
        // 容量增大
        size++;
        // 放到最下面（最小的）
        pq[size]=e;
        // 让他上浮
        swim(size);
    }
    // 删除最大的
    public Key delMax(){
        Key max=pq[1];
        // 用最大的和最小的交换
        swap(1,size);
        // 删除最大的
        pq[size]=null;
        // 容量-1
        size--;
        // 让最小的自己下沉
        sink(1);
        // 返回删除后当前最大的
        return max;
    }
    // 上浮：将它不断与父节点对比，如果大于父节点则交换，并继续循环
    public void swim(int x){
        // 只要它不是根节点并且父节点小于它
        while (x>1&&less(parent(x),x)){
            // 将它和父节点进行交换(根据下标对数据上的元素互换)
            swap(parent(x),x);
            // 因为它已经交换到了父节点，所以下标进行更换，准备开始下一次循环
            x=parent(x);
        }
    }
    // 下沉：将它与左右孩子对比，如果小于左孩子或者右孩子，就与较大的那个孩子进行交换
    public void sink(int x){
        // 只要没有到底
        while (left(x)<=size){
            // 先假设left是left和right中较大的
            int max=left(x);
            // 只要right在数组范围内，并且left小于right
            if(right(x)<=size&&less(max,right(x))){
                // right是left和right中最大的
                max=right(x);
            }
            // 将left和right之间最大的与此节点对比,如果此节点较大，则不进行操作
            if(less(max,x)){
                break;
            }
            // 否则将left和right中较大的和此节点进行替换
            swap(x,max);
            // 并且用此次left和right中较大的继续开始下沉
            x=max;
        }
    }
    // 将两个下标上的数进行交换
    public void swap(int i,int j){
        Key temp=pq[i];
        pq[i]=pq[j];
        pq[j]=temp;
    }
    // 比较i是否小于j
    private boolean less(int i,int j){
        return pq[i].compareTo(pq[j])<0;
    }
    // 父节点的索引
    public int parent(int root){
        return root/2;
    }
    // 左孩子的索引
    public int left(int root){
        return root*2;
    }
    // 右孩子的索引
    public int right(int root){
        return root*2+1;
    }
}
