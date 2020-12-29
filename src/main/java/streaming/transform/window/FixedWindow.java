package streaming.transform.window;

import java.util.ArrayList;
import java.util.Collection;

public class FixedWindow<T> implements Window<T> {

    public Collection<T> collection = new ArrayList<>();
    Integer size;

    public FixedWindow(Integer size) {
        if (size == null) {
            throw new RuntimeException("Size must be specified for fixed window");
        }
        this.size = size;
    }


    @Override
    public Collection<T> transform(T element) {
        if (collection.size() + 1 == size) {
            collection.add(element);
            Collection<T> newCollection = collection;
            collection = new ArrayList<>();
            return newCollection;
        } else {
            collection.add(element);
        }
        return null;
    }


}
