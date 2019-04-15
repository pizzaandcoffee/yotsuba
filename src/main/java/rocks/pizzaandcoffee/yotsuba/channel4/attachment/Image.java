package rocks.pizzaandcoffee.yotsuba.channel4.attachment;

import org.json.JSONException;
import org.json.JSONObject;

class Image extends File {
    Image(JSONObject json) throws JSONException {
        super(json);
    }
}
