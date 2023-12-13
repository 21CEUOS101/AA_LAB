import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Monoalphabetic_Substitution_Cipher {

    public static void main(String[] args) {
        HashMap<Character,Character> mp = new HashMap<>();
        Random random = new Random();
        String abcd = "abcdefghijklmnopqrstuvwxyz";
        int i=0;
        while(mp.size() < 26)
        {
            int r = random.nextInt(26);
            
            if(!mp.containsKey(abcd.charAt(i)))
            {
                mp.put(abcd.charAt(i) , (char) (r + 'a'));
                i++;
            }
        }

        System.out.println(mp);
    }
    
}
