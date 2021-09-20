
package transactions;

import java.util.Scanner;
public class Txn {
    public int implement(int[] arr, int key){
        int res = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            if(sum >= key)
            {
                res = i+1;
                break;
            }
            else
            res = 0;
        }
        return res;   

    } 
    public static void main(String[] args) {
        //ask no. of trans...
        System.out.println("Enter the size of the transaction array");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        //values input in array
        System.out.println("Enter the values of the array");
        for (int i = 0; i < arr.length; i++) {
           arr[i] = sc.nextInt();
        }
        System.out.println("Enter the total no of targets that needs to be achieved");
        int targetNo = sc.nextInt();
        
        for (int j = 0; j < targetNo; j++) {
            System.out.println("Enter the value of target");
            int target = sc.nextInt();
            Txn lol = new Txn();
            int diff = lol.implement(arr, target);
            if(diff>0)
            {
                System.out.println("Target achieved after "+diff+" transactions");
            }
            else
            {
                System.out.println("Given target is not achieved");
            }
        }

    }
    

}
