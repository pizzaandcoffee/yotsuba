package rocks.pizzaandcoffee.yotsuba;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;

public class LastModifiedThread {
    private final String board;
    private final Integer number;
    private final Integer lastModified;

    public LastModifiedThread(JSONObject json, String board) throws JSONException {
        this.board = board;
        this.number = json.getInt("no");
        this.lastModified = json.getInt("last_modified");
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getLastModified() {
        return lastModified;
    }

    public Thread getThread() {
       String urlString =  new StringBuilder("http://a.4cdn.org/")
               .append(this.board)
               .append("/thread/")
               .append(this.number)
               .append(".json")
               .toString();

       try {
           URL url = new URL(urlString);
           String jsonString = Util.getJsonString(url);
           JSONObject json = new JSONObject(jsonString);
           return new Thread(json, this.board);
       } catch (Exception e) {
           e.printStackTrace();
       }

       throw new IllegalStateException("something went terribly wrong!");
    }
}
