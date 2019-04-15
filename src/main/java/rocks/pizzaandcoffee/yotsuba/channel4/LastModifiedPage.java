package rocks.pizzaandcoffee.yotsuba.channel4;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class LastModifiedPage {
    private final String board;
    private final Integer page;
    private final ArrayList<LastModifiedThread> threads;

    public LastModifiedPage(JSONObject json, String board) throws JSONException {
        this.board = board;
        this.page = json.getInt("page");
        this.threads = new ArrayList<LastModifiedThread>();
        JSONArray array = json.getJSONArray("threads");

        for (int i = 0; i < array.length(); i++) {
            this.threads.add(new LastModifiedThread(array.getJSONObject(i), this.board));
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
                boardArray.add(new LastModifiedPage(jsonArray.optJSONObject(i), board));
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
        return getPages(board.getBoardCode());
    }

    public Integer getPage() {
        return page;
    }

    public ArrayList<LastModifiedThread> getThreads() {
        return threads;
    }
}
