package DSA.DP;


import java.util.Arrays;

// Matrix given , start from (0,0) , and allowed movement (down or right) , and des = bottom right of matrix.
//find number of unique ways to go there.
public class CountUniquePath {

    public static void Test(){
        System.out.println("[Recusive]");
        System.out.println(CountUniquePath.numberOfPathRec(2,2));
        System.out.println(CountUniquePath.numberOfPathRec(2,4));
        System.out.println(CountUniquePath.numberOfPathRec(3,4));

        System.out.println("[DP]");

        System.out.println(CountUniquePath.numberOfPathDP(2,2));
        System.out.println(CountUniquePath.numberOfPathDP(2,4));
        System.out.println(CountUniquePath.numberOfPathDP(3,4));

        System.out.println("[Space Optimized]");

        System.out.println(CountUniquePath.numberOfPathDPSpaceOptimized(2,2));
        System.out.println(CountUniquePath.numberOfPathDPSpaceOptimized(2,4));
        System.out.println(CountUniquePath.numberOfPathDPSpaceOptimized(3,4));
    }



//    we are going from bottom right to top left, so we don't have to introduce another variables
    public static int numberOfPathRec(int a,int b){

        if(a==1 && b==1) return 1;
        if(a<1 || b<1) return 0;
        return numberOfPathRec(a-1,b) + numberOfPathRec(a,b-1);
    }

    public static int numberOfPathDP(int a,int b){

//        dp[i][j] represents total path to reach i,j position from 0,0
        int[][] dp = new int[a][b];


        for(int col=0;col<b;col++) dp[0][col] =1;
        for(int row=0;row<a;row++) dp[row][0] =1;

        for(int row=1;row<a;row++){
            for(int col=1;col<b;col++){
                dp[row][col] = dp[row-1][col] + dp[row][col-1];
            }
        }

        return dp[a-1][b-1];



    }

    public static int numberOfPathDPSpaceOptimized(int a,int b){

        if(a==1 || b==1) return 1;

       int[][] dp = new int[2][b];
       dp[1][0]=1;
        Arrays.fill(dp[0],1);

        for(int row=1;row<a;row++){
            for(int col=1;col<b;col++){
                dp[1][col] = dp[0][col] + dp[1][col-1];
            }

//            copy content of row index=1 to index =0;
            System.arraycopy(dp[1], 0, dp[0], 0, b);
        }



        return dp[1][b-1];
    }


}
