package timur.task21.entity;

import timur.task21.strategy.FlyStrategy;
import timur.task21.strategy.MovingStrategy;

public abstract class Character {

    private String name;

    private int x;
    private int y;
    private int z;

    private MovingStrategy movingStrategy;

    public Character(String name, MovingStrategy movingStrategy) {
        this.name = name;
        this.movingStrategy = movingStrategy;
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMovingStrategy(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }


    public void moveTo(int x, int y, int z, boolean magic){

        if (z == 0){
            this.x = x;
            this.y = y;
            movingStrategy.walkTo();
        }

        if (z > 0 && !magic){
            this.x = x;
            this.y = y;
            this.z = z;
            movingStrategy.flyTo();
        }

        if (z > 0 && magic){
            this.x = x;
            this.y = y;
            this.z = z;
            movingStrategy.flyWithMagicTo();
        }




    }
}
