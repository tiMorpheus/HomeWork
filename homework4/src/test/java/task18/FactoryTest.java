package task18;

import org.junit.Before;
import org.junit.Test;
import timur.task18.enums.Factories;
import timur.task18.enums.Language;
import timur.task18.factory.CinemaFactory;
import timur.task18.factory.Factory;
import timur.task18.film.Movie;

public class FactoryTest {


    Factories spidermanFactory;
    Movie spiderman;
    CinemaFactory cinema;
    Language russian;
    Language english;
    Language german;

    @Before
    public void setUp() {
        spidermanFactory = Factories.SPIDERMAN_FACTORY;
        russian = Language.RUS;
        english = Language.ENG;
        german  = Language.GRM;
        cinema = Factory.getFactory(spidermanFactory);
        spiderman = cinema.getMovie(russian);

    }

    @Test
    public void getFilmSpiderman() {
        System.out.println(spiderman);
    }

    @Test
    public void changeSubtitleLanguage(){
        spiderman.setSubtitlesLanguage(english);

        System.out.println(spiderman);
    }

    @Test
    public void changeSoundtrackLanguage(){
        spiderman.setSoundtrackLanguage(german);

        System.out.println(spiderman);
    }
}
