package threads.negativeresponses;


import com.google.common.base.Function;
import com.google.common.collect.Maps;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ComplexJob {

    final Map<String, PossibleModel> stringFutureMap = Maps.newHashMap ( );
    final private DBObject dbObject;
    final private ExecutorService service = Executors.newFixedThreadPool ( 2 );

    public ComplexJob() {
        dbObject = new DBObject ( );
    }

    public void getDetailsLazilyFrom(final Iterable<String> factoryKeys) throws ExecutionException {
        System.out.println ( "In get details lazily from " );
        try {
            toPossibleModel ( factoryKeys.iterator ( ) );
            for (Map.Entry<String, PossibleModel> stringFutureEntry : stringFutureMap.entrySet ( )) {
                PossibleModel model = stringFutureEntry.getValue ( );
                System.out.println ( model.getModelName () +" length = "+model.getOutStandingResponses ());
            }
        } catch (InterruptedException e) {
            e.printStackTrace ( );
        }
        //Iterator<Integer> transform = Iterators.transform ( factoryKeys.iterator ( ), toOutStandingResponses ( ) );
        //System.out.println ( Iterators.size ( transform ) );
    }

    public void goOverTheIterator(final Iterator<String> factoryKeys) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool ( 4 );

        while (factoryKeys.hasNext ( )) {
            String name = factoryKeys.next ( );
            Future<Integer> future = service.submit ( () -> {
                System.out.println ( "Straing for " + name );
                Thread.sleep ( 1000 );
                System.out.println ( "Completed " + name );
                return name.length ( );
                    }
            );
            stringFutureMap.put ( name, new PossibleModel ( name, "Dummy",future ) );
        }
    }

    public void toPossibleModel(final Iterator<String> factoryKeys) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();

        while (factoryKeys.hasNext ( )) {
            String name = factoryKeys.next ( );
            Future<Integer> future = service.submit ( () -> {
                        System.out.println ( "Straing for " + name );
                        Thread.sleep ( 1000 );
                        System.out.println ( "Completed " + name );
                        return name.length ( );
                    }
            );
            stringFutureMap.put ( name, new PossibleModel ( name, "Dummy",future ) );
        }
    }

    private Function<String, Integer> toOutStandingResponses() {
        return new Function<String, Integer> ( ) {
            @Override
            public Integer apply(String s) {
                try {
                    Future<Integer> future = dbObject.getAsynLength ( s );
                    return future.get ( );
                    //int length = dbObject.getLength ( s );
                  /*Future<Integer> r =   service.submit ( ()->dbObject.getLength ( s ) );
                  return r.get();*/
                } catch (Exception e) {
                    e.printStackTrace ( );
                }
                return null;
            }
        };
    }
}
