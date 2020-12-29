package streaming.transform.sink;

import streaming.transform.Transform;

public class Stdout<T> implements Transform<T, T> {


    @Override
    public T transform(T stream) {
        System.out.println(stream);
        return stream;
    }
}
