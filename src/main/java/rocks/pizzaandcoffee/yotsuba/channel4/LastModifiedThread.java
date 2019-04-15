package rocks.pizzaandcoffee.yotsuba.channel4;

import org.json.JSONException;
import org.json.JSONObject;
import rocks.pizzaandcoffee.yotsuba.channel4.service.DefaultChannel4Service;
import rocks.pizzaandcoffee.yotsuba.channel4.service.Channel4Service;

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
        return getThread(new DefaultChannel4Service());
    }

    public Thread getThread(Channel4Service service) {
       try {
           JSONObject json = service.getThread(this.board, this.number);
           return new Thread(json, this.board);
       } catch (Exception e) {
           e.printStackTrace();
       }

       throw new IllegalStateException("something went terribly wrong!");
    }
}
