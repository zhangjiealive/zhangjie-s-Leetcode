
public class likou08 {

    public int myAtoi(String str) {
        int len = str.length();
        char[] charArray = str.toCharArray();

        int index = 0;
        while (index < len && charArray[index] == ' ') {
            index++;
        }

        if (index == len) {
            return 0;
        }

        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        // 4、将后续出现的数字字符进行转换
        // 不能使用 long 类型，这是题目说的
        int res = 0;
        while (index < len) {
            char currChar = charArray[index];
            // 4.1 先判断不合法的情况
            if (currChar > '9' || currChar < '0') {
                break;
            }

            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            // 4.2 合法的情况下，才考虑转换，每一步都把符号位乘进去
            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        likou08 solution = new likou08();
        String str = "2147483646543534634";
        int res = solution.myAtoi(str);
        System.out.println(res);
    }
}

/*
*         while(i<n && str.charAt(i)>='0' && str.charAt(i)<='9') {
            //'0'的ASCII码是48，'1'的是49，这么一减就从就可以得到真正的整数值
            int tmp = str.charAt(i)-48;
            //判断是否大于 最大32位整数，
            if(!is_negative &&(res>214748364 ||(res==214748364 && tmp>=7))) {
                return 2147483647;
            }
            //判断是否小于 最小32位整数
            if(is_negative &&(-res<-214748364 || (-res==-214748364 && tmp>=8))) {
                return -2147483648;
            }
            res = res*10 + tmp;
            ++i;
        }
* */