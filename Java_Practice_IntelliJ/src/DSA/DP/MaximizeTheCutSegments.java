package DSA.DP;

public class MaximizeTheCutSegments {
    public static int solveRec(int n,int x,int y,int z){
        if(n==0) return 0;
        if(n<0) return Integer.MIN_VALUE;

        int maxCutCount = Integer.max(solveRec(n-x,x,y,x),
                Integer.max(solveRec(n-y,x,y,x),solveRec(n-z,x,y,x)));

        if(maxCutCount==Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return maxCutCount+1;




    }

    public static int solveDP(int n , int x, int y,int z){
        final int size = n+1;
        int[] dp = new int[size];
        dp[0]=0;
        for(int i=1;i<size;i++){

            dp[i] = Integer.MIN_VALUE;

            if(i>=x) dp[i] =  dp[i-x] == Integer.MIN_VALUE ? dp[i] : (dp[i-x]+1);
            if(i>=y) dp[i] =  dp[i-y] == Integer.MIN_VALUE ? dp[i] : Integer.max(dp[i],dp[i-y]+1);
            if(i>=z) dp[i] =  dp[i-z] == Integer.MIN_VALUE ? dp[i] : Integer.max(dp[i],dp[i-z]+1);


        }

        return  dp[n]==Integer.MIN_VALUE ? 0 : dp[n];
    }

    public static int maximizeCuts(int n, int x, int y, int z)
    {
        int result =solveRec(n,x,y,z);
        return result == Integer.MIN_VALUE ? 0 : result;
    }


    public static  void Test1(){
        System.out.println("[Recursive Test]");

        System.out.println(maximizeCuts(4,2,1,1));
        System.out.println(maximizeCuts(5,5,3,2));
        System.out.println(maximizeCuts(4,3,3,3));

        System.out.println("[DP Test]");

        System.out.println(solveDP(4,2,1,1));
        System.out.println(solveDP(5,5,3,2));
        System.out.println(solveDP(4,3,3,3));
    }
}
