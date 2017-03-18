package timur.task21.strategy;

public class WalkAndFlyStrategy implements MovingStrategy{
    @Override
    public String walkTo() {
        return "Character is walking on the ground";
    }

    @Override
    public String flyTo() {
        return "Character is flying in the sky";
    }

    @Override
    public String flyWithMagicTo() {
        return "Character on this strategy cannot Fly with magic";
    }
}
