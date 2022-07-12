import java.util.ArrayDeque;
import java.util.Deque;

public class MonotonousStack {
    /**
     * 单调栈
     * @param nums
     * @return
     */
    public int[] nextGreaterElement(int[] nums){
        int n=nums.length;
        int[] res=new int[n];
        // 栈使用ArrayDeque比较快
        Deque<Integer> stack = new ArrayDeque<Integer>();
        // 从后往前入栈，就是从前往后出栈
        for (int i = n-1; i >=0 ; i--) {
            // 保证栈不为空，并将小于指针指向元素的元素全部出栈
            while (!stack.isEmpty()&& stack.peek()<=nums[i]){
                stack.pop();
            }
            // 如果栈为空，代表这个元素比栈里所有元素都大，如果不为空，下一个比它大的就是栈顶的元素
            res[i]=stack.isEmpty()?-1:stack.peek();
            // 将此元素入栈
            stack.push(nums[i]);
        }
        return res;
    }
}
