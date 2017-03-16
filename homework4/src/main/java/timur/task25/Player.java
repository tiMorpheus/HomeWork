package timur.task25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public int makeMove() throws IOException {
        int result = 0;
        boolean flag = false;

        do {

            System.out.println("Enter cell:");

            String input = br.readLine();


            // if user input empty line
            if (input.equals("")){
                flag = true;
                continue;
            }
            flag = false;

            if (input.matches("[+-]?\\d+")){

                result = Integer.parseInt(input);
                // if number is negative - undo last move
                if (result < 0) {
                    return result;
                }

                if (result > 8){
                    flag = true;
                    System.out.println("Incorrect Value");
                    continue;
                }
            } else {
                flag = true;
                continue;
            }
        } while (false);

        return result;
    }
}
