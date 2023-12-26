package DSA.DP;

public class UniqueBST {

    public static  void test(){
        final int mod = (int)Math.pow(10,9)+7;
        System.out.printf("%,d\n",mod);
        System.out.println("[Rec]");
        System.out.println(solveRec(2));
        System.out.println(solveRec(3));
        System.out.println(solveRec(16));
        System.out.println("[DP]");
        System.out.println(solveDP(2));
        System.out.println(solveDP(3));
        System.out.println(solveDP(16));
        System.out.println(solveDP(300));
        System.out.println(solveDP(384));

    }

    public static int solveRec(int n){
        if(n==0) return 1;

        int res=0;
        for(int i=0;i<n;i++){
            res+=(solveRec(i)*solveRec(n-i-1));
        }
        return res;
    }

    public static int solveDP(int N){
        long mod =1000000007;
        long [] dp = new long [N+1];
        dp[0] =1;
        for(int i =1; i<=N; ++i){
            for(int j =0; j<i; ++j)
                dp[i] =(dp[i]%mod+(dp[j]%mod*dp[i-j-1]%mod)%mod)%mod;
        }
        return (int)dp[N];
    }
}
