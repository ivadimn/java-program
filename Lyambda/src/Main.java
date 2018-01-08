import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Runnable noArgs = () -> System.out.println("Lambda without arguments");
        noArgs.run();

        Predicate<Integer> p = x -> x > 10;
        System.out.println(p.test(12));
        System.out.println(p.test(8));

        Function<Integer, Integer> inc = x -> x + 1;

    }
}
