import java.util.LinkedList;
import java.util.List;

public class Leetcode986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int []> res=new LinkedList<>();

        int i=0;
        int j=0;
        int n=firstList.length;
        while (i<n||j<n){
            int a1=firstList[0][0];
            int a2=firstList[0][1];
            int b1=secondList[0][0];
            int b2=secondList[0][1];
            if(a2>=b1&&b2>=a1){
                res.add(new int[]{Math.max(a1,b1),Math.min(a2,b2)});
            }
            if(a2>b2){
                j++;
            }
            else {
                i++;
            }
        }
        int[][] r=new int[res.size()][2];
        for (int k = 0; k < res.size(); k++) {
            r[k]=res.get(k);
        }
        return r;
    }

}
