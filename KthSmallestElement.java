import java.util.Random;
class KthSmallestElement{

    public static int quick(int p,int r,int[] arr,int k)
    {
        if(p<r)
        {
            int q = partition(p,r,arr);
            if(k==q)
            {
                return arr[k];
            }
            else if(k>q)
            {
                return quick(q+1, r, arr,k);
            }
            else
            {
                return quick(p, q-1, arr,k);
            }
        }
        else
        {
            return -1;
        }
    }

    public static int partition(int p,int r,int[] arr)
    {
        int a = new Random().nextInt(p,r-p+1);
        int temp = arr[r];
        arr[r] = arr[a];
        arr[a] = temp;
        int pivot = arr[r];

        int j=p;
        int i=j-1;

        while(j<r)
        {
            if(arr[j] < pivot)
            {
                i++;
                int t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
            j++;
        }

        int t = arr[j];
        arr[j] = arr[i+1];
        arr[i+1] = t;
        return i+1;
    }

    public static void main(String[] args) {
        int arr[] = {1,6,3,5,2,4};

        System.out.print("Element : " + quick(0, arr.length-1, arr, 4));
    }
}