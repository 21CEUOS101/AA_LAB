import java.util.Random;

class RandomizedQuickSort{

    static int count = 0;

    public static void QuickSort(int p,int r,int[] arr)
    {
        if(p<r)
        {
            int q = partition(arr,p,r);

            QuickSort(p,q-1,arr);
            QuickSort(q+1,r,arr);
        }
    }

    public static int partition(int[] arr,int p,int r)
    {

        int random = new Random().nextInt(r-p+1) + p;

        int temp2 = arr[random];
        arr[random] = arr[r];
        arr[r] = temp2;

        int pivot = arr[r];

        int j = p;
        int i = j-1;

        while(j<r)
        {
            if(arr[j] < pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            j++;
            count++;
        }

        //swapping pivot
        int temp = arr[i+1];
        arr[i+1] = arr[j];
        arr[j] = temp;

        //returning pivot index
        return i+1;
        
    }

    public static void main(String args[])
    {
        int arr[] = {1,2,3,4,5,6};
        int arr2[] = {6,5,4,3,2,1};
        int arr3[] = new int[100];

        for(int i=0;i<100;i++)
        {
            arr3[i] = i*3;
        }

        QuickSort(0,5,arr);
        System.out.println(count);
        count = 0;
        QuickSort(0,5,arr2);
        System.out.println(count);
        count = 0;
        QuickSort(0,99,arr3);
        System.out.println(count);
        count = 0;

        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for(int i=0;i<arr2.length;i++)
        {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        // for(int i=0;i<arr3.length;i++)
        // {
        //     System.out.println(arr3[i]);
        // }
        // System.out.println();
    }
}