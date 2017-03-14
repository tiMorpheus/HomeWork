package timur.task20;

import timur.task20.figures.*;

public class FigureFactory {

    public static Figure getFigure(int i) {
        Figure figure = null;

        switch (i) {
            case (1):
                figure = new E();
                break;
            case (2):
                figure = new F();
                break;
            case (3):
                figure = new I();
                break;
            case (4):
                figure = new J();
                break;
            case (5):
                figure = new L();
                break;
            case (6):
                figure = new T();
                break;
            default:
                figure = new SuperFigure();
        }


        return figure;
    }

}
