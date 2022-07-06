/** 990. 等式方程的可满足性 https://leetcode.cn/problems/satisfiability-of-equality-equations/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode990 {
    /**
     * 根据并查集，构造联通26个字母的并查集
     * @param equations
     * @return
     */
    public boolean equationsPossible(String[] equations) {
        // 构造26个字母的并查集
        UF uf = new UF(26);
        for (String s : equations) {
            // 将等于号的连接在一起
            if(s.charAt(1)=='='){
                char x=s.charAt(0);
                char y=s.charAt(3);
                uf.union(x-'a',y-'a');
            }
        }
        for (String s : equations) {
            // 将不等于的检测，如果不等于的原本已经被连接了，则破坏了了满足性
            if(s.charAt(1)=='!'){
                char x=s.charAt(0);
                char y=s.charAt(3);
                if(uf.connected(x-'a',y-'a')){
                    return false;
                }
            }
        }
        return true;
    }
}
