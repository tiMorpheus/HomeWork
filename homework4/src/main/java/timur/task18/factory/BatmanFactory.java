package timur.task18.factory;

import timur.task18.enums.Language;
import timur.task18.film.BatmanMovie;
import timur.task18.film.Movie;

public class BatmanFactory implements CinemaFactory {

    private static CinemaFactory instance = new BatmanFactory();

    public static CinemaFactory getInstance(){
        return instance;
    }

    @Override
    public Movie getMovie(Language language) {
        return new BatmanMovie(language);
    }
}
