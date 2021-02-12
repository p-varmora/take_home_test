import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class APITest {

    /*
Test 1 - Validate that the returned Joke is of type "programming"
step : -
1. Hit the Get request through jokeApiRestClient; It will return the response in HttpResponse object
2. HttpResponse object storing in responseString
3. Parsed JSON response into a JSONArray
4. Go through the JSON ARRAY and save JSON object in a hash-map
5. Parsed JSON ARRAY into JSON object to produce map-like object
6. Build the hash-map with "type" and "programming"
7. Validate hash-map key "type" has a value "programming"

Test 2 - Validate that 10 jokes are returned
step : -
1. Hit the Get request through jokeApiRestClient; It will return the response in HttpResponse object
2. HttpResponse object storing in responseString
3. Parsed JSON response into a JSONArray
4. Create counter for jokes count
5. Go through the JSON ARRAY and count "punchline" in each json object
6. Validate that json object has 10 "punchline" key

Test 3 - Validate that all jokes are of type "programming"
step : -
1. Hit the Get request through jokeApiRestClient; It will return the response in HttpResponse object
2. HttpResponse object storing in responseString
3. Parsed JSON response into a JSONArray
4. Go through the JSON ARRAY
5. Validate that each json object-joke has type of "programming"
   */

    // jokeApiRestClient object created
    JokeApiRestClient jokeApiRestClient = new JokeApiRestClient();

    private static String jokeAPI_random = "https://official-joke-api.appspot.com/jokes/programming/random";
    private static String jokeAPI_ten = "https://official-joke-api.appspot.com/jokes/programming/ten";


    @Test
    public void validate_returnedJoketype_programming() throws IOException {
        //Hit the Get request through jokeApiRestClient; It will return the response in HttpResponse object
        CloseableHttpResponse closebaleHttpResponse = jokeApiRestClient.getRequest(jokeAPI_random);
        //HttpResponse object storing in responseString
        String responseString = EntityUtils.toString(closebaleHttpResponse.getEntity(), "UTF-8");
        //parsed HttpResponse object into a JSONArray
        JSONArray jsonArray = new JSONArray(responseString);
        Map<String, String> jsonResponseMap = new HashMap<String, String>();
        //go through the JSON ARRAY and save JSON object in a hash-map
        for (int i = 0; i < jsonArray.length(); i++) {
            //parsed JSON ARRAY into JSON object to produce map-like object
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            jsonResponseMap.put("type", jsonObject.getString("type"));
        }
        // Validate that the returned Joke is of type "programming"
        Assert.assertEquals("programming", jsonResponseMap.get("type"));
    }

    @Test
    public void validate_tenJokes_returned() throws IOException {
        //Hit the Get request through jokeApiRestClient; It will return the response in HttpResponse object
        CloseableHttpResponse closebaleHttpResponse = jokeApiRestClient.getRequest(jokeAPI_ten);
        //HttpResponse object storing in responseString
        String responseString = EntityUtils.toString(closebaleHttpResponse.getEntity(), "UTF-8");
        //parsed HttpResponse object into a JSONArray
        JSONArray jsonArray = new JSONArray(responseString);
        //created counter for jokes count
        int jokesCount = 0;
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            jsonObject.getString("punchline");
            jokesCount++;
        }
        // Validate that 10 jokes are returned
        Assert.assertEquals(10, jokesCount);
    }

    @Test
    public void validate_allJokes_typeProgramming() throws IOException {
        //Hit the Get request through jokeApiRestClient; It will return the response in HttpResponse object
        CloseableHttpResponse closebaleHttpResponse = jokeApiRestClient.getRequest(jokeAPI_ten);
        //HttpResponse object storing in responseString
        String responseString = EntityUtils.toString(closebaleHttpResponse.getEntity(), "UTF-8");
        //parsed HttpResponse object into a JSONArray
        JSONArray jsonArray = new JSONArray(responseString);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            //Validate that all jokes are of type "programming
            Assert.assertEquals("programming", jsonObject.getString("type"));
        }
    }
}
