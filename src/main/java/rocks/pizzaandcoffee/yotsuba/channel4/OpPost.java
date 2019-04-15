package rocks.pizzaandcoffee.yotsuba.channel4;

import org.json.JSONException;
import org.json.JSONObject;

public class OpPost extends Post {

    // booleans, represented as ints
    private final int sticky;
    private final int closed;
    private final int  archived;
    private final int bumpLimit;
    private final int imageLimit;

    private final String subject;
    private final Integer archivedOn;
    private final int replies;
    private final int images;
    private final int uniqueIPs;


    OpPost(JSONObject json) throws JSONException {
        super(json);

        // only present when true
        int sticky;
        int closed;
        int archived;

        try {
            sticky = json.getInt("sticky");
        } catch (JSONException e) {
            sticky = 0;
        }

        try {
            closed = json.getInt("closed");
        } catch (JSONException e) {
            closed = 0;
        }

        try {
            archived = json.getInt("archived");
        } catch (JSONException e) {
            archived = 0;
        }

        this.sticky = sticky;
        this.closed = closed;
        this.archived = archived;

        this.bumpLimit = json.getInt("bumplimit");
        this.imageLimit = json.getInt("imagelimit");
        this.images = json.getInt("images");
        this.replies = json.getInt("replies");
        this.uniqueIPs = json.getInt("unique_ips");

        this.subject = json.optString("sub");

        if (this.archived != 0) {
            this.archivedOn = json.getInt("archived_on");
        } else {
            this.archivedOn = null;
        }
    }

    public boolean isSticky() {
        return sticky != 0;
    }

    public boolean isClosed() {
        return closed != 0;
    }

    public boolean isArchived() {
        return archived != 0;
    }

    public int getBumpLimit() {
        return bumpLimit;
    }

    public int getImageLimit() {
        return imageLimit;
    }

    public String getSubject() {
        return subject;
    }

    public Integer getArchivedOn() {
        return archivedOn;
    }

    public int getReplies() {
        return replies;
    }

    public int getImages() {
        return images;
    }

    public int getUniqueIPs() {
        return uniqueIPs;
    }
}
