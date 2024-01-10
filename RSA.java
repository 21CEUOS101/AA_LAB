import java.util.Random;

public class RSA{

    public static long gcd(long r1, long r2)
    {

        long n = r2;
        long s1 = 1;
        long s2 = 0;

        long t1 = 0;
        long t2 = 1;

        long s = 0;
        long t = 0;

        long q = 1;

        while(r1!=0 && r1!=r2)
        {
            if(r1<r2)
            {
                long temp = r1;
                r1 = r2;
                r2 = temp;
            }

            q =(long) r1/r2;
            r1 = r1 - (r2*q);
            s = s1 - (s2*q);
            t = t1 - (t2*q);

            s1 = s2;
            s2 = s;

            t1 = t2;
            t2 = t;
        }

        // System.out.println("GCD : " + r2);

        while(t1 < 0)
        {
            t1 += n;
        }

        // System.out.println("Inverse : " + t1);

        return t1;
    }


    // public static void key_generation()
    // {
        

    // }

    public static long m_and_s(long m , long e , long n){

        long res = 1;
        m = m % n;

        while(e>0)
        {
            if(e % 2 == 1)
            {
                res = (res * m)%n;
            }
            m = (m * m) % n;
            e = e/2;
        }

        return res%n;
    }

    public static long encryption(long m , long e , long n)
    {
        return m_and_s(m,e,n);
    }

    public static long decryption(long c , long d , long n)
    {
        return m_and_s(c,d,n);
    }

    public static void main(String[] args) {
        
        long p = 3;
        long q = 23;

        long n = p*q;

        System.out.println("N : " + n);

        long phi_n = (p-1) * (q-1);
        long e;
        long inv;

        while (true) {
            Random random = new Random(); 

            e = random.nextInt((int) phi_n -2) + 2;

            inv = gcd(e,phi_n);
            if( inv != 0 && inv != 1)
            {
                System.out.println("E : " + e);
                break;
            }
        }

        // System.out.println("PHI(N) : " + phi_n);
        gcd(e , phi_n);
        System.out.println("D : " + inv);

        long ec = encryption(2,e,n);

        System.out.println(ec);

        long pt = decryption(ec, inv ,n);

        System.out.println(pt);


    }
}