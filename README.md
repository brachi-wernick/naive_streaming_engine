# Naive Streaming Engine

Exercise to implement naive streaming engine.

Not support multi threading or multi processors (because it is just an exercise :smile: ).

### Source
To read from any Source, implement the `streaming.transform.source.Source` Class.

The communication between transformers in the stream performed by blocking queue.

From one side reader set values to the queue, and from the other side transformer consumes values from it.    

### Transform

To implement Transform, implemnt the class `streaming.transform.Transform`.

It gives the ability to perform any logic on any given value.

It need to return a value or null, the new Value can be in any type, can be different from the input type.

### Window

To implement Windowm, implement the `streaming.transform.window.Window` class.

Window is also a transformer, and extends this interface, it gets a value and returns a collection of values, since its purpose is to aggregate values for further transformation.


### Example:
```java
 new Stream<Integer, Integer>()
                .read(new IntegerStdin())
                .apply(Filters.<Integer>By(i -> i > 0))
                .apply(new FixedWindow<>(2))
                .apply(new Sum())
                .apply(new FixedWindow<>(3))
                .apply(new MedianTransformer())
                .apply(new Stdout<>());
```

### Build
1. Run `mvn clean install `
2. Run  `java -jar target/naive-steraming-engine-1.0-SNAPSHOT.jar`
3. Type any int value to the console.
4. Expect some results (sum of any 2 items, median of any 3 sum values)
5. This program never ends, type ctrl+c to exit.# naive_streaming_engine
