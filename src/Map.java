import java.util.Scanner;

public class Map extends Menu{
    
    
    private byte[][][] matrix = new byte[10][1][0];
    static Scanner sc;


    public Map() {
    }

    public Map(int height, int width) {
    }

    public void setMatrixSize(){
        
        this.matrix = new byte[10][10][0];
    }

    public void scenarioSize(){
        int scenarioSize;
        System.out.println(mainOptions.getGameText()[mainOptions.getLanguage()-1][1] + ": ");

        try {
            scenarioSize = sc.nextInt();
        } catch (Exception e) {
            System.out.println(mainOptions.getGameText()[mainOptions.getLanguage()-1][1]);
        }
    }

    public void ShowMap(){
        System.out.println();
        for (int i = 0; i < 8; i++) {
            System.out.println();
            for (int j = 0; j < 8; j++) {
                System.out.print(matrix[i][j][0] + " ");
            }
        }
    }

    public static void main(String[] args) {

        Options mainOptions = new Options();
        mainOptions.setDefaultSize();

        Map map = new Map(10, 10);
        map.setMatrixSize();
        map.ShowMap();
    }

}
