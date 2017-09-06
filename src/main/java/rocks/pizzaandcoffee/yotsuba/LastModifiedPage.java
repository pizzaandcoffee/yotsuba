package rocks.pizzaandcoffee.yotsuba;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class LastModifiedPage {
    private final Integer page;
    private final ArrayList<LasModifiedThread> threads;

    public LastModifiedPage(JSONObject json) throws JSONException {
        this.page = json.getInt("page");
        this.threads = new ArrayList<LasModifiedThread>();
        JSONArray array = json.getJSONArray("threads");

        for (int i = 0; i < array.length(); i++) {
            this.threads.add(new LasModifiedThread(array.getJSONObject(i)));
        }
    }

    public static ArrayList<LastModifiedPage> getPages(String board) {
        ArrayList<LastModifiedPage> boardArray = new ArrayList<LastModifiedPage>();

        String urlString =  new StringBuilder("http://a.4cdn.org/").append(board).append("/threads.json").toString();

        try {
            URL url = new URL(urlString);
            String jsonString = Util.getJsonString(url);
            JSONArray jsonArray = new JSONArray(jsonString);

            for (int i = 0; i < jsonArray.length(); i++) {
                boardArray.add(new LastModifiedPage(jsonArray.optJSONObject(i)));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return boardArray;
    }


    public static ArrayList<LastModifiedPage> getPages(Board board) {
        return LastModifiedPage.getPages(board.getBoardCode());
    }

    public Integer getPage() {
        return page;
    }

    public ArrayList<LasModifiedThread> getThreads() {
        return threads;
    }
}
