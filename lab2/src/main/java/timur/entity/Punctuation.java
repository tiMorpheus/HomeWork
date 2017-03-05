package timur.entity;

public class Punctuation implements PartOfSentence {

    private static long counter;
    private long id;
    private char p;

    public Punctuation(char p){
        this.p = p;
        counter++;
    }

    @Override
    public String toString() {
        return String.valueOf(p);
    }

    @Override
    public long getId() {

        return id;
    }

}
