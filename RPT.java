import java.util.Random;

class RPT{

    static int gcd(int a,int b)
    {
        if(a==0 || b==0)
        {
            return a+b;
        }
        if(a==b)
        {
            return a;
        }

        if(a > b)
        {
            int temp = b;
            b = a;
            a = temp;
        }

        return gcd(a,b%a);
    }

    static int pow(int a,int x,int y)
    {
        int no_of_steps = 0;
        int res = 1;
        while(x>0)
        {
            if(x%2==1)
            {
                res = (res * a)%y;
            }
            x = x/2;
            a = (a*a)%y;
            no_of_steps++;
        }
        System.out.println("No Of Steps For POWER : "+ no_of_steps + "\n Farmet's Answer : " + res%y + " ");
        return res%y;
    }

    public static boolean check(int n)
    {
        int count = 0;
        int i=0;
        while(i<100)
        {
            int a =  new Random().nextInt(2,n-4);
            if(gcd(a,n) != 1)
            {
                System.out.println("Liars : " + count);
                return false;
            }
            else if(pow(a,n-1,n) != 1)
            {
                System.out.println("Liars : " + count);
                return false;
            }
            else
            {
                count++;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(check(1234126));
    }
    
}