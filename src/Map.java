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


    /**
     * Print the gameMap
     * <p>
     * The matrix have the form (x, y)
     */
    public void showMap(){

        System.out.printf("%3s", " MAP ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.printf("%3d", (i + 1));
        }

        for (int i = 0; i < mapSize; i++) {
            System.out.println();
            System.out.printf("%3d", (i + 1));
            System.out.print("- ");

            for (int j = 0; j < mapSize; j++) {
                System.out.printf("%3d", matrix[j][i][0]);
            }
        }
        System.out.println();
    }


    /**
     * Shows the ships and the shooted missiles map
     */
    public void showTwoMaps(){
        // FIRST LINE (GUIDE AND MAP TYPES)
        System.out.printf("%3s", "SHIPS");
        for (int i = 0; i < matrix.length; i++) {
            System.out.printf("%3d", (i + 1));
        }
        System.out.print("                ");
        System.out.printf("%3s", "SHOTS");
        for (int i = 0; i < matrix.length; i++) {
            System.out.printf("%3d", (i + 1));
        }

        // MATRIX DATA
        for (int i = 0; i < mapSize; i++) {
            System.out.println();
            System.out.printf("%3d", (i + 1));
            System.out.print(" |");
            for (int j = 0; j < mapSize; j++) {
                System.out.printf("%3d", matrix[j][i][0]);
            }
            
            System.out.print("                ");
            System.out.printf("%3d", (i + 1));
            System.out.print(" |");
            for (int j = 0; j < mapSize; j++) {
                System.out.printf("%3d", matrix[j][i][1]);
            }
        }
        System.out.println();
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