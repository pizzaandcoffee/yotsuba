package rocks.pizzaandcoffee.yotsuba.channel4;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rocks.pizzaandcoffee.yotsuba.channel4.service.DefaultChannel4Service;
import rocks.pizzaandcoffee.yotsuba.channel4.service.Channel4Service;

import java.util.ArrayList;

public class LastModifiedPage {
    private final String board;
    private final Integer page;
    private final ArrayList<LastModifiedThread> threads;

    public LastModifiedPage(JSONObject json, String board) throws JSONException {
        this.board = board;
        this.page = json.getInt("page");
        this.threads = new ArrayList<>();
        JSONArray array = json.getJSONArray("threads");

        for (int i = 0; i < array.length(); i++) {
            this.threads.add(new LastModifiedThread(array.getJSONObject(i), this.board));
        }
    }

    public static ArrayList<LastModifiedPage> getPages(String board) {
        return getPages(board, new DefaultChannel4Service());
    }

    public static ArrayList<LastModifiedPage> getPages(String board, Channel4Service service) {
        ArrayList<LastModifiedPage> boardArray = new ArrayList<LastModifiedPage>();

        try {
            JSONArray jsonArray = service.getPages(board);

            for (int i = 0; i < jsonArray.length(); i++) {
                boardArray.add(new LastModifiedPage(jsonArray.optJSONObject(i), board));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return boardArray;
    }


    public static ArrayList<LastModifiedPage> getPages(Board board) {
        return getPages(board.getBoardCode());
    }

    public static ArrayList<LastModifiedPage> getPages(Board board, Channel4Service service) {
        return getPages(board.getBoardCode(), service);
    }

    public Integer getPage() {
        return page;
    }

    public ArrayList<LastModifiedThread> getThreads() {
        return threads;
    }
}
