package timur.task21.entity;

import timur.task21.Hero;
import timur.task21.MoveType;

public class Orc extends Character implements Hero {


    public Orc(String name) {
        super(name);
    }

    @Override
    public String move(MoveType moveType) {
        switch (moveType){

            case WALK:
                return "Orc "+ this.getName() + " is walking...";
            default:
                return "Orc's cannot do this move: " + moveType.toString();
        }
    }
}
