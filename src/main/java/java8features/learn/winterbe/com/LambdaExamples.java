package java8features.learn.winterbe.com;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExamples {
    private final List<String> names = Arrays.asList ( "peter","anan","mike","xenia");

    private void sortListOfStrings(){

        Collections.sort ( names, new Comparator<String> ( ) {
            @Override
            public int compare(String string1, String string2) {
                return string1.compareTo ( string2 );
            }
        } );
        System.out.println ("sortListOfStrings () :"+ names );
    }

    private void sortListWithLambda(){
        Collections.sort ( names,(String string1,String string2)->{
            return string1.compareTo ( string2 );
        } );
        System.out.println ("sortListWithLambda () :"+ names );

        Collections.sort(names, (a,b)->(  b.compareTo ( a )));
        System.out.println ("sortListWithLambda Even shotter () :"+ names );

    }

    public static void main(String[] args) {
        LambdaExamples examples = new LambdaExamples ( );
        examples.sortListOfStrings ( );
        examples.sortListWithLambda ( );

    }
}
