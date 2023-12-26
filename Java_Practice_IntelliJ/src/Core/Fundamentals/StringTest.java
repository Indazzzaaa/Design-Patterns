package Core.Fundamentals;

public class StringTest {

    public static void show(){
        System.out.println("String in java is object type and immutable.");
        String name = "Sumant Patel";
        System.out.printf("Name : %s , length : %d\n",name,name.length());

        System.out.print("Iterating over string: ");
        for(int i=0;i<name.length();i++){
            System.out.print(name.charAt(i));
        }
        System.out.println();

//        comparing strings.
        String s1 = "ab";
        String s2 = "aa";
        System.out.println(s1.equals(s2));
        System.out.println(s1.compareTo(s2)); // return 0 ,-1,1

// Searching string
        String longString = "Hello this is sumant patel";
        System.out.println(longString.indexOf("sumant")); // index or -1


    }
}
