public class Multiplicative_Cipher{

    public static String encrypt(String input , int key)
    {
        StringBuilder output = new StringBuilder();

        for(Character i : input.toCharArray())
        {
            int c = ((int) i) - 'a'; 
            int ash  = (((c * key) % 26) + 'a');
            output.append((char)ash);
        }
        return output.toString();
    }

    public static String decrypt(String input , int key)
    {

        StringBuilder output = new StringBuilder();
        
        for(Character i : input.toCharArray())
        {
            int c = ((int) i) - 'a'; 
            int ash  = (((c * key) % 26) + 'a');
            output.append((char)(ash));
        }

        return output.toString();
    }

    public static int modInverse(int A, int M) 
    { 
        for (int X = 1; X < M; X++) 
            if (((A % M) * (X % M)) % M == 1) 
                return X; 
        return 0;
    }   

    public static void main(String args[])
    {
        String input = "abcd";
        String encoded = encrypt(input , 5);
        System.out.println("Output : " + encoded);

        int inverse = modInverse(5, 26);
        
        String decoded = decrypt(encoded , inverse);
        System.out.println("Output : " + decoded);
    }
}