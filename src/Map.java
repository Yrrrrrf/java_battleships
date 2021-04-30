public class Map extends Menu{    
    
    private byte[][][] matrix;
    int mapSize;

    public Map() {
    }

    public Map(int mapSize) {
        this.mapSize = mapSize;
        this.matrix = new byte[mapSize][mapSize][2];
        initializeMap();
    }


    // ! ADD THE PARAMETER TO PRINT THE PLAYER OR THE MACHINE MAP
    public void showMap(){
        for (int i = 0; i < mapSize; i++) {
            System.out.println();
            for (int j = 0; j < mapSize; j++) {
                System.out.printf("%-3d", matrix[j][i][0]);
            }
        }
        System.out.println("\n");
    }

    public void initializeMap(){
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                for (int k = 0; k < 2; k++) {
                    matrix[i][j][k] = 0;
                }
            }
        } 
    }

    
    public void setMatrix(byte[][][] matrix) {this.matrix = matrix;}
    
    public void setMapSize(int mapSize) {this.mapSize = mapSize;}


    public byte[][][] getMatrix() {return this.matrix;}
    
    public int getMapSize() {return this.mapSize;}

}