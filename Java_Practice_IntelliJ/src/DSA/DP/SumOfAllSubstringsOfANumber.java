package DSA.DP;


import java.util.Arrays;

//given : number in form of string ,we have to find sum of all substring of number
public class SumOfAllSubstringsOfANumber {

//    n^3 time complexity (another n is from s.substring)
    final static long mod = (long) (Math.pow(10,9) +7);
    public static long sumLoopWay(String s){

        int size = s.length();

        long result = 0;

        for(int start =0;start<size;start++){
            for(int end=start;end<size;end++){
                result = (result + Long.parseLong(s.substring(start,end+1))%mod)%mod;
            }
        }

        return result;




    }


//    https://www.geeksforgeeks.org/sum-of-all-substrings-of-a-string-representing-a-number/
//    Example: num = “1234”
    /*
     sumofdigit[3] = 4 + 34 + 234 + 1234
                     = 4 + 30 + 4 + 230 + 4 + 1230 + 4
                     = 4*4 + 10*(3 + 23 +123)
                     = 4*4 + 10*(sumofdigit[2])

                In general, sumofdigit[i]  =  (i+1)*num[i] + 10*sumofdigit[i-1]

     */
    public static long solveDP(String s){

        int size = s.length();
        long[] dp = new long[size];
        dp[0] = s.charAt(0)-'0';


        long res = dp[0];
        for(int i=1;i<size;i++){
            long ithValue = s.charAt(i)-'0';
            dp[i] = (((i+1)*ithValue)%mod + (10*dp[i-1])%mod)%mod;

            res = (res + dp[i])%mod;

        }

        return res;


    }






    public  static void test1(){
        System.out.println("[Loop Test]");
        System.out.println(sumLoopWay("1"));
        System.out.println( sumLoopWay("421"));
        System.out.println( sumLoopWay("1234"));
        System.out.println( sumLoopWay("10000"));

        System.out.println("[DP solution]");
        System.out.println(solveDP("1"));
        System.out.println( solveDP("421"));
        System.out.println( solveDP("1234"));
        System.out.println( solveDP("10000"));
    }







}
