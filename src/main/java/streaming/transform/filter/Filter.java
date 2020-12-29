package streaming.transform.filter;

import streaming.transform.Transform;

import java.util.function.Predicate;

public class Filter<T> implements Transform<T, T> {

    Predicate<T> predicate;


    @Override
    public T transform(T item) {
        boolean test = predicate.test(item);
        if (test) {
            return item;
        } else {
            System.out.println("ignore " + item);
            return null;
        }
    }

    public void by(Predicate<T> predicate) {
        this.predicate = predicate;
    }
}
