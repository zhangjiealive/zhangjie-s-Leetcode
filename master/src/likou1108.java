
//: likou1108.java

/** 力扣1108题 https://leetcode.cn/problems/defanging-an-ip-address/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class likou1108 {
    public String defangIPaddr(String address) {
        StringBuilder s=new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if(address.charAt(i)!='.'){
                s.append(address.charAt(i));
            }
            else {
                s.append("[.]");
            }
        }
        return s.toString();
    }
}
