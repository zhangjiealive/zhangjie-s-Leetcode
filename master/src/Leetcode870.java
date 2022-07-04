//870. 优势洗牌(田忌赛马)

import java.util.Arrays;
import java.util.PriorityQueue;

/** 力扣870题 https://leetcode.cn/problems/advantage-shuffle/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode870 {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n=nums1.length;
        // 自定义排序堆
        PriorityQueue<int []> n2 = new PriorityQueue<>( (int[] a,int b[])->{
            return b[1]-a[1];
        });
        for(int i=0;i<n;i++){
            n2.offer(new int[]{i,nums2[i]});
        }
        Arrays.sort(nums1);

        int left=0;
        int right=n-1;
        int[] res=new int[n];
        while (right>=left){
            int[] replace= n2.poll();
            if(nums1[right]>replace[1]){
                res[replace[0]]=nums1[right];
                right--;
            }
            else if(nums1[right]<=replace[1]){
                res[replace[0]]=nums1[left];
                left++;
            }
        }
        return res;
    }
}
