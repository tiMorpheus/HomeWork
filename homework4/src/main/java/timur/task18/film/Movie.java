package timur.task18.film;

import timur.task18.enums.Language;

public abstract class Movie {

    protected String name;
    protected Language soundtrack;
    protected Language subtitles;

    public Movie(Language language) {
        soundtrack = language;
        subtitles = language;
    }


    public String getName() {
        return name;
    }

    public Language getSoundtrack() {
        return soundtrack;
    }

    public Language getSubtitles() {
        return subtitles;
    }

    public void setSoundtrackLanguage(Language language) {
        this.soundtrack = language;
        this.subtitles = language;
    }

    public void setSubtitlesLanguage (Language language) {
        this.subtitles = language;
        this.soundtrack = language;
    }

    @Override
    public String toString() {
        return name + ": soundtrack language is: " + soundtrack + ", subtitle language is: " + subtitles;
    }
}
