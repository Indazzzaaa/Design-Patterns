package Core.Advanced.Generics.Functionalnterface;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {

    public static void test(){

        List<String> list = List.of("a","b","c");
        Consumer<String> print =  System.out::println;
        Consumer<String> printUpperCase = item -> System.out.println(item.toUpperCase());

//        print.accept -> printUpperCase.accept -> and for another similar type,
//        it will keep chaining until it find method that return void only instead of consumer.
        list.forEach(print.andThen(printUpperCase));


    }

}
