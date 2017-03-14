package timur.task19;

public abstract class Article implements Cloneable {

    protected String theme;

    abstract String info();

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public Article clone() throws CloneNotSupportedException {
        return (Article) super.clone();
    }
}
