
public class NaiveStringMatching{

    public static void main(String[] args) {
        
        String s1 = "hhhh";
        String s2 = "hh";

        int i=0;
        int j=0;

        while(i<s1.length())
        {
            if(j==s2.length())
            {
                System.out.println("String matched at index : " + (i-j));
                i = i-j;
                j=0;
            }
            else if(s1.charAt(i) == s2.charAt(j))
            {
                j++;
            }
            i++;
        }
        if(j==s2.length())
        {
            System.out.println("String matched at index : " + (i-j));
        }
    }
}