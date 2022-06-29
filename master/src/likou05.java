package likou;

public class likou05 {
    public boolean ishuiwenchuan(String s, int i, int j) {
        for (int k = i; k <= i + (j - i) / 2; k++) {
            if (s.charAt(k) != s.charAt(j - k + i)) {
                return false;
            }
        }
        return true;
    }

    public String longestPalindrome(String s) {
    String a="";
    int i=0;
    int j;
    if(s.length()==1){
        return s;
    }
    while (i<s.length()){
        j=s.length()-1;
        while (j>=i&&(j+1-i)>a.length()){
            if(ishuiwenchuan(s,i,j)&&(j+1-i)>a.length()){
                a=s.substring(i,j+1);
                break;
            }
            j--;
        }
        i++;
    }
    return a;
    }

    public static void main(String[] args) {
        likou05 likou05 = new likou05();
        likou05.longestPalindrome("ac");
    }
}
