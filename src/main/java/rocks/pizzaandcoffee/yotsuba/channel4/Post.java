package rocks.pizzaandcoffee.yotsuba.channel4;

import org.json.JSONException;
import org.json.JSONObject;
import rocks.pizzaandcoffee.yotsuba.channel4.attachment.Attachment;

public class Post {
    private final String id;
    private final Integer number;
    private final String now;
    private final String name;
    private final String trip;
    private final String comment;
    private final Integer responseTo;
    private final Integer time;
    private final Attachment attachment;


    Post(JSONObject json) throws JSONException {
        this.number = json.getInt("no");
        this.now = json.getString("now");
        this.name = json.getString("name");
        this.responseTo = json.getInt("resto");
        this.time = json.getInt("time");
        this.attachment = new Attachment(json);

        String tempComment;
        String tempID;
        String tempTrip;

        try {
            tempComment = json.getString("com");
        } catch (JSONException e) {
            tempComment = null;
        }

        try {
            tempID = json.getString("id");
        } catch (JSONException e) {
            tempID = null;
        }

        try {
            tempTrip = json.getString("id");
        } catch (JSONException e) {
            tempTrip = null;
        }

        this.comment = tempComment;
        this.id = tempID;
        this.trip = tempTrip;
    }

    public String getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public String getNow() {
        return now;
    }

    public String getName() {
        return name;
    }

    public String getTrip() {
        return trip;
    }

    public String getComment() {
        return comment;
    }

    public Integer getResponseTo() {
        return responseTo;
    }

    public Integer getTime() {
        return time;
    }

    public Attachment getAttachment() {
        return attachment;
    }
}
