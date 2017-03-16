package timur.task25;

import java.io.IOException;

public class Game {
    private Player player;
    private Field field;
    private MementoItem mementoItem;

    public Game(Player player, Field field) {
        this.player = player;
        this.field = field;
        mementoItem = new MementoItem();
    }

    public Field getField() {
        return field;
    }


    public void start() throws IOException {
        int cellNumber;
        boolean finish = false;

        int[] cells;
        int count = 0;

        while (!finish) {

            field.drawField();
            cells = field.getCells();

            cellNumber = player.makeMove();
            if (cellNumber < 0 && count > 0) {
                field.restoreState(mementoItem.pop());
                count--;
                continue;
            }

            if (cellNumber < 0 && count == 0) {
                continue;
            }
            mementoItem.add(field.saveState());


            if (cells[cellNumber] == 0 && count % 2 != 0) {
                cells[cellNumber] = 1;
            } else if (cells[cellNumber] == 0 && count % 2 == 0) {
                cells[cellNumber] = 2;
            } else {
                System.out.println("OOPs");
                if (additionCheck(cells)){
                    break;
                }else {continue;}
            }

            count++;

            if (isGameFinished(cellNumber)){
                finish = true;
            }
        }
        field.drawField();
    }

    private boolean additionCheck(int[] cells) {
        boolean flag = false;
        for (int i = 0; i < cells.length; i++) {
            if (cells[i] == 0) {
                flag = false;
            } else  flag = true;
        }
        return flag;
    }

    private boolean isGameFinished(int n) {
        int[] cells = getField().getCells();
        int row = n - n % 3;
        if (cells[row] == cells[row + 1] && cells[row] == cells[row + 2])
            return true;

        int column = n % 3;
        if (cells[column] == cells[column + 3] && cells[column] == cells[column + 6])
            return true;

        if (n % 2 != 0) {
            return false;
        }
        if (n % 4 == 0) {
            if (cells[0] == cells[4] && cells[0] == cells[8]) return true;
            if (n!=4) return false;
        }
        return cells[2] == cells[4] && cells[2] == cells[6];
    }

    public static void main(String[] args) throws IOException {
        Field field = new Field();
        Player player = new Player();
        Game game = new Game(player, field);
        game.start();
    }

}

