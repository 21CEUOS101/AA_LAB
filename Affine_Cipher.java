public class Affine_Cipher{

    public static String encrypt(String input , int key , int k2)
    {
        StringBuilder output = new StringBuilder();

        for(Character i : input.toCharArray())
        {
            int c = (((int) i) + k2) % 'a';
            int ash  = (((c * key) % 26) + 'a');

            System.out.println((i)+ "\t" + (c) + "\t" + ((char)(ash)));
            output.append((char)ash);
        }
        return output.toString();
    }

    public static String decrypt(String input , int key , int k2)
    {

        StringBuilder output = new StringBuilder();
        
        for(Character i : input.toCharArray())
        {
            int c = ((int) i)% 'a'; 
            int ash  = (((c * key) % 26) - k2);
            while (ash < 0) {
                ash += 26;
            }
            ash += 'a';
            System.out.println((i)+ "\t" + (c) + "\t" + ((char)(ash)));
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
        System.out.println("Key" + " " + "Additive" + " " + "Multiplicative");
        String input = "ashish";
        String encoded = encrypt(input , 5 , 10);
        System.out.println("Output : " + encoded);

        int inverse = modInverse(5, 26);
        
        String decoded = decrypt(encoded , inverse , 10);
        System.out.println("Output : " + decoded);
    }
}