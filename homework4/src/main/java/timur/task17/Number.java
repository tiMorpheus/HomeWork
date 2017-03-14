package timur.task17;

public class Number implements Component{

    private int value;

    public Number(int value) {
        this.value = value;
    }

    public int calculate() {
        return value;
    }
}
