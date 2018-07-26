package guava;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

import static com.google.common.base.Predicates.containsPattern;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;


public class FilterTest {
    @Test
    public void whenFilterWithIterables_thenFiltered() {
        List<String> names = Lists.newArrayList ( "John", "Jane", "Adam", "Tom" );
        Iterable<String> result = Iterables.filter ( names, containsPattern ( "a" ) );
        assertThat ( result, containsInAnyOrder ( "Jane", "Adam" ) );
    }


    @Test
    public void whenFilterWithCollections2_thenFiltered() {
        List<String> names = Lists.newArrayList ( "John", "Jane", "Adam", "Tom" );
        Collection<String> result = Collections2.filter ( names, containsPattern ( "a" ) );

        assertThat ( result, containsInAnyOrder ( "Jane", "Adam" ) );
        assertEquals ( 2, result.size ( ) );

        result.add ( "aast" );
        assertEquals ( 5, names.size ( ) );
    }

    @Test
    public void whenFileterUsingMultiplePredicates_thenFileterd() {
        List<String> names = Lists.newArrayList ( "John", "Jane", "Adam", "Tom" );
        Collection<String> result = Collections2.filter ( names, Predicates.or ( containsPattern ( "J" ), Predicates.not ( containsPattern ( "a" ) ) ) );
        assertEquals(3, result.size());
        assertThat(result, containsInAnyOrder("John", "Jane", "Tom"));
    }

    @Test
    public void whenFileterCollectionWithCustomPredicate_thenFiletered(){
        List<String> names = Lists.newArrayList ( "John", "Jane", "Adam", "Tom" );

        Predicate<String> CHECK_STARTS_WITH_A_OR_J = new Predicate<String> ( ) {
            @Override
            public boolean apply(String input) {
                return input.startsWith ( "A" ) || input.startsWith ( "J" );
            }
        };

        Collection<String> result = Collections2.filter ( names, CHECK_STARTS_WITH_A_OR_J );
        assertThat( result, containsInAnyOrder ( "John","Jane","Adam" ));
    }

    @Test
    public void whenRemoveNullFromCollection_thenRemoved(){
        List<String> names = Lists.newArrayList ( "John", "Jane", "Adam", "Tom", null );
        Collection<String> result = Collections2.filter ( names, Predicates.notNull () );

        assertEquals ( 4, result.size () );
        assertThat(result, containsInAnyOrder ( "John", "Jane", "Adam", "Tom" ));
    }

    @Test
    public void whenCheckingIfAllElementsMatchACondition_thenCorrect(){
        List<String> names = Lists.newArrayList ( "John", "Jane", "Adam", "Tom" );

        boolean result = Iterables.all ( names, Predicates.containsPattern ( "n|m" ) );
        assertTrue ( result );

        result = Iterables.all(names, Predicates.containsPattern ( "a" ));
        assertFalse(result);
    }

}