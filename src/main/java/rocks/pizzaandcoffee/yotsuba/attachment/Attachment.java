package rocks.pizzaandcoffee.yotsuba.attachment;

public class Attachment {
    private final AttachmentType type;
    private final Object attachment;

    public Attachment(AttachmentType type, Object attachment) {
        this.type = type;
        this.attachment = attachment;
    }

    public Image getImage() {
        if (this.type == AttachmentType.Image) {
            return (Image) this.attachment;
        }
        throw new IllegalStateException("Attachment is not a Image");
    }
}
