//1200. 最小绝对差

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/** 力扣1200题 https://leetcode.cn/problems/minimum-absolute-difference/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res=new LinkedList<>();
        Arrays.sort(arr);
        int min=arr[1]-arr[0];
        for (int i = 0,j=1; j < arr.length; i++,j++) {
            if(arr[j]-arr[i]<min){
                res.clear();
                min=arr[j]-arr[i];
            }
            if(arr[j]-arr[i]==min){
                List<Integer> track=new LinkedList<>();
                track.add(arr[i]);
                track.add(arr[j]);
                res.add(track);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Leetcode1200 leetcode1200 = new Leetcode1200();
        int[] a=new int[]{40,11,26,27,-20};
        System.out.println(leetcode1200.minimumAbsDifference(a));
    }
}
