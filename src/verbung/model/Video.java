package verbung.model;

import verbung.model.BorrowableMedium;

public class Video extends BorrowableMedium {

    private String producer;

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
