package pattern.adapter.objectAdapter;

public class SDAdapterTF implements SDCard {

    private final TFCard tfCard;

    public SDAdapterTF(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public String readSD() {
        System.out.println("adapter read TFCard");
        return tfCard.readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter write TFCard");
        tfCard.writeTF(msg);
    }
}
