public class KMP {
    
    // abcdabc
    public static void pi(int[] arr,String pattern)
    {
        arr[0] = 0;
        int k = 0;
        int i = 0;
        while (i < arr.length - 1) {
            while (k > 0 && pattern.charAt(k) != pattern.charAt(i + 1)) {
                k = arr[k];
            }

            if (pattern.charAt(k) == pattern.charAt(i + 1)) {
                k++;
            }

            arr[i + 1] = k;
            i++;
        }
    }
    
    public static void kmp_algo(int[] pi, String pattern, String text)
    {
        int i = 0;
        int k = 0;
        
        while(i<text.length())
        {
            while(k>0 && pattern.charAt(k) != text.charAt(i))
            {
                k = pi[k-1];
            }

            if(pattern.charAt(k) == text.charAt(i))
            {
                k++;
            }

            if(k == pattern.length())
            {
                System.out.println("Pattern Found at : " + (i - pattern.length() + 1));
                k = pi[k-1];
            }
            i++;
        }
    }

    public static void main(String[] args) {
        
        String pattern = "ash";
        int arr[] = new int[pattern.length()];

        pi(arr, pattern);

        System.out.println("Pi table : ");
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i] + " ");
        }

        String text = "ashishashish";

        kmp_algo(arr, pattern, text);
    }

}
