package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ContactUsQueue")
public class ContactUsQueue {

    private String queue;
    private String overlay;
    private boolean faqLink;

    public ContactUsQueue() {
    }

    public ContactUsQueue(String queue, String overlay) {
        this.queue = queue;
        this.overlay = overlay;
        this.faqLink = faqLink;
    }

    public String getQueueName() {
        return queue;
    }

    public boolean getFaqLink() {
    	System.out.println(faqLink);
        return faqLink;
    }

    public String getOverlay() {
        return overlay;
    }

}
