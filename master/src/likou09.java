
public class likou09 {
    public boolean isPalindrome(int x) {
    if(x<0) return false;
    int y=x;
    int z;
    int a=0;
    StringBuilder stringBuilder=new StringBuilder();
    while (y>=1){
        z=y%10;
        a=a*10+z;
        y=y/10;
    }
    if(a==x)return true;
    else return false;
    }

    public static void main(String[] args) {
        likou09 likou09 = new likou09();
        likou09.isPalindrome(1221);
    }
}
