package streaming.utils;

import streaming.transform.filter.Filter;

import java.util.function.Predicate;

public class Filters {

    public static <T> Filter<T> By(Predicate<T> predicate){
        Filter<T> filter = new Filter<T>();
        filter.by(predicate);
        return filter;
    }
}
