package Core.Advanced.Generics.Functionalnterface;

import java.util.function.BinaryOperator;
import java.util.function.Function;

public class FunctionalTest {
    public static void test(){

        BinaryOperator<Integer> add = (a,b)-> a+b;
        Function<Integer,Integer> square = a->a*a;
        var result = add.andThen(square).apply(5,10);
        System.out.println(result);



    }
}
