public class Autokey_Cipher {

    public static String encrypt(String text , int key){
        int[] enc = new int[text.length()];
        enc[0] = key;

        for(int i=1;i<enc.length;i++)
        {
            System.out.println();
            enc[i] = (((int)(text.charAt(i-1))) + ((int)(text.charAt(i))) - 2*('a') ) % 26;
        }

        StringBuilder s = new StringBuilder();

        for(int i : enc){
            s.append((char) (i + 'a'));
        }

        return s.toString();
    }

    public static void main(String[] args) {
        String text = "hello";
        int key = 5;

        String encrypted = encrypt(text, key);

        System.out.println(encrypted);
    }
    
}
