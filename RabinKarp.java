public class RabinKarp {

    public static void rabin_karp(String s,String t)
    {
        int d = 10;
        int q = 13;
        double dm = Math.pow(d, t.length() - 1);
        int t1 = 0;
        int t2 = 0;
        int m = t.length();

        for(int j=0;j<m;j++)
        {
            t1 = (d*t1 + ((s.charAt(j) - '0') % q))%q;
            t2 = (d*t2 + ((t.charAt(j) - '0') % q))%q;
        }
        t1 = t1 % q;
        t2 = t2 % q;


        for(int i=0;i<=s.length()-t.length();i++)
        {
            if (t1 == t2) {
                int j = 0;
                for (; j < t.length(); j++) {
                    if (s.charAt(i+j) != t.charAt(j)) {
                        break;
                    }
                }
                if (j == t.length()) {
                    System.out.println("Pattern Found at :" + i);
                }
            } else {
                t1 = (int) (t1 - ((s.charAt(i + 1) - '0')*dm)) * 10 + (s.charAt(i + m) - '0');
                while(t1 < 0)
                {
                    t1 += q;
                }
                t1 = t1 % q;
            }
        }

    }
    public static void main(String[] args) {
        String s = "1234567456";
        String t = "456";
        rabin_karp(s, t);
    }
    
}
