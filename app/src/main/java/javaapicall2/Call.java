package javaapicall2;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class Call {
    public static void main(String[] args) {
        apiCall();
    }

    public static void apiCall() {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/users");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream stream = connection.getInputStream();

            byte[] data = stream.readAllBytes();
            String dataStr = new String(data);
            System.out.println(dataStr);
            JSONArray jsonArr = new JSONArray(dataStr);
            String name = jsonArr.getJSONObject(0).getString("name");
            System.out.println(name);
        } catch(MalformedURLException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
