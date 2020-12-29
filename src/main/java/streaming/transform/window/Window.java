package streaming.transform.window;

import streaming.transform.Transform;

import java.util.Collection;

public interface Window<T> extends Transform<T, Collection<T>> {

}