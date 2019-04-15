package rocks.pizzaandcoffee.yotsuba.attachment;

import org.json.JSONException;
import org.json.JSONObject;

class Webm extends File {
    Webm(JSONObject json) throws JSONException {
        super(json);
    }
}
