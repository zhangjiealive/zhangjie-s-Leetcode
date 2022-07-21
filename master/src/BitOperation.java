/*
    位运算技巧
 */
public class BitOperation {
    public static void main(String[] args) {
        // 利用或操作|和空格将英文字符转换为小写
        System.out.println('A'|' ');
        System.out.println('a'|' ');

        // 利用与操作&和下划线_将英文字符转换为大写
        System.out.println('A'&'_');
        System.out.println('a'&'_');

        // 利用异或操作^和空格将英文字符大小写互换
        System.out.println('A'^' ');
        System.out.println('a'^' ');

        // 判断两个数是否异号
        int a=-1;
        int b=2;
        boolean f=((a^b)<0);
        System.out.println(f);
        int c=3;
        int d=2;
        boolean g=((c^d)<0);
        System.out.println(g);

        // n&n-1:可以消除数字n二进制表示中的最后一个1
        // 例如i=9，i&i-1=8  i=24 i&i-1=16
        int i=9;
        System.out.println(i & (i - 1));
        int j=24;
        System.out.println(j&(j-1));

        // 一个数与本身异或^结果为0，一个数与0做异或，结果为本身，异或满足交换律和结合律
        System.out.println(1^2^4^1^2^4);
    }
}
