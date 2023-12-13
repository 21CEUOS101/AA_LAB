public class Euclidian {

    public static int algo(int r1, int r2)
    {
        int s1 = 1;
        int s2 = 0;

        int t1 = 0;
        int t2 = 1;

        int s = 0;
        int t = 0;

        int q = 1;

        while(r1!=0 && r1!=r2)
        {
            if(r1<r2)
            {
                int temp = r1;
                r1 = r2;
                r2 = temp;
            }

            q =(int) r1/r2;
            r1 = r1 - (r2*q);
            s = s1 - (s2*q);
            t = t1 - (t2*q);

            System.out.println(q + " " + r1 + " " + r2 + " " +  (r1%r2) + " " +  s1 + " " +  s2 + " " +  s + " " +  t1 + " " +  t2 + " " + t);

            s1 = s2;
            s2 = s;

            t1 = t2;
            t2 = t;
        }   

        

        return r2;
    }

    public static void main(String[] args) {

        System.out.println("q r1 r2 r s1 s2 s t1 t2 t");   
        
        System.out.println(algo(27,5));
    }
    
}
