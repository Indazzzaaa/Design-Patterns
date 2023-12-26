package Core.Fundamentals;

public class Variables {
    public static void show(){

        byte minByte = Byte.MIN_VALUE;
        byte maxByte = Byte.MAX_VALUE;
        System.out.printf("Min Byte : %,d  Max Byte : %,d\n",minByte,maxByte); // comma will be added as a thousand separator

        short minShort = Short.MIN_VALUE;
        short maxShort = Short.MAX_VALUE;
        System.out.printf("Min Short : %,d Max Short: %,d\n", minShort,maxShort);

        int minInt =   Integer.MIN_VALUE;
        int maxInt = Integer.MAX_VALUE;
        System.out.printf("Min Int : %,d Max Int: %,d\n", minInt,maxInt);

        long minLong = Long.MIN_VALUE;
        long maxLong = Long.MAX_VALUE;
        System.out.printf("Min Long : %,d Max Long: %,d\n", minLong,maxLong);

        float minFloat = Float.MIN_VALUE;
        float maxFloat = Float.MAX_VALUE;
        System.out.printf("Min Float : %g Max Float: %g\n", minFloat,maxFloat);

        double minDouble = Double.MIN_VALUE;
        double maxDouble = Double.MAX_VALUE;
        System.out.printf("Min Double : %g Max Double: %g\n", minDouble,maxDouble);

        char minChar = Character.MIN_VALUE;
        char maxChar = Character.MAX_VALUE;
        System.out.printf("Min Char : %c Max Char: %c\n", minChar,maxChar);











    }
}
