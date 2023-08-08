public class HorsePool{
    public static void main(String[] args) {
        

        String s1 = "aaaa";
        String s2 = "aa";

        int[] pool = new int[26];

        for(int i=0;i<26;i++)
        {
            pool[i] = s2.length();
        }

        for(int i=0;i<s2.length()-1;i++)
        {
            pool[s2.charAt(i)-'a'] = s2.length() - 1 - i;
        }

        for(int i=0;i<s1.length()-s2.length()+1;i++)
        {
            int j=s2.length()-1;
            for(;j>=0 && i>=0;j--)
            {
                if(s1.charAt(i+j)!= s2.charAt(j))
                {
                    i += pool[s1.charAt(i+j)-'a'] - 1;
                    break;
                }
            }
            if(j==-1)
            {
                System.out.println("String Matched at index : " + (i-j));
            }
        }
    }
}