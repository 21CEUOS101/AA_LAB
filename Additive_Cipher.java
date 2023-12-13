public class Additive_Cipher{

    public static String encrypt(String input , int key)
    {
        StringBuilder output = new StringBuilder();

        for(Character i : input.toCharArray())
        {
            int ash  = (((int) i + key - 'a'));
            System.out.println(i + "\t" + ((char)(ash + 'a')));
            output.append((char)(ash + 'a'));
        }
        return output.toString();
    }

    public static String decrypt(String input , int key)
    {

        StringBuilder output = new StringBuilder();
        
        for(Character i : input.toCharArray())
        {
            int ash  = (((int) i - key));
            System.out.println(i + "\t" + ((char)(ash)));
            output.append((char)(ash));
        }

        return output.toString();
    }

    public static void main(String args[])
    {
        String input = "abcd";
        System.out.println("char cipher");
        String encoded = encrypt(input , 5);
        System.out.println("Output : " + encoded);
        System.out.println("cipher output");
        String decoded = decrypt(encoded , 5);
        System.out.println("Output : " + decoded);
    }
}