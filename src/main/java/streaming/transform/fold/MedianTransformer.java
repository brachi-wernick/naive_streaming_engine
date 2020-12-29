package streaming.transform.fold;

import streaming.transform.Transform;
import java.util.Collections;
import java.util.List;

public class MedianTransformer implements Transform<List<Integer>, Double> {

    @Override
    public Double transform(List<Integer> stream) {
        return getMedian(stream);
    }

    private Double getMedian(List<Integer> stream) {
        Collections.sort(stream);
        int middle = stream.size() / 2;
        Double medianValue ;
        if (stream.size() % 2 == 1) {
            medianValue = Double.valueOf(stream.get(middle));
        } else {
            medianValue = (stream.get(middle - 1) + stream.get(middle)) / 2.0;
        }
        return medianValue;
    }
}
