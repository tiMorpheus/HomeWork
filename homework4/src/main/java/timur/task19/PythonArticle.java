package timur.task19;

public class PythonArticle extends Article {

    public PythonArticle() {

        theme = "Python's new features";
    }

    @Override
    String info() {
        return theme;
    }
}
