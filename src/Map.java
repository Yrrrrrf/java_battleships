import java.util.Scanner;

public class Map extends Menu{
    
    int height;
    int width;
    private byte[][][] matrix;
    static Scanner sc;


    public Map() {
    }

    public Map(int height, int width) {
        matrix = new byte[height][width][2];
    }

    public int scenarioSize(){
        int scenarioSize;
        System.out.println(game_text[languaje][1] + ": ");

        try {
            scenarioSize = sc.nextInt();
        } catch (Exception e) {
            System.out.println(game_text[languaje][2]);
            customScenario();
        }
        return scenarioSize;
    }

    public void ShowMap(){
        System.out.println();
        for (int i = 0; i < height; i++) {
            System.out.println();
            for (int j = 0; j < width; j++) {
                System.out.print(matrix[i][j][0] + " ");
            }
        }
    }

}
