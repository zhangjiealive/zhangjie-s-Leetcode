// 滑动窗口模板
public class slidingWindow {
    /*
        public String minWindow(String s, String t) {
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        // 将需匹配的所有字符放进一个map
        for (int i = 0; i < t.length(); i++) {
            char c1 = t.charAt(i);
            need.put(c1, need.getOrDefault(c1,0)+1);
        }
        int left=0;
        int right=0;
        int vaild=0;
        int start=0;
        int len=Integer.MAX_VALUE;
        while (right<s.length()){
            char c=s.charAt(right);
            // 向后扩大窗口
            right++;
            // 进行窗口内数据的一系列更新
            ...

            /debug的位置，查看目前窗口
            printf("window:[%d,%d)\n",left,right);
            /
            // 判断左侧窗口是否要收缩
            while(条件){

                char d=s.charAt(left);

                left++;
                // 进行窗口内数据的更新
                ...
        }

    }
     */
}
