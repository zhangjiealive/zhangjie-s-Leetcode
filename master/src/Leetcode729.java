//729. 我的日程安排表 I

import java.util.ArrayList;

/** 力扣729题 https://leetcode.cn/problems/my-calendar-i/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode729 {

}
class MyCalendar {
    DifferenceArray array;
    public MyCalendar() {
        array = new DifferenceArray(new int[1000000000+1]);
    }

    public boolean book(int start, int end) {
        int[] result=array.result();
        for (int i = start; i < end; i++) {
            if(result[i]!=0){
                return false;
            }
        }
        array.increment(start,end,1);
        return true;
    }
}