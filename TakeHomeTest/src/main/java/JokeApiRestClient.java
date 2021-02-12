import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class JokeApiRestClient {

    // HTTP Get request
    public CloseableHttpResponse getRequest(String url) throws IOException {
        //HttpClient object created through createDefault() method of httpClient class
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //HttpGet request which retrieves the json response of the given URI
        HttpGet httpGet = new HttpGet(url);
        //Execute the get request and it will return a json response object
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);
        return closeableHttpResponse;
    }

}
