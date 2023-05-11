package pattern.adapter.classAdapter;

public class TFCardImpl implements TFCard {
    @Override
    public String readTF() {
        return "TFCard read msg";
    }

    @Override
    public void writeTF(String msg) {
        System.out.println("TFCard write msg: " + msg);
    }
}
