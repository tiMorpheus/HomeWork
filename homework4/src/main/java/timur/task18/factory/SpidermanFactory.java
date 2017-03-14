package timur.task18.factory;

import timur.task18.enums.Language;
import timur.task18.film.Movie;
import timur.task18.film.SpidermanMovie;

public final class SpidermanFactory implements CinemaFactory {

    private static CinemaFactory instance = new SpidermanFactory();

    public static CinemaFactory getInstance(){
        return instance;
    }

    @Override
    public Movie getMovie(Language language) {
        return new SpidermanMovie(language);
    }
}
