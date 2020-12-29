package streaming.transform.source.stdin;

import org.apache.commons.lang3.math.NumberUtils;

public class IntegerStdin extends Stdin<Integer>{

    @Override
    Integer cast(String input) {
        if(NumberUtils.isParsable(input)){
            return Integer.parseInt(input);
        }
        else {
            System.err.println("Value "+input+" is not parsable, accept only integer values");
            return null;
        }
    }
}
