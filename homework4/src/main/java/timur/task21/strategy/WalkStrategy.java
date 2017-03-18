package timur.task21.strategy;

public class WalkStrategy implements MovingStrategy{


    @Override
    public String walkTo() {
        return "Character is walking on the ground";
    }

    @Override
    public String flyTo() {
        return "Character cannot fly";
    }

    @Override
    public String flyWithMagicTo() {
        return "Character cannot fly with magic";
    }
}
