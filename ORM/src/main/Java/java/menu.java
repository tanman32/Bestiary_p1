import com.google.gson.JsonArray;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import jdk.nashorn.internal.parser.JSONParser;
import models.Dog;
import models.Entry;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class menu {

//    <packaging>jar</packaging>
//
//
//            *loads saved classes*
//
//    ORM makes HTTP request
//    API parses request and returns status depending on validation
//    APi sends json responses
//
//    ORM Gathers json and maps and saves classes
//    ORM then allows for additional request based on classes to be made

    public static <JSONArray, JSONObject> void main(String[] args) {

        try {

            URL url = new URL("http://localhost:8080/WebApp2/dog");

            //String URLtest = doHttpUrlConnectionAction(url);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Check if connect is made
            int responseCode = conn.getResponseCode();

            // 200 OK
            System.out.println(responseCode);

            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                Reader reader = null;
                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                System.out.println();

               // StringReader reader = new StringReader();
                Gson gson = new Gson();
                Dog d = gson.fromJson(reader, Dog.class);

                //List<Dog> d = (List<Dog>)
                System.out.println(d);
                //JSON simple library Setup with Maven is used to convert strings to JSON
                //JSONParser parse = new JSONParser();

                //JSONArray dataObject = (JSONArray) parse.parse(String.valueOf(informationString));

                //Get the first JSON object in the JSON array
                //System.out.println(dataObject.get(0));
                //JSONObject countryData = (JSONObject) dataObject.get(0);
                //System.out.println(countryData.get("woeid"));

            }
        } catch (JsonSyntaxException e )
        {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
