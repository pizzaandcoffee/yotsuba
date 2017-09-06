package rocks.pizzaandcoffee.yotsuba;

import org.json.JSONException;
import org.json.JSONObject;

public class LasModifiedThread {
    private final Integer number;
    private final Integer lastModified;

    public LasModifiedThread(JSONObject json) throws JSONException {
        this.number = json.getInt("no");
        this.lastModified = json.getInt("last_modified");
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getLastModified() {
        return lastModified;
    }
}
