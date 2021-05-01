import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Game {
 
    Options gameOptions;
    Ship[] gameShips;
    Missile[] gameMissiles;
    Map gameMap;
    Map randomMap;
    Scanner sc;

    
    /**
     * Start a new game this the Options that the user gives (using the Options class that can the cahnged in the Main Menu)
     * <p>
     * Player vs Machine
     * <p>
     * Machine only functions with a Random number integer generator. For now. Upcoming: "detection ship and fire algorithm"
     * @param mainOptions
     */
    public Game(Options mainOptions) {
        
        this.gameOptions = new Options(mainOptions.getSize());
        setGameOptions(gameOptions);

        gameMap = new Map(gameOptions.getSize());
        randomMap = new Map(gameOptions.getSize());

        // gameMap.showMap();

        gameShips = new Ship[7];
        for (int i = 0; i < gameShips.length; i++) {
            gameShips[i] = new Ship();
        }
        
        gameShips[0].setShip(gameOptions.getLanguage(), ShipType.CARRIER);
        gameShips[1].setShip(gameOptions.getLanguage(), ShipType.CRUISER);
        gameShips[2].setShip(gameOptions.getLanguage(), ShipType.CRUISER);
        gameShips[3].setShip(gameOptions.getLanguage(), ShipType.DESTROYER);
        gameShips[4].setShip(gameOptions.getLanguage(), ShipType.FRIGATE);
        gameShips[5].setShip(gameOptions.getLanguage(), ShipType.FRIGATE);
        gameShips[6].setShip(gameOptions.getLanguage(), ShipType.VESSEL);

        // Initialize the missiles that will be used in the game
        gameMissiles = new Missile[3];
        for (int i = 0; i < gameShips.length; i++) {
            gameMissiles[i] = new Missile();
        }
        gameMissiles[0].setMissile(gameOptions.getLanguage(), MissileType.SIMPLE);
        gameMissiles[1].setMissile(gameOptions.getLanguage(), MissileType.CROSS);
        gameMissiles[2].setMissile(gameOptions.getLanguage(), MissileType.SMALLT);

    }


    /**
     * Puts all the ships in the map
     * <p>
     * Calls other functions to get only valid positons 
     */
    public void setShipPosition() {
        byte x, y;
        boolean validPosition;
        boolean isVertical;

        clearScreen();
        for (int i = 0; i < gameShips.length; i++) {
            System.out.println(GameText.coordinatesText[gameOptions.getLanguage()][0] + gameShips[i].getName()); // "You're going to put " + ship.name

            gameMap.showMap();
            // isVertical assign the value of reqwuestVertical
           isVertical = requestVertical();
           setShipOrientation(gameShips[i], isVertical);

            // SETTING RIGHT COORDINATES
            System.out.println(GameText.coordinatesText[gameOptions.getLanguage()][3]); // "Introduce X coordinate"
            x = setCoordinate();
            System.out.println(GameText.coordinatesText[gameOptions.getLanguage()][4]); // "Introduce Y coordinate"
            y = setCoordinate();
            
            validPosition = evaluateShipPosition(gameMap, gameShips[i], x, y);

            if (validPosition == true) {
                adjustMapMatrix(gameMap, gameShips[i], x, y);
                gameMap.showMap();
            } else {
                clearScreen();
                // To change a second time the value of a Ship, in case you put it in Vertical and in a position without space
                if (isVertical == true) {setShipOrientation(gameShips[i], isVertical);}
                System.out.println(GameText.errorText[gameOptions.getLanguage()][0]); // "Please, select a valid option"
                i--;
            }
        }
    }


    /**
     * Change the Ship orientation
     * <p>
     * Need a Ship that will be changed, and an isVertical value, gived by the 
     * @param ship
     * @param isVertical
     */
    private void setShipOrientation(Ship ship, boolean isVertical){
        int auxVertical;

        ship.setVertical(isVertical);
        
        if(!ship.isVertical()){
            auxVertical = ship.getLength();
            ship.setLength(ship.getWidth());
            ship.setWidth(auxVertical);
        }
    }


    /**
     * Ask to the user the orientation of the Ship 
     * <p>
     * It will go into a loop until the user puts a value 1(true = Vertica) or 2(false = horizontal) 
     * <p>
     * Auxiliar function, always called after setShipOrientation
     * @see Scanned Value == 1  || Scanned Value == 0
     */
    private boolean requestVertical() {
        sc = new Scanner(System.in);
        boolean isVertical = false;
        int orientation;

        try {
            do {
                System.out.println("\n" + GameText.coordinatesText[gameOptions.getLanguage()][2]);  // "Orientation: Vertical = 1 ; Horizontal = 2"
                orientation = sc.nextInt();
                if (orientation == 1) {
                    isVertical = true;
                } else if (orientation == 2) {
                    isVertical = false;
                } else {
                    System.out.println(GameText.errorText[gameOptions.getLanguage()][0]); // "Please, select a valid option"
                }
            } while (orientation != 1 && orientation != 2);
        } catch (Exception e) {isVertical = requestVertical();}
        return isVertical;
    }


    /**
     * Ask a integer value that cannot be less than 0 or greater than Map Size
     * <p>
     * It will go into a loop until the user puts a value that meets the parameters
     * @since 0 < Scanned Value < Map Size
     */
    private byte setCoordinate(){
        sc = new Scanner(System.in);
        byte coordinate = 0;
        boolean validCoordinate;
        
        try {
            do {
                coordinate = sc.nextByte();

                if (coordinate < 1 || coordinate > gameMap.getMapSize()) {
                    System.out.println(GameText.errorText[gameOptions.getLanguage()][0]); // "Please, select a valid option"
                    validCoordinate = false;
                } else {
                    validCoordinate = true;
                }
            } while (validCoordinate == false);
        } catch (InputMismatchException e) {
            System.out.println(GameText.errorText[gameOptions.getLanguage()][0]); // "Please, select a valid option"
            coordinate = setCoordinate();
        }
        return coordinate;
    }


    /**
     * Evaluates if the ship can be in the gived position taking in account the Orientation
     * <p>
     * Auxiliar function, always called before adjustMapMatrix()
     * @param map
     * @param ship
     * @param x
     * @param y
     * @return AvaiableSpace
     */
    private boolean evaluateShipPosition(Map map, Ship ship, int x, int y){
        int availableSpace = 0;
        boolean confirmedShip = false;
        
        // -1 is caused because the ship width/height should be counted from the value of x/y henceforth and not after it.
        if(x - 1 + ship.getWidth() > map.getMapSize() || y - 1 + ship.getLength() > map.getMapSize()){
            System.out.println(ship.getName() + GameText.errorText[gameOptions.getLanguage()][2]); // ship.name + " out of the map limits"
        } else {
            for (int i = x; i < x + ship.getWidth(); i++) {
                for (int j = y; j < y + ship.getLength(); j++) {
                    if (map.getMatrix()[i-1][j-1][0] == 0) {
                        availableSpace++;
                    }
                }
            }
        }
        if (availableSpace == ship.getLength() * ship.getWidth()){
            confirmedShip = true;
        }
        return confirmedShip;
    }
    

    /**
     * Changes the Map Matrix to write the ShipValue in it
     * <p>
     * Always called before adjustMapMatrix()
     * @param map
     * @param ship
     * @param x
     * @param y
     */
    private void adjustMapMatrix(Map map, Ship ship, int x, int y){
        for (int i = x; i < x + ship.getWidth(); i++) {
            for (int j = y; j < y + ship.getLength(); j++) {
                // the value of "hash - 1010" is a one-digit integer unique for each ship type, thus, appropriate to show in the matrix.
                map.getMatrix()[i-1][j-1][0] = (byte)(ship.getHash() - 999);
            }
        }
    }


    /**
     * Generates random numbers to that the machine will use to put their ships in the map
     */
    public void setRandomShips(){
        Random random = new Random();
        int[] values = new int[3];
        boolean validPosition = false;

        for(int i = 0; i < gameShips.length; i++){

            values[0] = random.nextInt(10) + 1;
            System.out.println(values[0]);
    
            if(values[0] > 5){                                                                           // VERTICAL
                setShipOrientation(gameShips[i], true);
                values[1] = random.nextInt(10) + 1;                                                      // X value
                values[2] = random.nextInt(randomMap.getMapSize() - gameShips[i].getLength() + 1) + 1;   // Y value

            } else {                                                                                     // HORIZONTAL
                setShipOrientation(gameShips[i], false);
                values[1] = random.nextInt(randomMap.getMapSize() - gameShips[i].getLength() + 1) + 1;   // X value
                values[2] = random.nextInt(10) + 1;                                                      // Y value
            }
    
            validPosition = evaluateShipPosition(randomMap, gameShips[i], values[1], values[2]);

            if (validPosition == true) {
                adjustMapMatrix(randomMap, gameShips[i], values[1], values[2]);
            } else {
                i--;
            }
        }
        clearScreen();
        randomMap.showTwoMaps();
    }


    // ! ASSIGN SPACE TO CREATE AND TEST NEW METHODS() ------------------------------------------------------------------------------------------------------------------


    /**
     * Display a basic Missile menu that shows all the missiles and if it´s ready or if it´s ready to shoot now
     */
    public void missileMenu(){
        sc = new Scanner(System.in);
        int userSelection;
        int x, y;

        System.out.println(GameText.coordinatesText[gameOptions.getLanguage()][6]); // "Select missile: "
        for(int i = 0; i < gameMissiles.length; i++){
            if(gameMissiles[i].isReady()){
                System.out.println(i+1 + ". " + GameText.missileText[gameOptions.getLanguage()][i] + GameText.missileText[gameOptions.getLanguage()][29]);
            } else {
                System.out.println(i+1 + ". " + GameText.missileText[gameOptions.getLanguage()][i] + GameText.missileText[gameOptions.getLanguage()][28]);
            }
        }
        userSelection = selectMissile();
        x = setCoordinate();
        y = setCoordinate();

        shootMissile(userSelection, randomMap, gameMap, x, y);
    }

    /**
     * Ask to select a missile and return it´s value only if it´s ready to shoot
     * @return selectedMissile
     */
    public int selectMissile() {
        sc = new Scanner(System.in);
        boolean availableMissile = false;
        int selectedMissile = 0;

        try{
            do {
                selectedMissile = sc.nextInt();
                if (selectedMissile <= gameMissiles.length || selectedMissile > 1) {
                    for (int i = 0; i < gameMissiles.length; i++) {   
                        if ((gameMissiles[i].getHash() - 1999) == selectedMissile) {
                            if (gameMissiles[i].isReady() == true) {
                                availableMissile = true;
                                break;
                            }
                        } else {
                            System.out.println(GameText.missileText[gameOptions.getLanguage()][i] + GameText.missileText[gameOptions.getLanguage()][28].toUpperCase());
                        }
                    }
                } else {
                    System.out.println(GameText.errorText[gameOptions.getLanguage()][0]);
                }
            } while (availableMissile == false);
        }
        catch (Exception e) {
            selectedMissile = selectMissile();            
        }
        return selectedMissile;
    }

    
    /**
     * Switch the turn between the player an the machine
     */
    public void swtichTurns(){

    }


    public void shootMissile(Missile missile, Map rivalMap, Map shootMap, int x, int y){

        // ! LÓGICA CHIDA
        // Game map or machine map
        for (int i = x - 2; i < x + 2; i++) {
            for (int j = y - 2; j < y + 2; j++) {
                if(i < 1 || j < 1 || i > gameMap.getMapSize() || j > gameMap.getMapSize()){
                    if (shootMap.getMatrix()[i][j][1] == 0) {
                        shootMap.getMatrix()[i][j][1] = (byte)missile.getEffectZone()[i+2][j+2];
                    }
                }
            }
        }



        int[][] damage = new int[5][5];
        
        for(int i = x - 2; i < x + 2; i++){
            for(int j = y - 2; j < y - 2; j++){
                if(i < 1 || j < 1 || i > gameMap.getMapSize() || j > gameMap.getMapSize()){
                    damage[i][j] = 0;
                } else if (rivalMap.getMatrix()[i][j][0] != 0){
                    damage[i][j] = 1;
                } else {
                    damage [i][j] = 0;
                }
            }
        }



    }



    // ! ----------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    
    // * SETTERS
    public void setGameOptions(Options gameOptions){
        this.gameOptions.setLanguage(gameOptions.getLanguage());
        this.gameOptions.setSize(gameOptions.getSize());
    }


    // * GETTERS
    public Options getGameOptions(){return gameOptions;}
    

    /**
     * Clear all the code of the termianl written before
     */
    public void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }


}