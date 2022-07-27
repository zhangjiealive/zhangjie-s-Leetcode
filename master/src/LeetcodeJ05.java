/** 剑指 Offer 05. 替换空格 https://leetcode.cn/problems/ti-huan-kong-ge-lcof/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class LeetcodeJ05 {
    /**
     * 遍历一次字符串，使用StringBuilder替换
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        // 遍历一次字符串
        for (int i = 0; i < n; i++) {
            // 如果是空格，进行替换
            if(s.charAt(i)==' '){
                sb.append("%20");
            }
            // 如果不是正常插入
            else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
