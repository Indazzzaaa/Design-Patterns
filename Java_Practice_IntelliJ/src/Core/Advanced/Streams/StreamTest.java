package Core.Advanced.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {


    public static void test(){
        infiniteStreams();

    }

    public static void createStream(){

        String[] arr = {"sumant","vishal","rahul"};

        Arrays.stream(arr)
                .map(s-> s.substring(0,1).toUpperCase()+s.substring(1))
                .map(s-> s.substring(0,s.length()-1) + s.substring(s.length()-1).toUpperCase())
                .forEach(System.out::println);




    }

    public static void infiniteStreams(){

        var ranomStream = Stream.generate(new Random():: nextInt);
        var stream = Stream.generate(Math::random);
       List<Integer> resultList=  stream
                .limit(10)
                .sorted()
                .map(d-> (int)(d*100))
                        .collect(Collectors.toList());

//                .forEach(System.out::println);

        IntStream.rangeClosed(1,10)
                .forEach(System.out::println);


        System.out.println("Print the Random Numbers");

        resultList.forEach(System.out::println);








    }
}
