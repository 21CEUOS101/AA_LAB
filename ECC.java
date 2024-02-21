import java.util.ArrayList;
import java.util.Random;

public class ECC {

    public static boolean checkInt(double n) {
        return n / ((int) n) == 1;
    }

    public static void ec(int a, int b, int p , ArrayList<int[]> arr) {
        for (int x = 0; x < p; x++) {
            double w = Math.pow(x, 3) + a * x + b;
            w = w % p;
            while (w < 0) {
                w += p;
            }
            if (w == 0) {
                
                arr.add(new int[]{x,0});
                continue;
            }
            double ans = Math.pow(w, 0.5);
            if (checkInt(ans)) {

                arr.add(new int[]{x,(int) ans});

            } else {
                double temp = (p - 1) / 2;
                double t = Math.pow(w, temp);
                t = t % p;
                if (t == 1) {
                    while (w <= p * p) {
                        w += p;
                        if (checkInt(Math.pow(w, 0.5))) {
                            break;
                        }
                    }
                    if (w > p * p) {
                        continue;
                    } else {
                        ans = Math.pow(w, 0.5);
                        arr.add(new int[]{x,(int) ans});
                    }
                } else {
                    continue;
                }
            }
        }
    }

    public static int[] key_generation(int a, int b, int p) {
        ArrayList<int[]> arr = ec(a,b,p);

        Random random = new Random();
        int[] e1 = arr.get(random.nextInt(arr.size()));

        return e1;
    }

    public static int[] calculate_e2(int[] e1 , int d , int a)
    {
        int[] e2 = new int[2];
        int lamda = 0;

        for(int i=0;i<d;i++)
        {
            if(e1[0] == e2[0] && e1[1] == e2[1])
            {
                lamda = (3*(e1[0]*e1[0]) + a)/(2*e2[1]);
            }

            e2[0] = (lamda*lamda)-(2*e1[0]);

            e2[1] = 
        }

        return e2;
    }

    public static void main(String[] args) {

        int a = 1;
        int b = 1;
        int p = 13;

        int[] e1 = key_generation(a,b,p);

        Random random = new Random();

        int d = random.nextInt(p-1);

        int[] e2 = calculate_e2(e1 , d);
    }
}