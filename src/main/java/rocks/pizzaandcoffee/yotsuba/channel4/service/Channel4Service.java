package rocks.pizzaandcoffee.yotsuba.channel4.service;

import org.json.JSONArray;
import org.json.JSONObject;

public interface Channel4Service {
    JSONObject getBoards();
    JSONArray getPages(String board);
    JSONObject getThread(String board, int postNumber);
}
