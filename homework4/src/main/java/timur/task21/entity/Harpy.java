package timur.task21.entity;

import timur.task21.Hero;
import timur.task21.MoveType;

public class Harpy extends Character implements Hero {

    public Harpy(String name) {
        super(name);
    }

    @Override
    public String move(MoveType moveType) {

        switch (moveType){

            case WALK:
                return "Harpy "+ this.getName() + " is walking...";
            case FLY:
                return "Harpy "+ this.getName() + " is flying...";
            default:
                return "Harpy's cannot do this move: " + moveType.toString();
        }

    }
}
