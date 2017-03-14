package task20;


import timur.task20.Figure;
import timur.task20.FigureFactory;

public class AbstractMethod {



    public static void main(String[] args) throws InterruptedException {

        int f;

        Figure figure;


        while (true){

            f = (int) (Math.random() * 7);

            figure = FigureFactory.getFigure(f);

            System.out.println(figure.draw());
            Thread.sleep(1000);
        }
    }
}
