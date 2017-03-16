package timur.task21.entity;

import timur.task21.Hero;
import timur.task21.MoveType;

public class Pegasus extends Character implements Hero{

    public Pegasus(String name) {
        super(name);
    }

    @Override
    public String move(MoveType moveType) {
        switch (moveType){

            case WALK:
                return "Pegasus "+ this.getName() + " is walking...";
            case FLY:
                return "Pegasus "+ this.getName() + " is flying...";
            case FLY_WITH_MAGIC:
                return "Pegasus "+ this.getName() + " is flying by magic...";
            default:
                return "Pegasus's cannot do this move: " + moveType.toString();
        }
    }
}
