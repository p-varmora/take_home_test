# takeHomeTest
We need to verify that when the users of our API want jokes of a specific type they get it!  We are just about to start advertising our "Programming" jokes…

# Please create a standalone executable (code) in the language of your choice that executes the following three tests:

# Using https://official-joke-api.appspot.com/jokes/programming/random
1. Validate that the returned Joke is of type "programming"

Steps :-
1. Hit the Get request through jokeApiRestClient; It will return the response in HttpResponse object
2. HttpResponse object storing in responseString
3. Parsed JSON response into a JSONArray
4. Go through the JSON ARRAY and save JSON object in a hash-map
5. Parsed JSON ARRAY into JSON object to produce map-like object
6. Build the hash-map with "type" and "programming"
7. Validate hash-map key "type" has a value "programming"

# Using https://official-joke-api.appspot.com/jokes/programming/ten
1. Validate that 10 jokes are returned

steps : -
1. Hit the Get request through jokeApiRestClient; It will return the response in HttpResponse object
2. HttpResponse object storing in responseString
3. Parsed JSON response into a JSONArray
4. Create counter for jokes count
5. Go through the JSON ARRAY and count "punchline" in each json object
6. Validate that json object has 10 "punchline" key

2. Validate that all jokes are of type "programming"

steps : -
1. Hit the Get request through jokeApiRestClient; It will return the response in HttpResponse object
2. HttpResponse object storing in responseString
3. Parsed JSON response into a JSONArray
4. Go through the JSON ARRAY
5. Validate that each json object-joke has type of "programming"
