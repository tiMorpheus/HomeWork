package timur.task19;

import java.util.HashMap;
import java.util.Map;

public class ArticleCache {

    private static Map<String, Article> cache = new HashMap<>();


    public Article getArticle(String theme) throws CloneNotSupportedException {
        Article article = null;
        if (cache.get(theme) != null) {
            article = cache.get(theme).clone();
        } else {
            throw new IllegalArgumentException();
        }
        return article;
    }

    public static void loadCache() {
        Article javaArticle = new JavaArticle();
        cache.put(javaArticle.getTheme(), javaArticle);

        Article pythonArticle = new PythonArticle();
        cache.put(pythonArticle.getTheme(), pythonArticle);
    }
}
