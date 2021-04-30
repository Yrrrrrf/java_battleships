public class Map extends Menu{    
    
    private byte[][][] matrix;
    int mapSize;


    public Map() {
    }


    /**
     * Creates the map Matrix that will be used in the Game() method
     * @param mapSize
     */
    public Map(int mapSize) {
        this.mapSize = mapSize;
        this.matrix = new byte[mapSize][mapSize][2];
        initializeMap();
    }


    // ! ADD THE PARAMETER TO PRINT THE PLAYER OR THE MACHINE MAP
    /**
     * Print the gameMap
     * <p>
     * The matrix have the form (x, y)
     */
    public void showMap(){
        for (int i = 0; i < mapSize; i++) {
            System.out.println();
            for (int j = 0; j < mapSize; j++) {
                System.out.printf("%-3d", matrix[j][i][0]);
            }
        }
        System.out.println("\n");
    }

    /**
     * Assign 0 to all values of the initial map
     */
    public void initializeMap(){
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                for (int k = 0; k < 2; k++) {
                    matrix[i][j][k] = 0;
                }
            }
        } 
    }


    // * SETTERS
    public void setMatrix(byte[][][] matrix) {this.matrix = matrix;}
    
    public void setMapSize(int mapSize) {this.mapSize = mapSize;}


    // * GETTERS
    public byte[][][] getMatrix() {return this.matrix;}
    
    public int getMapSize() {return this.mapSize;}

}