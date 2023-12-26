package DSA.DP;

public class nCr {


    static final  int MOD = (int)Math.pow(10,9) +7;


    public static int solveRec(int n , int r){
        if(r==0 || n==r) return 1;

        return
                (solveRec(n-1,r-1)%MOD +
                        solveRec(n-1,r)%MOD)%MOD;





    }

//    can be optimized in terms of space.
    public static int solveDP(int n , int r){

        if(n==r) return 1;

        final int rows = r+1;
        final int cols = n+1;
        final int diagonals = Math.min(n,r);
        int[][] dp = new int[rows][cols];


//        fill the base cases
        for(int col=0;col<cols;col++){
            dp[0][col]=1;
        }


        for(int diagonal=0;diagonal<diagonals;diagonal++){
            dp[diagonal][diagonal] =1;
        }

        for(int row=1;row<rows;row++){
            for(int col=1;col<cols;col++){

//                in nCr => n>=r , and n==r already filled in base case
                if(row < cols){
                    dp[row][col] = (dp[row-1][col-1] + dp[row][col-1])%MOD;
                }
            }
        }


        return dp[rows-1][cols-1];

    }


    public static void test(){

        System.out.println("[Recursion]");
        System.out.println(solveRec(4,2));
        System.out.println(solveRec(3,1));
        System.out.println(solveRec(3,2));
        System.out.println(solveRec(0,0));
//        System.out.println(solveRec(100000,1)); give stack overflow exception

        System.out.println("[DP]");
        System.out.println(solveDP(4,2));
        System.out.println(solveDP(3,1));
        System.out.println(solveDP(3,2));
        System.out.println(solveDP(0,0));
        System.out.println(solveDP(100000,500));


    }




}
