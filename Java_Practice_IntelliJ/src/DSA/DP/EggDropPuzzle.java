package DSA.DP;

public class EggDropPuzzle {


    public static void test(){
        System.out.println("[Recursive]");
        System.out.println(solveRec(1,2));
        System.out.println(solveRec(2,10));

        System.out.println("[DP]");
        System.out.println(solveDp(1,2));
        System.out.println(solveDp(2,10));

    }


    private static int solveRec(int e, int f){

        if(f==0 || f==1) return f;
        if(e==1) return f; // if we have 1 egg then have to start from bottom and check for each floor


        int res = Integer.MAX_VALUE;
        for(int x=1;x<=f;x++){
//            every floor either break or not break
            int tempMax = 1+Integer.max(solveRec(e-1,x-1),solveRec(e,f-x));
            if(tempMax < res) res = tempMax;
        }

        return res;



    }

    private static int solveDp(int e, int f){
//        dp[row][col] : represents given row eggs and col floor number of trails required
        int[][] dp = new int[e+1][f+1];
//        for egg==0 value will ultimately will be 0 because no way to do trails
        // case e==1 , return f
        for(int col=1;col<=f;col++) dp[1][col] = col;

//        filling the table
        for(int row =2;row<=e;row++){
            for (int col=1;col<=f;col++){
                dp[row][col] = Integer.MAX_VALUE;
                for(int j=1;j<=col;j++){

                    dp[row][col] = Integer.min(dp[row][col],1+Integer.max(dp[row-1][j-1],dp[row][col-j]));
                }
            }
        }

    return  dp[e][f];

    }


}
