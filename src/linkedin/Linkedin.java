package linkedin;

import java.util.*;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Linkedin {

    public static void main(String[] args) {

        // Loop a Map
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        int result = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result += entry.getValue();
        }
        System.out.print(result);


        // Convert into a lambda expression
        Integer square = square(2);
        System.out.println(square);
        Function<Integer, Integer> function = x -> x * x;

        // Size of Map
        Map<String, Integer> instruments = new HashMap<>();
        instruments.put("guitar", 1200);
        instruments.put("cello", 3000);
        instruments.put("drum", 200);
        instruments.put("cello", 4500);
        System.out.println(instruments.size());

        // UnaryOperator to replaceAll in a List, return what receives
        List<String> dates = new ArrayList<>();
        dates.add("11/01/2024");
        dates.add("07/03/1998");
        dates.add("13/01/1998");

        UnaryOperator<String> replaceSlashes = date -> date.replace("/", "-");
        dates.replaceAll(replaceSlashes);

        System.out.println(dates);

        // when you pass an object reference as an argument to a method call, what gets pass?
        //  - a reference to a copy
        //  - the original reference
        //  - a copy of the reference -> ANSWER
        //  - the object itself


        //Iterate an ArrayList
        List<Berries> berries = new ArrayList<>();
        for (Berries berry : berries) {
        }

        for (Iterator<Berries> i = berries.iterator(); i.hasNext(); ) {
        }

        // Function in Map of Stream
        List<String> songTitles = Arrays.asList("humble", "element", "dna");
        Function<String, String> toUpperCase = (songTitle) -> songTitle.toUpperCase();
        songTitles.stream().map(toUpperCase).forEach(System.out::println);


        // Subclasses of an abstract class are created using the keyword ?
        // abstract
        // implements
        // extends -> ANSWER
        // interfaces
    }


    // Return String because of Function<Receive, Return>

    // In TS would be
    /*
        type MyType<T, R> = {
            (a: T): R
        }

        const lambda: MyType<number, string> = (a) => {
            return "hola this is the number " + a
        }

        function hola(a: number, b: MyType<number, string>) {
            return b(a);
        }

        console.log(hola(4, lambda));

     */

    public static String processFunction(Integer number, Function<Integer, String> lambda) {
        return lambda.apply(number);
    }

    public static int square(int x) {
        return x * x;
    }
}


// Enum definition
enum Cats {SPHYNX, SIAMESE, BENGAL}

// The result will be strawberry
class Berries {

    String berry = "blue";

    public static void main(String[] args) {
        new Berries().juicy("straw");
    }

    void juicy(String berry) {
        this.berry = "rasp";
        System.out.println(berry + "berry");
    }
}




