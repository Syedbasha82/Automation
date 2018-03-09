package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ContactUsQueue")
public class ContactUsQueue {

    private String queue;
    private String overlay;
    private String overlay2;
    private boolean faqLink;
    private boolean faqLink2;
    public ContactUsQueue() {
    }

    public ContactUsQueue(String queue, String overlay) {
        this.queue = queue;
        this.overlay = overlay;
        this.faqLink = faqLink;
        this.overlay2 = overlay2;
        this.faqLink2 = faqLink2;
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
    
    public boolean getFaqLink2() {
    	System.out.println(faqLink2);
        return faqLink2;
    }

    public String getOverlay2() {
        return overlay2;
    }

}
