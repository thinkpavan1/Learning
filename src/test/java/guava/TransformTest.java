package guava;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TransformTest {
    @Test
    public void whenTransformedWithIterables_thenTransformed() {
        // transform to length of strings
        List<String> names = Lists.newArrayList ( "John", "Jane", "Adam", "Tom" );

        Function<String, Integer> TO_LENGTH_OF_STRING = new Function<String, Integer> ( ) {
            @Override
            public Integer apply(String input) {
                return input.length ( );
            }
        };

        Iterable<Integer> stringLength = Iterables.transform ( names, TO_LENGTH_OF_STRING );
        assertThat ( stringLength, contains ( 4, 4, 4, 3 ) );
    }

    @Test
    public void whenTransformedWithCollections2_thenTransformed() {
        List<String> names = Lists.newArrayList ( "John", "Jane", "Adam", "Tom" );

        Collection<Integer> result = Collections2.transform ( names, new Function<String, Integer> ( ) {
            @Override
            public Integer apply(String input) {
                return input.length ( );
            }
        } );
        assertEquals ( 4, result.size ( ) );
        assertThat ( result, contains ( 4, 4, 4, 3 ) );

        result.remove ( 3 );
        assertEquals ( 3, result.size ( ) );

    }

    @Test
    public void whenCreatingFunctionFromPredication_thenCorrect() {
        List<String> names = Lists.newArrayList ( "John", "Jane", "Adam", "Tom" );

        Function CONTAINING_J = Functions.forPredicate ( Predicates.containsPattern ( "J" ) );
        Collection<Boolean> result = Collections2.transform ( names, CONTAINING_J );

        assertThat ( result, contains ( true, true, false, false ) );
        assertEquals ( 4, result.size ( ) );
    }

    @Test
    public void whenTransformingUsingComposedFunction_thenTransformed() {
        List<String> names = Lists.newArrayList ( "John", "Jane", "Adam", "Tom" );

        Function stringLength = new Function<String, Integer> ( ) {
            @Override
            public Integer apply(String input) {
                return input.length ( );
            }
        };

        Function isEven = new Function<Integer, Boolean> ( ) {
            @Override
            public Boolean apply(Integer input) {
                return input % 2 == 0;
            }
        };

        Collection<Boolean> isEvent = Collections2.transform ( names, Functions.compose ( isEven, stringLength ) );
        assertThat ( isEvent, contains ( true, true, true, false ) );
    }

    @Test
    public void whenFilteringAndTransformingCollections_thenCorrect(){
        List<String> names = Lists.newArrayList ( "John", "Jane", "Adam", "Tom" );
        Predicate<String> START_WITH_T_OR_A = new Predicate<String> ( ) {
            @Override
            public boolean apply(String input) {
                return input.startsWith ( "T" )|| input.startsWith ( "A" );
            }
        };

        Function<String,Integer> STR_LENGTH = new Function<String, Integer> ( ) {
            @Override
            public Integer apply(String input) {
                return input.length ();
            }
        };

        Collection<Integer> results = FluentIterable.from ( names )
                                                    .filter ( START_WITH_T_OR_A )
                                                    .transform ( STR_LENGTH )
                                                    .toList();

        assertEquals ( 2, results.size () );
        assertThat( results, containsInAnyOrder ( 4,3 ));
    }
}
