package pattern.prototype.case1;

public class CitationTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Citation citation = new Citation("c1");
        Citation clone = citation.clone();
        clone.setName("c2");

        citation.show();
        clone.show();
    }
}
