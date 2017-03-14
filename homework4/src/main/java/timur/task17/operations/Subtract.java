package timur.task17.operations;

import timur.task17.Component;

public class Subtract extends Operation implements Component {

    public Subtract(Component left, Component right) {
       super(left, right);
    }


    public int calculate() {
        return left.calculate() - right.calculate();
    }
}
