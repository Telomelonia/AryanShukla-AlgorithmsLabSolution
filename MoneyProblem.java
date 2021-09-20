package traveller;
import java.util.Scanner;
public class MoneyProblem {
    public static void swap(int a,int b){
        int temp = a;
        a = b;
        b = temp;
    }

    static void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    static void mergesort(int arr[], int l, int r)
    {
        if (l < r) {
            int m =l+ (r-l)/2;
            mergesort(arr, l, m);
            mergesort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
    public static void main(String[] args) {
        /*1.sort
        2.check where target stand in array
        3.target = target - number behind it
        4.repeat
        
        OR
        
        1. take array input of currency denom..
        2.find biggest number closest to target money 
        3.subtract biggest number from target and declare the new target and repeat 2.
        4.If target == 0 stop*/
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of currency denominations");
        int currencySize = sc.nextInt();
        System.out.println("Enter the currency denominations value");
        int arr[] = new int[currencySize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the amount you want to pay");
        int target = sc.nextInt();
        int low = 0,high = arr.length-1;
        mergesort(arr, low, high);
        int times = 0;
        /*To find out how many times it would subtract floor divide them*/
        while(target>0)
        {
            if(arr[1]>target)
            {
                times = target/arr[0];
                target-=(arr[0]*times);
                if(times!=0)
                System.out.println(arr[0]+":"+times);
                break;
            }
            if(arr[0]>target){
                System.out.println("Not possible to pay");
                break;
            }
            if(arr[arr.length-1]<target)
            {
                times = target/arr[arr.length-1];
                target-=(arr[arr.length-1]*times);
                if(times!=0)
                System.out.println(arr[arr.length-1]+":"+times);
            }
            for (int i = 2; i < arr.length; i++) 
            {
                if(arr[i]>target)
                {
                    times = target/arr[i-1];
                    target-=(arr[i-1]*times);
                    if(times!=0)
                    System.out.println(arr[i-1]+":"+times);
                }
            }
            
        }
    }
}

