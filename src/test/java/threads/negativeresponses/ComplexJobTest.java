package threads.negativeresponses;


import com.google.common.collect.Lists;
import org.junit.Test;
import threads.negativeresponses.ComplexJob;

import java.util.List;
import java.util.concurrent.ExecutionException;


public class ComplexJobTest {

    @Test
    public void getDetailsLazilyFrom() throws ExecutionException {
        List<String> names = Lists.newArrayList ( "John", "Jane", "Adam", "Tom" );
        ComplexJob job = new ComplexJob ();
        job.getDetailsLazilyFrom ( names );
    }
}