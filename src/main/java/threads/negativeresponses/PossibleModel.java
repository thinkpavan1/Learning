package threads.negativeresponses;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class PossibleModel {
    private String modelName;
    private String modelType;
    private int outStandingResponses;
    private Future<Integer>  futureOutstandingResponses;

    public PossibleModel(String modelName, String modelType, Future<Integer> futureOutstandingResponses) {
        this.modelName = modelName;
        this.modelType = modelType;
        this.futureOutstandingResponses = futureOutstandingResponses;
    }

    public String getModelName() {
        return modelName;
    }

    public String getModelType() {
        return modelType;
    }

    public int getOutStandingResponses() {
        int retValue = 0;
        try {
            retValue = futureOutstandingResponses.get ();
        } catch (InterruptedException e) {
            e.printStackTrace ( );
        } catch (ExecutionException e) {
            e.printStackTrace ( );
        }
        return retValue;
    }

}
