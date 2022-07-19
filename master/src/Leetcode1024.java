import java.util.Arrays;
import java.util.Comparator;

/** 1024. 视频拼接 https://leetcode.cn/problems/video-stitching/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode1024 {
    public int videoStitching(int[][] clips, int time) {
        // 需要剪辑出来的时间为0，代表不需要剪辑直接返回0
        if(time==0){
            return 0;
        }
        // 排序，按开始时间升序，当开始时间相同，按结束时间降序
        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o2[1]-o1[1];
                }
                else {
                    return o1[0]-o2[0];
                }
            }
        });
        int n=clips.length;
        // 当片段时间不存在0时，拼不出来
        if(clips[0][0]!=0){
            return -1;
        }
        // 需要的片段和
        int count=0;
        // 现在片段的片尾值
        int end=0;
        // 下一个片段的片尾值
        int nextEnd=0;
        int i=0;
        // 从0开始遍历到n-1，并且片头不超过上一个片段片尾（当片头大于上一个片段片尾则代表连接不上了，中间有空档，则代表找不到下一个能连接上的片段，则跳出循环）下同
        while (i<n&&clips[i][0]<=end){
            // 从中找出下一个片段（片头不超过上一个片段片尾的但是片尾最大的值）
            while (i<n&&clips[i][0]<=end){
                nextEnd=Math.max(nextEnd,clips[i][1]);
                i++;
            }
            // 片段和加1
            count++;
            // 将下一个片段的片尾值变成现在片段的片尾值
            end=nextEnd;
            // 如果片尾已经达到规定时间，已经可以剪辑出来了，返回片段和
            if(end>=time){
                return count;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Leetcode1024 leetcode1024 = new Leetcode1024();
        int[][] a={{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
        leetcode1024.videoStitching(a,10);
    }
}
