package rocks.pizzaandcoffee.yotsuba.attachment;

import org.json.JSONException;
import org.json.JSONObject;

class Flash extends File {
    private final String tag;

    Flash(JSONObject json) throws JSONException {
        super(json);
        this.tag = json.getString("tag");
    }

    public String getTag() {
        return tag;
    }
}
