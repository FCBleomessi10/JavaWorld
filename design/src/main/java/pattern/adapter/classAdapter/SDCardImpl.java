package pattern.adapter.classAdapter;

public class SDCardImpl implements SDCard {
    @Override
    public String readSD() {
        return "SDCard read msg";
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("SDCard write msg: " + msg);
    }
}
