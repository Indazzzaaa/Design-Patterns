package DSA.DP;


// Q.Max sum subarray by removing at most one element
// Simple max sum can be found using kandane algo.
// to solve this we have two array `fwd` which will store max sum in fwd
// 'bkw' which will store max sum from back
// for each index maxSum = max(maxSum , fwd[i-1]+bwd[index+1]) // ignore the current element

import java.util.Arrays;

public class MaxSum {

    public static void test(){
        int[] arr1 = {1,2,3,-4,5};
        int[] arr2 = {-2,-3,4,-1,-2,1,5,-3};
        int[] arr3 = {45,81,4,92};

        System.out.println("[Max Sum Subarray]");
        System.out.println(maxSumSubarray(arr1,arr1.length));
        System.out.println(maxSumSubarray(arr2,arr2.length));
        System.out.println(maxSumSubarray(arr3,arr3.length));

        System.out.println("[Space Optimized]");
        System.out.println(spaceOptimized(arr1));
        System.out.println(spaceOptimized(arr2));
        System.out.println(spaceOptimized(arr3));
    }

    private static int maxSumSubarray(int[] arr,int n){
        int[] fwd = new int[n];
        int[] bkw = new int[n];

        int fwdSum= fwd[0]=arr[0];
        int maxSoFar = fwdSum; // to handle case where no element is removed , it will also handle the case where we only exclude first element or last element then it will be continouse subarry sum.(used in last.
        for(int i=1;i<n;i++){

            fwdSum = Integer.max(arr[i],fwdSum+arr[i]);
            maxSoFar = Math.max(maxSoFar,fwdSum);
            fwd[i] = fwdSum;
        }


        int bkwSum=bkw[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
            bkw[i] = Math.max(arr[i],bkwSum+arr[i]);
            bkwSum=bkw[i];
        }



        int result = maxSoFar ;
        // if removing first or last element then max already been found above
        for(int i=n-2;i>0;i--){
            result = Math.max(result, fwd[i-1] + bkw[i+1] );
        }


        return result;




    }


    /*
    * Space optimized O(1)
    * */

    private static int spaceOptimized(int[] arr) {

        int res = Integer.MIN_VALUE, prev = 0, curr = 0;
        for (int x : arr) {
//            Every time with we have two choices
//            1. Either go with the element which are continuous , prev helps in that
//            2. Either go with the elements in which one element in excluded , curr help in that.
//            if not got , do dry run in both array start with +ve number and -ve number.
            curr = Math.max(prev, x + curr);

            prev = Math.max(x, x + prev);


            res = Math.max(res, Math.max(curr, prev));
        }

        return res;
    }


}
