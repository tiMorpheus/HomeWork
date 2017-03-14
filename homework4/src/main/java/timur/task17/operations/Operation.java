package timur.task17.operations;

import timur.task17.Component;

public abstract class Operation {

    Component left;
    Component right;

    public Operation(Component left, Component right) {
        this.left = left;
        this.right = right;
    }

}
