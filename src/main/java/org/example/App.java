package org.example;

import java.util.function.*;
import java.util.stream.IntStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        if (args.length == 0) return;
        else {
            int n = Integer.parseInt(args[0]);
            int fact = IntStream.range(1, n).reduce(1, (i, i1) -> i*i1);
            int[] fibo = IntStream.range(1, n).collect(
                    (Supplier<int[]>) () -> {
                        int[] arr = new int[2];
                        arr[1] = 1;
                        return arr;
                    },
                    (ObjIntConsumer<int[]>) (ints, i) -> {
                        var a = ints[0];
                        var b = ints[1];
                        ints[0] = b;
                        ints[1] = a+b;
                    },
                    (ints, ints2) -> {}
            );
            System.out.println("El factorial de " + n + " es " + fact +"." );
            System.out.println("El número fibonacci " + n + "º es " + fibo[1] +"." );
        }
    }
}
