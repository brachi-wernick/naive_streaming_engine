package streaming.transform;

public interface Transform<INPUT, OUTPUT> {

    OUTPUT transform(INPUT stream);
}
