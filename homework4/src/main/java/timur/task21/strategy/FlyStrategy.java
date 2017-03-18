package timur.task21.strategy;

public class FlyStrategy implements MovingStrategy{


    @Override
    public String walkTo() {
        return "Character cannot walk";
    }

    @Override
    public String flyTo() {
        return "Character is flying in the sky";
    }

    @Override
    public String flyWithMagicTo() {
        return "Character cannot fly with magic";
    }
}
