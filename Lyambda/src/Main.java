import ui.MainFrame;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static String[] places = {"Moscow", "London", "Moscow", "London", "Madrid", "London"};
    public static List<String> allArtists = new ArrayList<>(Arrays.asList(places));
    public static void main(String[] args) {
        Runnable noArgs = () -> System.out.println("Lambda without arguments");
        noArgs.run();

        Predicate<Integer> p = x -> x > 10;
        System.out.println(p.test(12));
        System.out.println(p.test(8));

        Function<Integer, Integer> inc = x -> x + 1;

        BinaryOperator<Integer> bop = (x, y) -> x + y;
        System.out.println(bop.apply(3, 7));
        BinaryOperator<String> concat = (s1, s2)-> s1.concat(s2);
        System.out.println(concat.apply("Hello ", "world"));

        //EventQueue.invokeLater(()->new MainFrame());
        //Supplier<DateFormatter> dateSupplier = () -> new DateFormatter(new SimpleDateFormat("dd-MMM-yyyy"));

        //ThreadLocal<DateFormatter>  dateFormatter = ThreadLocal.withInitial(dateSupplier);

        System.out.println(allArtists.stream().filter(artist -> artist.equals("London")).count());
        //Stream<String> f = allArtists.stream().filter(artist -> artist.equals("London"));
        long count = allArtists.stream().filter(artist -> {
            System.out.println(artist);
            return artist.equals("London");
        }).count();

        List<String> ll = allArtists.stream().filter(artist -> artist.equals("London")).collect(Collectors.toList());
        System.out.println(ll.size());
        List<String> upper = Stream.of(places).map(str -> str.toUpperCase()).collect(Collectors.toList());

        upper.forEach(str -> System.out.println(str));

        Integer[] digs = {2, 5, 10, 56, 0, -9, -67};
        int m = Stream.of(digs).max(Comparator.comparing(d -> d)).get();
        System.out.println(m);

    }

    interface IntPred {
        boolean test(Integer value);
    }

    public static void check(Predicate<Integer> predicate) {
        System.out.println(predicate.test(10));
    }

    public static void check(IntPred predicate) {
        System.out.println(predicate.test(10));
    }
}
