package DSA.DP;

public class Knapsack01 {




    public static int solveRec(int w,int wt[],int val[],int n){

        if(n==0 || w==0) return 0;
       if(wt[n-1]> w) return solveRec(w,wt,val,n-1);
       else{
           return Integer.max(solveRec(w,wt,val,n-1),
                   val[n-1]+solveRec(w-wt[n-1],wt,val,n-1));
       }

    }

    public static  int sovleDP(int w,int wt[], int val[],int n){
        final int rows = n+1;
        final int cols = w+1;
        int[][] dp = new int[n+1][w+1];
        for(int row=0;row<rows;row++) dp[row][0]=0;
        for(int col=0;col<cols;col++) dp[0][col]=0;


        for(int row=1;row<rows;row++){
            for(int col=1;col<cols;col++){
                if(wt[row-1]> col){
                    dp[row][col] = dp[row-1][col];
                }else{
                    dp[row][col] = Integer.max(dp[row-1][col],val[row-1]+dp[row-1][col-wt[row-1]]);
                }
            }
        }

    return dp[rows-1][cols-1];

    }



    public static  void test(){
        int[] wt = {4,5,1};
        int[] val = {1,2,3};
        System.out.println("[Recursive]");
        System.out.println(  solveRec(0,wt,val,wt.length));
        System.out.println(  solveRec(1,wt,val,wt.length));
        System.out.println(  solveRec(4,wt,val,wt.length));
        System.out.println(  solveRec(5,wt,val,wt.length));
        System.out.println(  solveRec(10,wt,val,wt.length));

        System.out.println("[DP]");
        System.out.println(sovleDP(0,wt,val,wt.length));
        System.out.println(sovleDP(1,wt,val,wt.length));
        System.out.println(sovleDP(4,wt,val,wt.length));
        System.out.println(sovleDP(5,wt,val,wt.length));
        System.out.println(sovleDP(10,wt,val,wt.length));
    }
}
