public class Kmp {
        public int strStr(String txt, String pat)
        {
            int M = pat.length();
            int N = txt.length();

            // create lps[] that will hold the longest
            // prefix suffix values for pattern
            int lps[] = new int[M+1];
            int j = 0; // index for pat[]

            // Preprocess the pattern (calculate lps[]
            // array)
            lps=nextval(" "+pat);

            int i = 0; // index for txt[]
            while (i < N) {
                if(j<0){
                    j=0;
                }
                if (pat.charAt(j) == txt.charAt(i)) {
                    j++;
                    i++;
                }

                // mismatch after j matches
                else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                    // Do not match lps[0..lps[j-1]] characters,
                    // they will match anyway
                    if (j != 0){
                        j=lps[j+1]-1;
                    }
                    else
                        i = i + 1;
                }
                if (j == M) {
                    return i - j;
                }
            }
            return -1;
        }
        // 正常计算的next，但是前面多一位，数组长度多1位
        private int[] next(String ch) {
            int[] next=new int[ch.length()];
            next[1] = 0;
            int i = 1, j = 0;
            while (i < ch.length()-1) {
                if (j == 0 || ch.charAt(i) == ch.charAt(j)) {
                    i++;
                    j++;
                    next[i]=j;
                }
                else j = next[j];
            }
            return next;
        }

    // 优化的nextval
    private int[] nextval(String ch) {
        int[] next=new int[ch.length()];
        next[1] = 0;
        int i = 1, j = 0;
        while (i < ch.length()-1) {
            if (j == 0 || ch.charAt(i) == ch.charAt(j)) {
                i++;
                j++;
                if(ch.charAt(i)!=ch.charAt(j)){
                    next[i]=j;
                }
                else {
                    next[i]=next[j];
                }
            }
            else j = next[j];
        }
        return next;
    }




    public static void main(String[] args) {
        Kmp kmp = new Kmp();
        System.out.println(kmp.strStr("abaabadsfasd",
                "abad"));
    }
}

