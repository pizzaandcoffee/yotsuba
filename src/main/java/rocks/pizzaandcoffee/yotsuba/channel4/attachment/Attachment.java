package rocks.pizzaandcoffee.yotsuba.channel4.attachment;

import org.json.JSONException;
import org.json.JSONObject;

public class Attachment {
    private AttachmentType type;
    private final JSONObject data;

    public Attachment(JSONObject data) {
        try {
            String ext = data.getString("ext");

            switch (ext) {
                case ".jpg":
                case ".png":
                case ".gif":
                    this.type = AttachmentType.IMAGE;
                    break;

                case ".swf":
                    this.type = AttachmentType.FLASH;
                    break;

                case ".webm":
                    this.type = AttachmentType.WEBM;
                    break;

                default:
                    this.type = null;
            }

        } catch (JSONException e) {
            this.type = null;
        }

        this.data = data;
    }

    public Image getImage() {
        if (this.type == AttachmentType.IMAGE) {
            try {
                return new Image(data);
            } catch (JSONException e) {
                throw new IllegalStateException("Invalid JSON");
            }
        }
        throw new IllegalStateException("Attachment is not a Image");
    }

    public Flash getFlash() {
        if (this.type == AttachmentType.FLASH) {
            try {
                return new Flash(data);
            } catch (JSONException e) {
                throw new IllegalStateException("Invalid JSON");
            }
        }
        throw new IllegalStateException("Attachment is not a FLash file");
    }

    public Webm getWebm() {
        if (this.type == AttachmentType.WEBM) {
            try {
                return new Webm(data);
            } catch (JSONException e) {
                throw new IllegalStateException("Invalid JSON");
            }
        }
        throw new IllegalStateException("Attachment is not a Webm");
    }

    public boolean isPresent() {
        return this.type != null;
    }
}