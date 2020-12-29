package streaming;

import streaming.transform.fold.Median;
import streaming.transform.fold.Sum;
import streaming.transform.sink.Stdout;
import streaming.transform.source.stdin.IntegerStdin;
import streaming.transform.window.FixedWindow;
import streaming.utils.Filters;



public class MyMainStream {

    public static void main(String[] args) {


        new Stream<Integer, Integer>()
                .read(new IntegerStdin())
                .apply(Filters.<Integer>By(i -> i > 0))
                .apply(new FixedWindow<>(2))
                .apply(new Sum())
                .apply(new FixedWindow<>(3))
                .apply(new Median())
                .apply(new Stdout<>());


    }

}
