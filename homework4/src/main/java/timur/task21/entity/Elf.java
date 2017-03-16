package timur.task21.entity;

import timur.task21.Hero;
import timur.task21.MoveType;

public class Elf extends Character implements Hero{


    public Elf(String name) {
        super(name);
    }


    @Override
    public String move(MoveType moveType) {


        switch (moveType){

            case WALK:
                return "Elf "+ this.getName() + " is walking...";
            default:
                return "Elf's cannot do this move: " + moveType.toString();
        }
    }
}
