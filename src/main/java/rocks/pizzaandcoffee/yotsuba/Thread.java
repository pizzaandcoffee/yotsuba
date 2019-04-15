package rocks.pizzaandcoffee.yotsuba;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Thread {
    private String boardCode;
    private OpPost op;
    private ArrayList<Post> replies;

    public Thread(JSONObject json, String boardCode) throws JSONException {
        this.boardCode = boardCode;
        JSONArray posts = json.getJSONArray("posts");
        JSONObject op = posts.optJSONObject(0);

        if (op != null) {
            this.op = new OpPost(op);
        } else {
            throw new IllegalStateException("No OP");
        }

        this.replies = new ArrayList<>();

        for (int i = 1; i < posts.length(); i++) {
            this.replies.add(new Post(posts.optJSONObject(i)));
        }
    }

    public String getBoardCode() {
        return boardCode;
    }

    public OpPost getOp() {
        return op;
    }

    public ArrayList<Post> getReplies() {
        return replies;
    }
}
