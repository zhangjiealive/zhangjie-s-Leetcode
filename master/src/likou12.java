

public class likou12 {
    public String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();
        while(num!=0){
            if(num>0){
                if(num>900){
                    sb.append('M');
                    num=num-1000;
                }
                if(num>400){
                    sb.append('D');
                    num=num-500;
                }
                if(num>90){
                    sb.append('C');
                    num=num-100;
                }
                if(num>40){
                    sb.append('L');
                    num=num-50;
                }
                if(num>9){
                    sb.append('X');
                    num=num-10;
                }
                if(num>4){
                    sb.append('V');
                    num=num-5;
                }
                if(num>1){
                    sb.append('I');
                    num=num-1;
                }
            }
            else if(num<0){

            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int a=990;
        likou12 likou12 = new likou12();
        System.out.println(likou12.intToRoman(a));
    }
}
