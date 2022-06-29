
public class likou10 {
    public boolean isMatch(String s, String p) {
    int s_index=0;

    int p_index=0;
    int p_tail=p.length();
    while(p_tail!=p_index){
    if(p.charAt(p_index)=='.'||p.charAt(p_index)==s.charAt(s_index)){
        s_index++;
        p_index++;
        continue;
    }
    else if(p.charAt(p_index)=='*'){
        if(p_index==p.length()-1){
            return true;
        }
        else {
            return isMatch(s.substring(s.length() - p_index - 1, s.length()), p.substring(p.length() - 1 - p_index, p.length()));
        }
    }
    else {
        return false;
    }
    }
    if(s_index!=s.length()){
        return false;
    }
    else {
        return true;
    }
    }

    public static void main(String[] args) {
        likou10 likou10 = new likou10();
        likou10.isMatch("aa","a*");
    }
}
