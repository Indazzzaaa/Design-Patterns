package DSA.DP;

import java.util.Arrays;

public class OptimalGameStrategy {
    public static long solveRec(int[] arr,int i, int j){

        if(j==i+1) return Integer.max(arr[i],arr[j]);

        long pickedIth = arr[i] + Long.min(solveRec(arr,i+2,j),solveRec(arr,i+1,j-1));
        long pickedJth = arr[j] + Long.min(solveRec(arr,i+1,j-1),solveRec(arr,i,j-2));

        return Long.max(pickedIth,pickedJth);




    }

    public static long solveDP(int[] arr,int n){


        long[][] dp = new long[n][n];

//        base case
        for(int i=0;i<n-1;i++){
            dp[i][i+1] = Long.max(arr[i],arr[i+1]);
        }

        for(int gap=3;gap<n;gap+=2){
            for(int i=0;i+gap<n;i++){
                int j= i+gap;
                dp[i][j] = Long.max(
                        arr[i]+ Long.min(dp[i+2][j],dp[i+1][j-1]),
                        arr[j] + Long.min(dp[i+1][j-1],dp[i][j-2]) );
            }
        }


        return dp[0][n-1];


    }

    public static void countMaximum()
    {
        int[] arr = {5,3,7,10} ;
        int[] arr2 = {8,15,3,7};
        System.out.println("[Recursive]");
        System.out.println(solveRec(arr,0,arr.length-1)); //15
        System.out.println(solveRec( arr2,0,arr2.length-1)); //22

        System.out.println("[DP]");
        System.out.println(solveDP(arr,arr.length));
        System.out.println(solveDP(arr2,arr2.length));

    }

    public static void test(){
        countMaximum();
    }





}
