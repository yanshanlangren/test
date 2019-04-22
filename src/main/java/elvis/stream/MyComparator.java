package elvis.stream;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class MyComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if(o1 instanceof String){
            System.out.println("String");
        }

        if(o1 instanceof User){
            System.out.println("User");
        }
        System.out.println("compare: o1 = "+o1+", o2 = "+o2);
        return 0;
    }

    @Override
    public Comparator reversed() {
        System.out.println("reversed");
        return null;
    }

    @Override
    public Comparator thenComparing(Comparator other) {
        System.out.println("thenComparing");
        return null;
    }

    @Override
    public Comparator thenComparingInt(ToIntFunction keyExtractor) {
        System.out.println("thenComparingInt");
        return null;
    }

    @Override
    public Comparator thenComparingLong(ToLongFunction keyExtractor) {
        System.out.println("thenComparingLong");
        return null;
    }

    @Override
    public Comparator thenComparingDouble(ToDoubleFunction keyExtractor) {
        System.out.println("thenComparingDouble");
        return null;
    }

    @Override
    public Comparator thenComparing(Function keyExtractor) {
        System.out.println("thenComparing");
        return null;
    }

    @Override
    public Comparator thenComparing(Function keyExtractor, Comparator keyComparator) {
        System.out.println("thenComparing");
        return null;
    }
}
