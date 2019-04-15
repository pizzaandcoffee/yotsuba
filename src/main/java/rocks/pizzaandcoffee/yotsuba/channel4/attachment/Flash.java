package rocks.pizzaandcoffee.yotsuba.channel4.attachment;

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
