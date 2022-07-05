//380. O(1) 时间插入、删除和获取随机元素
// 通过数组为底层的顺序表才能达到随机取元素，在配合一个map，存储值的位置，达到O(1)插入和删除的目的。
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/** 力扣380题 https://leetcode.cn/problems/insert-delete-getrandom-o1/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode380{
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(2);
        randomizedSet.insert(7);
        randomizedSet.getRandom();
    }
}

class RandomizedSet {

    private ArrayList<Integer> arrayList;
    private HashMap<Integer,Integer> map;

    public RandomizedSet() {
        arrayList=new ArrayList<>();
        map=new HashMap<>();
    }
    // 插入，如果map中包含返回false，否则在map中存下索引，list加上值
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val,arrayList.size());
        arrayList.add(val);
        return true;
    }
    // 删除注意如果不包含，直接返回false
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int temp=arrayList.get(arrayList.size()-1);
        arrayList.set(map.get(val),temp);
        arrayList.remove(arrayList.size()-1);
        map.put(temp,map.get(val));
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return arrayList.get((new Random().nextInt(arrayList.size())));
    }
}