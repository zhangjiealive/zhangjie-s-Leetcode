/** 319. 灯泡开关 https://leetcode.cn/problems/bulb-switcher/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode319 {
    /**
     * 数学规律
     * 当第一轮，会开启所有的灯，第二轮关闭每两个中的第二个，第三轮切换每3个中的第3个，第i轮切换每i个中的第i个，直到n轮，直接关闭第n个
     * 那么当n=10时，第10个按钮会在1，2，5，10被按4次，被按的为奇数次的就是开着的灯
     * 1*1第1个只在第一轮按一次，2*2第4个在第1轮，第4轮，第2轮，3次是奇数，3*3第9个在第1轮，第9轮，第3轮，3次是奇数
     * 所以取平方根,找那些数有相同正约数的，有相同正约数的被按的次数就是奇数，就是亮着的
     * @param n
     * @return
     */
    public int bulbSwitch(int n) {
        // 对求的平方根取整,例如12的平方根为3.464101615138，但是也只有3个有相同正约数的，1，4，9，直接取3，溢出的无效
        return (int)Math.sqrt(n);
    }
}
