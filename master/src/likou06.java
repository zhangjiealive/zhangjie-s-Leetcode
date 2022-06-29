package likou;

import java.util.ArrayList;
import java.util.List;

public class likou06 {
    public String convert(String s, int numRows) {
        if (s.length() < 2) {
            return s;
        }
        List<StringBuilder> util = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            util.add(new StringBuilder());
        }

        int j=0 ,flag=-1;
                for (char a : s.toCharArray()) {
                    util.get(j).append(a);
                    if(j==0||j==numRows-1) flag=-flag;
                    j+=flag;
                }
        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder st:util
             ) {
        stringBuilder.append(st);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s="PAYPALISHIRING";
        likou06 likou06 = new likou06();
        likou06.convert(s,3);
    }
}
