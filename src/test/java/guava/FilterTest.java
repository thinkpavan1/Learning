package guava;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertThat;


public class FilterTest {
    public static final List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom");

    @Test
    public void whenFilterWithIterables_thenFiltered(){
        Iterable<String> result = Iterables.filter ( names, Predicates.containsPattern ( "a" ) );
        assertThat(result, Matchers.containsInAnyOrder ( "Jane","Adam" ));
    }

}