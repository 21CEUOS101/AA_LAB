import java.util.HashSet;
import java.util.Set;

public class Playfair_Cipher{

    public static int[][] gen_mat(String key)
    {

        // Set<Character> st = new HashSet<>();

        // for(Character l : key.toCharArray())
        // {
        //     st.add(l);
        // }



        StringBuilder s = new StringBuilder(key);
        String abcd = "abcdefghijklmnopqrstuvwxyz";
        boolean flag = true;

        for(Character i : abcd.toCharArray())
        {
            for(Character j : s.toString().toCharArray())
            {
                if(j==i)
                {
                    flag = false;
                }
            }
            if(flag && i!='j')
            {
                s = s.append(String.valueOf(i));
            }
            flag = true;
        }

        int[][] mat = new int[5][5];
        int k=0;

        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                mat[i][j] =(int) s.charAt(k);
                k++;
            }
        }

        return mat;
    }

    public static String encrypt(String text , int[][] mat)
    {
        String updated = text;

        for(int i=0;i<text.length()-1;i++)
        {
            if(text.charAt(i) == text.charAt(i+1))
            {
                text = text.substring(0, i+1) + 'x' + text.substring(i+1);
            }
        }

        if(text.length() % 2 == 1)
        {
            text = text + 'x';
        }

        System.out.println(text);

        for(int i=0;i<text.length()-1;i+=2)
        {
            while(text.charAt(i) == 'j')
            {
                i++;
            }
            Character c1 = text.charAt(i);

            int t = i+1;

            while(t<text.length() && text.charAt(t) == 'j')
            {
                t++;
            }

            Character c2 = text.charAt(t);

            int e1x = 0, e1y = 0 , e2x = 0 , e2y = 0;

            for(int j=0;j<5;j++)
            {
                for(int k=0;k<5;k++)
                {
                    if(mat[j][k] == ((int) c1))
                    {
                        e1x = j;
                        e1y = k;
                    }
                    else if(mat[j][k] == ((int) c2))
                    {
                        e2x = j;
                        e2y = k;
                    }
                }
            }

            if(e1x == e2x)
            {
                e1y++;
                e2y++;
            }
            else if(e1y == e2y)
            {
                e1x++;
                e2x++;
            }
            else{
                int temp = e1y;
                e1y = e2y;
                e2y = temp;
            }

            updated = updated.substring(0, i) + ((char) mat[e1x][e1y]) + updated.substring(i);
            updated = updated.substring(0, t) + ((char) mat[e2x][e2y]) + updated.substring(t);
        }

        return updated;
    }
    public static void main(String[] args) {

        int[][] mat = gen_mat("orange");

        String text = "hello";
        
        String encrypted = encrypt(text , mat);

        System.out.println(encrypted.substring(0,encrypted.length()-text.length()));
    }
}