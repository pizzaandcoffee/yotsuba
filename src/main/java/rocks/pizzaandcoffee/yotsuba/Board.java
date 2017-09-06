package rocks.pizzaandcoffee.yotsuba;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Board {
    private final String boardCode;
    private final String title;
    private final Boolean isWorkSafe;
    private final int threadsPerPage;
    private final int pages;
    private final int maxFilesize;
    private final int maxWebmFilesize;
    private final int maxCommentChars;
    private final int bumpLimit;
    private final int imageLimit;
    private final Cooldowns cooldowns;
    private final String metaDescription;
    private final Boolean isArchived;

    private class Cooldowns {
        private final int threads;
        private final int replies;
        private final int images;

        Cooldowns(JSONObject json) throws JSONException {
            this.threads = (Integer) json.get("threads");
            this.replies = (Integer) json.get("replies");
            this.images = (Integer) json.get("images");
        }

        public int getThreads() {
            return threads;
        }

        public int getReplies() {
            return replies;
        }

        public int getImages() {
            return images;
        }
    }

    public Board(JSONObject json) throws JSONException {
        this.boardCode = (String) json.getString("board");
        this.title = (String) json.get("title");
        this.isWorkSafe = (Integer) json.get("ws_board") == 1;
        this.threadsPerPage = (Integer) json.get("per_page");
        this.pages = (Integer) json.get("pages");
        this.maxFilesize = (Integer) json.get("max_filesize");
        this.maxWebmFilesize = (Integer) json.get("max_webm_filesize");
        this.maxCommentChars = (Integer) json.get("max_comment_chars");
        this.bumpLimit = (Integer) json.get("bump_limit");
        this.imageLimit = (Integer) json.get("image_limit");
        this.cooldowns = new Cooldowns((JSONObject) json.get("cooldowns"));
        this.metaDescription = (String) json.get("meta_description");
        this.isArchived = json.opt("is_archived") != null;
    }

    public static ArrayList<Board> getBoards() {
        ArrayList<Board> boardArray = new ArrayList<Board>();
        try {
            URL boardsUrl = new URL("https://a.4cdn.org/boards.json");
            String jsonString = Util.getJsonString(boardsUrl);
            JSONObject root = new JSONObject(jsonString);
            JSONArray boards = (JSONArray) root.get("boards");

            for (int i = 0; i < boards.length(); i++) {
                JSONObject board =(JSONObject) boards.get(i);
                boardArray.add(new Board(board));
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return boardArray;
    }

    public ArrayList<LastModifiedPage> getLastModifiedPages() {
        return LastModifiedPage.getPages(this);
    }

    public String getBoardCode() {
        return boardCode;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getWorkSafe() {
        return isWorkSafe;
    }

    public int getThreadsPerPage() {
        return threadsPerPage;
    }

    public int getPages() {
        return pages;
    }

    public int getMaxFilesize() {
        return maxFilesize;
    }

    public int getMaxWebmFilesize() {
        return maxWebmFilesize;
    }

    public int getMaxCommentChars() {
        return maxCommentChars;
    }

    public int getBumpLimit() {
        return bumpLimit;
    }

    public int getImageLimit() {
        return imageLimit;
    }

    public Cooldowns getCooldowns() {
        return cooldowns;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public Boolean getArchived() {
        return isArchived;
    }
}
