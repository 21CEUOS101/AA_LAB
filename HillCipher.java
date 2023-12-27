public class HillCipher{

    public static int[][] mul(int[][] key , int[][] p)
    {
        int[][] ans = new int[key.length][p[0].length];
        for(int i=0;i<key.length;i++)
        {
            for(int j=0;j<p[0].length;j++)
            {
                for(int k=0;k<key[0].length;k++)
                {
                    ans[i][j] += (key[i][k] * p[k][j]);
                }

                ans[i][j] = ans[i][j] % 26;
            }
        }

        return ans;
    }

    public static int[][] encryption(int[][] key , String text)
    {

        int[][] p= new int[text.length()][1];

        for(int i=0;i<p.length;i++)
        {
            p[i][0]  = (int) (text.charAt(i) - 'a');
        }

        int[][] encry = new int[key.length][p[0].length];

        encry = mul(key , p);

        System.out.print("Encrypted Text : ");
        for(int i=0;i<encry.length;i++)
        {
            for(int j=0;j<encry[0].length;j++)
            {
                System.out.print((char) ((encry[i][j])%26 + 'a') + " ");
            }
        }
        System.out.println();
        System.out.println();

        return encry;
    }

    public static int mod_2d(int[][] mat)
    {
        return ((mat[1][1] * mat[0][0]) - (mat[0][1] * mat[1][0]));
    }

    public static int[][] adjoint_2d(int[][] mat)
    {
        int[][] adj = new int[2][2];

        adj[0][0] = mat[1][1];
        adj[0][1] = ((-1) * mat[0][1]);
        adj[1][0] = ((-1) *  mat[1][0]);
        adj[1][1] = mat[0][0];

        return adj;
    }

    public static int modInverse(int A, int M) 
    { 
        for (int X = 1; X < M; X++) 
            if (((A % M) * (X % M)) % M == 1) 
                return X; 
        return 0;
    }   

    public static String decryption(int[][] encrypted , int[][] key)
    {
        int mod = mod_2d(key);

        int inv = modInverse(mod, 26);

        System.out.println("Mod Inverse : "  +  inv);
        System.out.println();

        int[][] adj = new int[key.length][key[0].length];

        adj = adjoint_2d(key);

        // Printing Inverse of a Matrix

        System.out.println("Inverse of a Matrix : ");
        for(int i=0;i<adj.length;i++)
        {
            for(int j=0;j<adj[0].length;j++)
            {
                adj[i][j] = (adj[i][j] * inv)%26;

                while(adj[i][j] < 0)
                {
                    adj[i][j] += 26;
                }

                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        // -----------------------------------


        int[][] ans = new int[2][1];

        ans = mul(adj , encrypted);


        // Printing Decrypted Matrix
        System.out.println("Decrypted Matrix : ");
        for(int i=0;i<ans.length;i++)
        {
            for(int j=0;j<ans[0].length;j++)
            {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        // ----------------------------

        StringBuilder s = new  StringBuilder();

        for(int i=0;i<ans.length;i++)
        {
            s.append((char) (ans[i][0] + 'a'));
        }

        return s.toString();
    }

    public static void main(String args[])
    {
        System.out.println();

        int[][] key = {{2,1} , {1,2}};
        
        String text = "sh";

        System.out.println("Plain Text : " + text);
        System.out.println();

        int[][] encrypted = encryption(key , text);

        String plain = decryption(encrypted , key);

        System.out.println("Decrypted Plain Text : " + plain);
    }
}