import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UriTemplate;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.discovery.Discovery;
import com.google.api.services.discovery.model.JsonSchema;
import com.google.api.services.discovery.model.RestDescription;
import com.google.api.services.discovery.model.RestMethod;
import com.google.api.services.ml.v1.CloudMachineLearningEngine;
import com.google.api.services.ml.v1.model.GoogleCloudMlV1Job;
import com.google.api.services.storage.StorageScopes;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

/**
 * @author champ
 * @version $ 10/9/2018
 */
public class OnlinePredictionSample {

    private static final String jsonPath = "c:\\first-tensor-flow-project-1a7f9fce0c3b.json";
    // private static final String input = "C:\\Work\\GitHub\\Learning\\googleclould\\src\\main\\resources\\test.json";
      private static final String input ="C:\\Work\\GitHub\\Learning\\googleclould\\src\\main\\resources\\nbm_preprocessed.json";

    static String projectId = "first-tensor-flow-project";
    static String modelId = "census";
    static String versionId = "NBM";
    static Discovery discovery;
    static JsonSchema param;
    static HttpTransport httpTransport = null;
    static  GoogleCredential credential = null;

    static {
        try {
            httpTransport = GoogleNetHttpTransport.newTrustedTransport();
            JacksonFactory jsonFactory = JacksonFactory.getDefaultInstance();
            discovery = new Discovery.Builder(httpTransport, jsonFactory, null).build();
            credential = GoogleCredential.getApplicationDefault();
            if (credential.createScopedRequired()) {
                credential = credential.createScoped(Collections.singleton(StorageScopes.CLOUD_PLATFORM));
            }
            param = new JsonSchema();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        singlePredition();
        //fromCloudMachineLeraningEngine();

    }

    private static void fromCloudMachineLeraningEngine() throws IOException {
        CloudMachineLearningEngine engine = new CloudMachineLearningEngine(credential.getTransport(), credential.getJsonFactory(), credential.getRequestInitializer());
        CloudMachineLearningEngine.Projects.Jobs job = engine.projects().jobs();

        GoogleCloudMlV1Job jobContent = new GoogleCloudMlV1Job();
        jobContent.set("jobId", "myjob");
        jobContent.set("input_paths", "gs://path/to/your/input/data/*");
        CloudMachineLearningEngine.Projects.Jobs.Create request = engine.projects().jobs().create("parent", jobContent);

        GoogleCloudMlV1Job response = request.execute();
    }

    private static void listAllJobs() throws Exception{
        RestDescription api = discovery.apis().getRest("ml", "v1").execute();
        RestMethod method = api.getResources().get("projects").getMethods().get("job");

    }


    private static void singlePredition() throws GeneralSecurityException, IOException {
        RestDescription api = discovery.apis().getRest("ml", "v1").execute();
        RestMethod method = api.getResources().get("projects").getMethods().get("predict");
        System.out.println(String.format("projects/%s/models/%s/versions/%s", projectId, modelId, versionId));
        param.set("name", String.format("projects/%s/models/%s/versions/%s", projectId, modelId, versionId));

        GenericUrl url = new GenericUrl(UriTemplate.expand(api.getBaseUrl() + method.getPath(), param, true));
        System.out.println(url);

        String contentType = "application/json";
        File requestBodyFile = new File(input);
        HttpContent content = new FileContent(contentType, requestBodyFile);
        System.out.println("Content Length = " + content.getLength());

        HttpRequestFactory requestFactory = httpTransport.createRequestFactory(credential);
        HttpRequest request = requestFactory.buildRequest(method.getHttpMethod(), url, content);

        String response = request.execute().parseAsString();
        System.out.println(response);
    }
}