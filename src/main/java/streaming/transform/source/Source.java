package streaming.transform.source;

import java.util.concurrent.BlockingQueue;

public interface Source<INPUT> {

    void read(BlockingQueue<INPUT> queue);
}
