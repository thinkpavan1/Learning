package threads;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.Future;

public class FunctionConcurrencyTest {

    public void testFunction(){
        List<String> names = Lists.newArrayList ("Welcome","Test");
//        Iterables.transform ( names, )
    }

    private Future<Integer> TO_LENGTH(Iterable<String> inputs){
        Future<Integer> retValue = null;

        return retValue;
    }
}
