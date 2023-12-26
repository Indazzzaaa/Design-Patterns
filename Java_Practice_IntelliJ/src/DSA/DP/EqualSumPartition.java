package DSA.DP;
/*
* Given a set of numbers,
* check whether it can be partitioned into two subsets such that the sum of
*  elements in both subsets is same or not
* */


public class EqualSumPartition {
    public static void test(){
        int[] arr1 = {1,5,11,5};
        int[] arr2 = {1,3,5};
        int[] arr3 = {1,-1};
        System.out.println("[Equal Sum Partition]");
        System.out.println("[Recursion Solution]");
        System.out.println(findPartition(arr1,arr1.length));
        System.out.println(findPartition(arr2,arr2.length));
        System.out.println(findPartition(arr3,arr3.length));
        System.out.println("[DP Solution]");
        System.out.println(solveDP(arr1,arr1.length));
        System.out.println(solveDP(arr2,arr2.length));
        System.out.println(solveDP(arr3,arr3.length));

    }

    private static boolean findPartition(int[] arr , int n){

        int sum=0;
        for(var element: arr) sum+=element;

//        if sum is odd then can't be partioned in subset for equal sum
        if(sum%2 !=0) return false;


//        idea is simple find the subset having sum half  of original
        return solveRec(arr,n, sum/2);






    }

    private static boolean solveRec(int[] arr, int n , int sum){

        if(sum==0) return true;
        if(n==0) return false;

//        every element will have two choices either to be part of it or not.

        return solveRec(arr,n-1,sum) || solveRec(arr,n-1,sum-arr[n-1]);


    }

    private static boolean solveDP(int[] arr, int n){
        int sum = 0;
        int i, j;

        // Calculate sum of all elements
        for (i = 0; i < n; i++)
            sum += arr[i];

        if (sum % 2 != 0)
            return false;

        boolean part[][] = new boolean[sum / 2 + 1][n + 1];

        // initialize top row as true
        for (i = 0; i <= n; i++)
            part[0][i] = true;

        // initialize leftmost column, except part[0][0], as
        // 0
        for (i = 1; i <= sum / 2; i++)
            part[i][0] = false;

        // Fill the partition table in bottom up manner
        for (i = 1; i <= sum / 2; i++) {
            for (j = 1; j <= n; j++) {
                part[i][j] = part[i][j - 1];
                if (i >= arr[j - 1])
                    part[i][j]
                            = part[i][j]
                            || part[i - arr[j - 1]][j - 1];
            }
        }

        /* // uncomment this part to print table
        for (i = 0; i <= sum/2; i++)
        {
            for (j = 0; j <= n; j++)
                printf ("%4d", part[i][j]);
            printf("\n");
        } */

        return part[sum / 2][n];
    }



}
