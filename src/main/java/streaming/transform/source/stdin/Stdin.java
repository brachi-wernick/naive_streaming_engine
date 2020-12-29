package streaming.transform.source.stdin;

import streaming.transform.source.Source;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class Stdin<T> implements Source<T> {

    Scanner scanner = new Scanner(System.in);


    @Override
    public void read(BlockingQueue<T> queue) {
        while (scanner.hasNext()) {
            String input = scanner.next();
            T element = cast(input);

            if (element != null) {
                try {
                    System.out.println(">" + element);
                    queue.put(element);
                } catch (InterruptedException e) {
                    throw new RuntimeException();
                }
            }
        }
    }


    abstract T cast(String input);
}
