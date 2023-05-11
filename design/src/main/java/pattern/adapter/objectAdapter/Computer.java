package pattern.adapter.objectAdapter;

public class Computer {
    public String readSD(SDCard sdCard) {
        if (sdCard == null) {
            throw new NullPointerException("SDCard is not null");
        }
        return sdCard.readSD();
    }

    public void writeSD(SDCard sdCard, String msg) {
        sdCard.writeSD(msg);
    }
}
