package timur.task18.factory;

import timur.task18.enums.Language;
import timur.task18.film.Movie;

public interface CinemaFactory {
    Movie getMovie(Language language);
}
