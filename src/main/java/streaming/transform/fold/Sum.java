package streaming.transform.fold;

import streaming.transform.Transform;

import java.util.Collection;

public class Sum implements Transform<Collection<Integer>,Integer> {

    @Override
    public Integer transform(Collection<Integer> stream) {
        return stream.stream().mapToInt(Integer::intValue).sum();
    }
}
