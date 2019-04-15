package rocks.pizzaandcoffee.yotsuba.channel4.attachment;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class File {
    private final String filename;
    private final String extension;
    private final Integer width;
    private final Integer height;
    private final Integer thumbnailWidth;
    private final Integer thumbnailHeight;
    private final Integer timestampWithMiliseconds;
    private final Integer timestamp;
    private final String md5;
    private final Integer filesize;

    File(JSONObject json) throws JSONException {
        this.filename = json.getString("filename");
        this.extension = json.getString("ext");
        this.width = json.getInt("w");
        this.height = json.getInt("h");
        this.thumbnailWidth = json.getInt("tn_w");
        this.thumbnailHeight = json.getInt("tn_h");
        this.timestampWithMiliseconds = json.getInt("tim");
        this.timestamp = json.getInt("time");
        this.md5 = json.getString("md5");
        this.filesize = json.getInt("fsize");
    }

    public String getFullFilename() {
        return this.filename + this.extension;
    }

    public String getFilename() {
        return filename;
    }

    public String getExtension() {
        return extension;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getThumbnailWidth() {
        return thumbnailWidth;
    }

    public Integer getThumbnailHeight() {
        return thumbnailHeight;
    }

    public Integer getTimestampWithMiliseconds() {
        return timestampWithMiliseconds;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public String getMd5() {
        return md5;
    }

    public Integer getFilesize() {
        return filesize;
    }
}
