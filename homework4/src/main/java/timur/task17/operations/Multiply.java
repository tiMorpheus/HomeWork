package timur.task17.operations;

import timur.task17.Component;

public class Multiply extends Operation implements Component{

    public Multiply(Component left, Component right) {
        super(left, right);
    }

    public int calculate() {
        return left.calculate() * right.calculate();
    }
}
