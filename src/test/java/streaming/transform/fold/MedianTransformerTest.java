package streaming.transform.fold;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

class MedianTransformerTest {

    @Test
    public void testMedian_even(){
        MedianTransformer medianTransformer = new MedianTransformer();
        ArrayList<Integer> stream = new ArrayList<>();
        stream.add(10);
        stream.add(11);
        stream.add(12);
        stream.add(13);
        stream.add(14);
        stream.add(15);
        Double transform = medianTransformer.transform(stream);
        assertEquals(transform,12.5);
    }

    @Test
    public void testMedian_odd(){
        MedianTransformer medianTransformer = new MedianTransformer();
        ArrayList<Integer> stream = new ArrayList<>();
        stream.add(21);
        stream.add(25);
        stream.add(27);
        Double transform = medianTransformer.transform(stream);
        assertEquals(transform,25);
    }

    @Test
    public void testMedian_single_value(){
        MedianTransformer medianTransformer = new MedianTransformer();
        ArrayList<Integer> stream = new ArrayList<>();
        stream.add(21);
        Double transform = medianTransformer.transform(stream);
        assertEquals(transform,21);
    }

}