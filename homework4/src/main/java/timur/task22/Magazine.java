package timur.task22;

public class Magazine {

    private String label;

    public Magazine(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Magazine "+ label;
    }
}
