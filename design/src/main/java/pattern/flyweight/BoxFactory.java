package pattern.flyweight;

import java.util.HashMap;

public class BoxFactory {
    private final HashMap<String, AbstractBox> map;

    private BoxFactory() {
        map = new HashMap<>();
        map.put("I", new IBox());
        map.put("L", new LBox());
        map.put("O", new OBox());
    }

    private static final BoxFactory factory = new BoxFactory();

    public static BoxFactory getInstance() {
        return factory;
    }

    public AbstractBox getShape(String name) {
        return map.get(name);
    }
}
