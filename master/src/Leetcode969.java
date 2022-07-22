import java.util.LinkedList;
import java.util.List;

/** 969. 煎饼排序 https://leetcode.cn/problems/pancake-sorting/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode969 {
    List<Integer> res;

    /**
     * 煎饼排序：递归思想
     * 类似像用铲子，铲煎饼，大的放在下面
     * 思路:找到最大的，从最大的下面铲一下把最大的翻转到最上面，再从最底下铲翻转，使最大的到最底下，此时已经将最大的放到最下面，现在只需要对n-1个元素在进行煎饼排序
     * @param arr
     * @return
     */
    public List<Integer> pancakeSort(int[] arr) {
        res=new LinkedList<>();
        sort(arr,arr.length);
        return res;
    }
    // 对0-n位置进行煎饼排序
    public void sort(int[] arr,int n){
        // base case 当只剩一个元素，不需要排序，直接返回
        if(n==1){
            return;
        }
        // 最大的蛋糕
        int maxCake=0;
        // 最大的蛋糕在数组中的索引
        int maxCakeIndex=0;
        // 遍历到n位置，找到0-n中最大的蛋糕
        for (int i = 0; i < n; i++) {
            if(arr[i]>maxCake){
                maxCakeIndex=i;
                maxCake=arr[i];
            }
        }
        // 将0到最大煎饼位置进行翻转
        reverse(arr,0,maxCakeIndex);
        // res加入翻转的位置，数组下标+1
        res.add(maxCakeIndex+1);
        // 此时最大的蛋糕在最上面，将0-n-1位置进行翻转，将目前最大的蛋糕放到n-1位置
        reverse(arr,0,n-1);
        // res加入翻转的位置，数组下标+1
        res.add(n);
        // 在递归调用对n-1进行煎饼排序
        sort(arr,n-1);
    }

    // 翻转数组
    public void reverse(int[] arr,int i,int j){
        // 双指针互换位置
        while (i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Leetcode969 leetcode969 = new Leetcode969();
        leetcode969.pancakeSort(new int[]{3,2,4,1});
    }
}
