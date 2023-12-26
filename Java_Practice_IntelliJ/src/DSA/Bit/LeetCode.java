package DSA.Bit;

public class LeetCode {

    public static void test(){
        System.out.println("[Bit test starts]");

        System.out.println(hammingWeight(-1));
        System.out.println(hammingWeight2(-1));

    }


    // 137
    private static int singleNumber(int[] nums) {
        // ones will have number which occured 1 times
        // two will have number occured 2 time
        // and number occured 3 time will not been kept

        int ones=0,twos=0;
        for(var num : nums){
            ones = (ones^num) & ~twos;
            twos = (twos^num) & ~ones;
        }

        return ones;



    }


//    191 : number of 1 bits
    private static int hammingWeight(int n){

        int bitCount=0;
        if(n<0){
            bitCount++;
            n =  (~(1<<31))&n;
        }

        while(n>0){
            bitCount++;
            n= n&(n-1);
        }



        return bitCount;
    }


//    space efficient
    private static   int hammingWeight2(int n) {
        int count = 0;
        while(n!=0){
            count += (n & 1);
            n = n >>> 1;  // used unsigned shift
        }

        return count;
    }

    //190
    private static int reverseBits(int n) {

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans |= (n & 1);
            n >>= 1;
        }
        return ans;


    }



    // 67

    public static void addBinaryTest() {
        System.out.println(addBinary("11","1")); //100
        System.out.println(addBinary("1","1")); // 10
        System.out.println(addBinary("1","0")); // 1
        System.out.println(addBinary("1010","1011")); // 10101
        System.out.println(addBinary("1111","1111")); // 11110
    }
    private static String addBinary(String a, String b){

        String smaller = a.length() > b.length() ? b : a;
        String bigger = a.length() > b.length() ? a:b;
        int carryBit=0;
        final int smallerLength = smaller.length();
        final int biggerLength = bigger.length();

        StringBuilder builder  = new StringBuilder();

        int i = smallerLength-1,j=biggerLength-1;
        while ( i>=0 && j>=0){

            int aa = smaller.charAt(i)-'0';
            int bb = bigger.charAt(j)-'0';
            builder.append(carryBit^aa^bb);
            carryBit = ((carryBit&aa)==1) || ((carryBit&bb)==1) || ((aa&bb)==1) ? 1 : 0;



            i--;j--;
        }

        while (j-->=0){


            int bb = bigger.charAt(j)-'0';
            builder.append(carryBit^bb);
            carryBit = ((carryBit&bb)==1) ? 1 : 0;
            j--;

        }
        if(carryBit>0){
            builder.append(carryBit);
        }

        return  builder.reverse().toString();






    }



}


class Utility{

    public static void printBinaryForm(int number){

        int desiredLength = 32;

        // Convert integer to binary string with leading zeros
        String binaryString = String.format("%" + desiredLength + "s", Integer.toBinaryString(number)).replace(' ', '0');

        // Print the binary representation
        System.out.println("Binary representation of " + number + ": " + binaryString);
    }

}
