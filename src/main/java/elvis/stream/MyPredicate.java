package elvis.stream;

import java.util.function.Predicate;

public class MyPredicate implements Predicate {
    @Override
    public boolean test(Object o) {
        System.out.println("test");
        if(o instanceof User){
            User u = (User) o;
            return u.getAge()>30;
        }
        return false;
    }

    @Override
    public Predicate and(Predicate other) {
        System.out.println("and");
        return null;
    }

    @Override
    public Predicate negate() {
        System.out.println("negate");
        return null;
    }

    @Override
    public Predicate or(Predicate other) {
        System.out.println("or");
        return null;
    }
}
