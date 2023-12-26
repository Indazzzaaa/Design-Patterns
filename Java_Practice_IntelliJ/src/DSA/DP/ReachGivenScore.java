package DSA.DP;

/*
*
* Consider a game where a player can score 3 or 5 or 10 points in a move. Given a total score n, find the number of distinct combinations to reach the given score.
* */
public class ReachGivenScore {

    public static int solveRec(int n,int subCount){

        if(n==0) return 1;
        if(n<0) return 0;

        int res =0;
//        only allowed to call 3,5,10 , if call was for 3,
        if(subCount==3){
          res+=  solveRec(n-3,3);
        }

//        allowed to call 5,10  only if call was for 5
        if(subCount <=5){
            res+= solveRec(n-5,5);
        }
//        otherwise allowed to call for 10
        res+= solveRec(n-10,10);

        return res;


    }


    public static int sovleDP(int n)
    {

        int[] dp = new int[n+1];
        int[] arr = {3,5,10};

        dp[0]=1;

        for(int i=0;i<3;i++){
            for(int j=arr[i];j<=n;j++){
                dp[j] += dp[j-arr[i]];
            }
        }

        return dp[n];

    }

    public static int allPossibleWayToReachPos(int n){
        int dp[]  = new int[n+1];
        dp[0]=1;
        for(int i=3;i<=n;i++){
            if(i-3 >=0 ) dp[i] = dp[i-3];
            if(i-5 >=0 ) dp[i] += dp[i-5];
            if(i-10 >=0 ) dp[i] += dp[i-10];
        }

        return dp[n];



    }

    public static void test(){

        System.out.println("[Rec]");
        System.out.println(solveRec(8,3));
        System.out.println(solveRec(20,3));
        System.out.println(solveRec(100,3));

        System.out.println("[DP]");
        System.out.println(sovleDP(8));
        System.out.println(sovleDP(20));
        System.out.println(sovleDP(100));

        System.out.println("[All possible ways]");
        System.out.println(allPossibleWayToReachPos(8));
        System.out.println(allPossibleWayToReachPos(10));
        System.out.println(allPossibleWayToReachPos(20));
        System.out.println(allPossibleWayToReachPos(100));


    }
}
