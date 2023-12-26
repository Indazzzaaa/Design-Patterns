package DSA.DP;

import java.util.Arrays;

public class MinJumpToReachEndArray {


//     n^n time
    public static int solveRec(int[] arr,int index){
        if(arr[0]==0) return Integer.MAX_VALUE;



        if(arr[index] + index >= (arr.length-1)) return 1;

        final int maxAllowedPos = arr[index]+index;

        int minJumps = Integer.MAX_VALUE;
        for(int i=index+1;i<= maxAllowedPos;i++){
            minJumps = Math.min(minJumps,solveRec(arr,i));
        }

        return minJumps==Integer.MAX_VALUE ?  minJumps: minJumps+1;




    }

//    n^2 time
    public static int solveDP(int[] arr ){
        if(arr[0]==0) return -1;
        int[] dp = new int[arr.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;

        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[j]+j >=i && dp[j]!=Integer.MAX_VALUE)
                        dp[i] = Integer.min(dp[i],dp[j]+1);
            }
        }

        return dp[arr.length-1];
    }

//    n time
//    logic : every index has info how further we can go.
    // we'll make jump when our further end reached from current index or we can say we don't have steps anymore.
    // negative case : we saw all futher distance we can go , but if we reach position i which is greater then further distance found before.
    // then it means we can't go to this index , so return -1

    public static int solveGreedy(int[] arr,int n){
        if(arr[0]==0) return -1;
        if(arr[0]>= n-1) return 1;
        int jump =1;
        int maxReach = arr[0];
        int steps = arr[0];

        for(int i=1;i<arr.length;i++){

            if(i==n-1) return jump;

            maxReach = Integer.max(maxReach,arr[i]+i);
            if(maxReach> (n-1)) return jump +1;

            steps--; // as we go further we are using our step provided.

            if(steps==0){
                jump++; // now jump (actually we would have jumped anywhere between the steps but it will be 1 only so we are counting that jump at then end of step exhausted)

                if(i>=maxReach) return -1;  // means we did not find position from where we can reach to i or after i.

               steps = maxReach -i;  // this is tricky , but think of like we are storing remaining we have to reach max distance from current index.
            }


        }

        return -1;

    }

    public static int minimumJumps(int arr[], int n)
    {
//        int result = solveRec(arr,0);
        int result = solveDP(arr);
        return result==Integer.MAX_VALUE ? -1 : result;

    }

    public static  void Test(){
        int[] arr = {1,3,5,8,9,2,6,7,6,8,9}; // 3
        int[] arr2 = {1,4,3,2,6,7}; //2
        int[] arr3 = {1,2,3}; // -1
        int[] arr4 = {1,2,0,0,0,2,0}; // -1

        System.out.println(MinJumpToReachEndArray.solveGreedy(arr,arr.length));
        System.out.println(MinJumpToReachEndArray.solveGreedy(arr2,arr2.length));
        System.out.println(MinJumpToReachEndArray.solveGreedy(arr3,arr3.length));
        System.out.println(MinJumpToReachEndArray.solveGreedy(arr4,arr4.length));
    }


}
