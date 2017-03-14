package task19;

import org.junit.Before;
import org.junit.Test;
import timur.task19.Article;
import timur.task19.ArticleCache;

import static org.junit.Assert.assertNotEquals;

public class PrototypeTest {

    Article java;
    Article newJavaArticle;
    ArticleCache articleCache;

    @Before
    public void setUp() throws CloneNotSupportedException {

        articleCache = new ArticleCache();
        ArticleCache.loadCache();
        java = articleCache.getArticle("Java 9 - way to the future");

    }

    @Test
    public void cacheTest() throws CloneNotSupportedException {

        java.setTheme("Java 2 - way to the future");

        newJavaArticle = articleCache.getArticle("Java 9 - way to the future");

        assertNotEquals(newJavaArticle, java);
    }
}
