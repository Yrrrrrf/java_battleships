import java.util.Scanner;

public class Map extends Menu{    
    
    private byte[][][] matrix;
    static Scanner sc;
    Options mapOptions;

    public Map() {
    }

    public Map(int height, int width) {
        mapOptions = new Options(height, width);
        this.matrix = new byte[height][width][2];
        initializeMap();
    }


    public void showMap(){
        for (int i = 0; i < mapOptions.getHeight(); i++) {
            System.out.println();
            for (int j = 0; j < mapOptions.getWidth(); j++) {
                System.out.print(matrix[i][j][0] + " ");
            }
        }
    }

    public void initializeMap(){
            for (int i = 0; i < mapOptions.getHeight(); i++) {
                for (int j = 0; j < mapOptions.getWidth(); j++) {
                    for (int k = 0; k < 2; k++) {
                        matrix[i][j][k] = 0;
                    }
                }
            } 
    }


    
    public void setMatrix(byte[][][] matrix) {this.matrix = matrix;}
    
    public void setMapOptions(Options mapOptions) {this.mapOptions = mapOptions;}
    

    public byte[][][] getMatrix() {return this.matrix;}
    
    public Options getMapOptions() {return this.mapOptions;}


    public static void main(String[] args) {

        Map map = new Map(10,10);
        map.showMap();
    }

}