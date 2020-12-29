package streaming;

import streaming.transform.Transform;
import streaming.transform.source.Source;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Stream<INPUT, OUTPUT> {

    private BlockingQueue<INPUT> readQueue = new LinkedBlockingQueue<>();
    private BlockingQueue<OUTPUT> writeQueue = new LinkedBlockingQueue<>();
    private Transform<INPUT, OUTPUT> transform;

    private final Thread transformThread = new Thread(() -> {
        try {
            while (true) {
                INPUT take = readQueue.take();
                OUTPUT transformed = transform.transform(take);
                if (transformed != null) {
                    writeQueue.put(transformed);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
    });

    public Stream(BlockingQueue readQueue) {
        this.readQueue = readQueue;
    }

    public Stream() {
    }

    Stream<INPUT, OUTPUT> read(Source<INPUT> source) {

        Thread readThread = new Thread(() -> source.read(readQueue));
        readThread.start();
        return this;
    }

    Stream apply(Transform transform) {
        this.transform = transform;
        transformThread.start();
        return new Stream<>(writeQueue);

    }


}
