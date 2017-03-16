package timur.task25;

import java.util.Arrays;

public class Field {
    private int[] cells = {0, 0, 0,
            0, 0, 0,
            0, 0, 0};

    public int[] getCells() {
        return cells;
    }

    public void setCells(int[] cells) {
        this.cells = cells;
    }

    public Memento saveState() {
        return new Memento(Arrays.copyOf(cells, cells.length));
    }

    public void restoreState(Memento memento) {
        this.cells = memento.getCells();
    }

    void drawField(){
        System.out.println("     |     |     ");

        for (int i = 0; i < cells.length; i++){
            if (i != 0){
                if (i % 3 == 0){
                    System.out.println();
                    System.out.println("_____|_____|_____");
                    System.out.println("     |     |     ");
                } else {
                    System.out.print("|");
                }
            }
            if (cells[i] == 0) System.out.print("  " + i + "  ");
            if (cells[i] == 1) System.out.print("  X  ");
            if (cells[i] == 2) System.out.print("  O  ");
        }
        System.out.println();
        System.out.println("     |     |     ");
    }
}
