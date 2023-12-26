package Core.Advanced.Generics.Functionalnterface;

import java.util.function.Supplier;

public class SupplierTest {

    public static void test(){

        Supplier<Double>  getRandom = Math::random;

        for(int i=0;i<10;i++) System.out.println(getRandom.get());



    }



}
