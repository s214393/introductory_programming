import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class GameOfLifeMain {

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "C:\\Users\\WOKKEFAR\\IdeaProjects\\gol\\glider_gun.gol";
        File f = new File(filePath);
        Scanner input = new Scanner(f);

        //int[][] inState = new int[][];
        if(f.canRead()) {
            int i = 0;
            System.out.println();
            int countNumberOfLines = 0;
            int lengthOfLine = 0;
            while (input.hasNextLine()){
                countNumberOfLines++;
                lengthOfLine = input.nextLine().length();
                System.out.println(countNumberOfLines);
            }
            Scanner input2 = new Scanner(f);

            //int[][] initialFileState = new int[4][4];
            int[][] initialFileState = new int[lengthOfLine][countNumberOfLines];
            while(input2.hasNextLine()){
                String[] f_line = input2.nextLine().split(" ");
                for (int j = 0; j < f_line.length; j++) {

                        initialFileState[j][i] = Integer.parseInt(f_line[j]);

                }
                i++;

            }
            System.out.println(Arrays.deepToString(initialFileState));

            GameOfLife game1 = new GameOfLife(initialFileState);
            boolean a =true;
            while (a){
                game1.printState();
                StdDraw.show(500);
                StdDraw.clear();
                game1.nextState();
            }
        }
        else {
            System.out.println("faulty file type");
        }


        //game1.setAliveCell(2,2);
        //game1.setAliveCell(3,2);
        //game1.setAliveCell(4,2);


    }
}
