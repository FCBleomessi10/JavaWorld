package pattern.prototype.case1;

public class Citation implements Cloneable {

    private String name;

    public Citation() {
    }

    public Citation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Citation clone() throws CloneNotSupportedException {
        return (Citation) super.clone();
    }

    public void show() {
        System.out.println(this.name);
    }
}
