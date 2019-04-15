package rocks.pizzaandcoffee.yotsuba.channel4.service;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DefaultChannel4Service implements Channel4Service {
    private String url = "https://a.4cdn.org/";

    @Override
    public JSONObject getBoards() {
        try {
            URL boardsUrl = new URL(this.url + "boards.json");
            String jsonString = getJsonString(boardsUrl);
            return new JSONObject(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public JSONArray getPages(String board) {
        String urlString =  new StringBuilder(this.url).append(board).append("/threads.json").toString();
        try {
            URL url = new URL(urlString);
            String jsonString = getJsonString(url);
            return new JSONArray(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public JSONObject getThread(String board, int postNumber) {
        String urlString =  new StringBuilder("http://a.4cdn.org/")
               .append(board)
               .append("/thread/")
               .append(postNumber)
               .append(".json")
               .toString();
        try {
           URL url = new URL(urlString);
           String jsonString = getJsonString(url);
           return new JSONObject(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static String getJsonString(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setReadTimeout(10000 /* milliseconds */ );
        urlConnection.setConnectTimeout(15000 /* milliseconds */ );
        urlConnection.setDoOutput(true);
        urlConnection.connect();

        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }
        br.close();

        return sb.toString();
    }
}
