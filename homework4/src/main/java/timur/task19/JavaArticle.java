package timur.task19;

public class JavaArticle extends Article {

    public JavaArticle() {

        theme = "Java 9 - way to the future";
    }


    @Override
    String info() {
        return theme;
    }
}

