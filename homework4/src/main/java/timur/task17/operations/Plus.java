package timur.task17.operations;

import timur.task17.Component;

public class Plus extends Operation implements Component {

    public Plus(Component left, Component right) {
        super(left,right);
    }

    public int calculate() {
        return left.calculate() + right.calculate();
    }
}
