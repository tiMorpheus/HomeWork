package timur.task21;

public class Context {

    private Hero hero;

    public Context() {
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        if (hero == null){
            throw new IllegalArgumentException();
        }
        this.hero = hero;
    }

    public String move(MoveType moves) {
        return hero.move(moves);
    }
}
