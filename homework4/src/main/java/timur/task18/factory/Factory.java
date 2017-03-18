package timur.task18.factory;

import timur.task18.enums.Factories;

public class Factory {

    public static CinemaFactory getFactory(Factories factory){

        switch (factory){
            case SPIDERMAN_FACTORY:
                return SpidermanFactory.getInstance();
            case BATMAN_FACTORY:
                return BatmanFactory.getInstance();
            case LOGAN_FACTORY:
                return LoganFactory.getInstance();
                default:
                    return SpidermanFactory.getInstance();
        }
    }
}
