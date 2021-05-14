import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Game {
 
    Options gameOptions;
    
    Player[] players;

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
        this.gameOptions = new Options(mainOptions.getSize(), mainOptions.getLanguage());
        setGameOptions(gameOptions);

        players = new Player[2];
        for(int i = 0; i < players.length; i++){
            players[i] = new Player(gameOptions.getSize(), gameOptions.getLanguage());
        }
    }

    public void runGame(){
        // setShipsPostions();
        setRandomShips(players[0].getMap(), players[0].getShips());
        setRandomShips(players[1].getMap(), players[1].getShips());
        //clearScreen();
        players[0].getMap().showTwoMaps();





        gameLoop(players[0], players[1]);
    }


    /**
     * Puts all the ships in the map
     * <p>
     * Calls other functions to get only valid positons 
     */
    public void setShipsPositions(Map map, Ship[] ships) {
        byte x, y;
        boolean validPosition;
        boolean isVertical;

        clearScreen();
        for (int i = 0; i < ships.length; i++) {
            System.out.println(GameText.coordinatesText[gameOptions.getLanguage()][0] + ships[i].getName()); // "You're going to put " + ship.name

            map.showMap();
            // isVertical assign the value of reqwuestVertical
           isVertical = requestVertical(map);
           setShipOrientation(ships[i], isVertical);

            // SETTING RIGHT COORDINATES
            System.out.println(GameText.coordinatesText[gameOptions.getLanguage()][3]); // "Introduce X coordinate"
            x = setCoordinate(map);
            System.out.println(GameText.coordinatesText[gameOptions.getLanguage()][4]); // "Introduce Y coordinate"
            y = setCoordinate(map);
            
            validPosition = evaluateShipPosition(map, ships[i], x, y);

            if (validPosition == true) {
                adjustMapMatrix(map, ships[i], x, y, (byte)(i + 1));
                map.showMap();
            } else {
                clearScreen();
                // To change a second time the value of a Ship, in case you put it in Vertical and in a position without space
                if (isVertical == true) {setShipOrientation(ships[i], isVertical);}
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
    private boolean requestVertical(Map map) {
        sc = new Scanner(System.in);
        boolean isVertical = false;
        int orientation;

        try {
            do {
                System.out.println("\n" + GameText.coordinatesText[gameOptions.getLanguage()][2]);  // "Orientation: Vertical = 1 ; Horizontal = 2"
                System.out.print("-> ");
                orientation = sc.nextInt();
                if (orientation == 1) {
                    isVertical = true;
                } else if (orientation == 2) {
                    isVertical = false;
                } else {
                    clearScreen();
                    System.out.println(GameText.errorText[gameOptions.getLanguage()][0]); // "Please, select a valid option"
                    map.showTwoMaps();
                }
            } while (orientation != 1 && orientation != 2);
        } catch (Exception e) {
            clearScreen();
            map.showTwoMaps();
            isVertical = requestVertical(map);
        }
        return isVertical;
    }


    /**
     * Ask a integer value that cannot be less than 0 or greater than Map Size
     * <p>
     * It will go into a loop until the user puts a value that meets the parameters
     * @since 0 < Scanned Value < Map Size
     */
    private byte setCoordinate(Map map){
        sc = new Scanner(System.in);
        byte coordinate = 0;
        boolean validCoordinate;
        
        try {
            do {
                System.out.print("-> ");
                coordinate = sc.nextByte();

                if (coordinate < 1 || coordinate > map.getMapSize()) {
                    clearScreen();
                    System.out.println(GameText.errorText[gameOptions.getLanguage()][0]); // "Please, select a valid option"
                    map.showTwoMaps();
                    validCoordinate = false;
                } else {
                    validCoordinate = true;
                }
            } while (validCoordinate == false);
        } catch (InputMismatchException e) {
            clearScreen();
            System.out.println(GameText.errorText[gameOptions.getLanguage()][0]); // "Please, select a valid option"
            map.showTwoMaps();
            coordinate = setCoordinate(map);
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


            //System.out.println(ship.getName() + GameText.errorText[gameOptions.getLanguage()][2]); // ship.name + " out of the map limits"
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
    private void adjustMapMatrix(Map map, Ship ship, int x, int y, byte identifier){
        for (int i = x; i < x + ship.getWidth(); i++) {
            for (int j = y; j < y + ship.getLength(); j++) {
                // the value of "hash - 1010" is a one-digit integer unique for each ship type, thus, appropriate to show in the matrix.
                map.getMatrix()[i-1][j-1][0] = identifier;
            }
        }
    }


    /**
     * Generates random numbers to that the machine will use to put their ships in the map
     */
    public void setRandomShips(Map map, Ship[] ships){
        Random random = new Random();
        int[] values = new int[3];
        boolean validPosition = false;

        for(int i = 0; i < ships.length; i++){

            values[0] = random.nextInt(10) + 1;
            //System.out.println(values[0]);
    
            if(values[0] > 5){                                                                              // VERTICAL
                setShipOrientation(ships[i], true);
                values[1] = random.nextInt(10) + 1;                                                         // X value
                values[2] = random.nextInt(map.getMapSize() - ships[i].getLength() + 1) + 1;            // Y value

            } else {                                                                                        // HORIZONTAL
                setShipOrientation(ships[i], false);
                values[1] = random.nextInt(map.getMapSize() - ships[i].getLength() + 1) + 1;            // X value
                values[2] = random.nextInt(10) + 1;                                                         // Y value
            }
    
            validPosition = evaluateShipPosition(map, ships[i], values[1], values[2]);

            if (validPosition == true) {
                adjustMapMatrix(map, ships[i], values[1], values[2], (byte)(i + 1));
            } else {
                i--;
            }
        }
        // clearScreen();
        // rivalMap.showTwoMaps();
    }


    // ! ASSIGNED SPACE TO CREATE AND TEST NEW METHODS() ------------------------------------------------------------------------------------------------------------------


    /**
     * Asks to select a missile and return it's value only if it's ready to shoot
     * @return selectedMissile
     */
    public int selectMissile(Map map, Missile[] missiles) {
        sc = new Scanner(System.in);
        boolean availableMissile = false;
        int selectedMissile = 0;

        try{
            do {
                clearScreen();
                map.showTwoMaps();
                System.out.println(GameText.coordinatesText[gameOptions.getLanguage()][6]); // "Select missile: "
                
                for(int k = 0; k < missiles.length; k++){
                    if(missiles[k].isReady()){
                        System.out.println( (k+1) + ". " + 
                                            missiles[k].getName() + "  " +
                                            GameText.missileText[gameOptions.getLanguage()][29]); // "Ready       " + "missiles[k].getName()"
                    } else {
                        System.out.println( (k+1) + ". " + 
                                            missiles[k].getName() +  "  " +
                                            GameText.missileText[gameOptions.getLanguage()][28]); // "Loading...  " + "missiles[k].getName()"
                    }
                }

                System.out.print("-> ");
                selectedMissile = sc.nextInt() - 1;

                if (selectedMissile >= 0 && selectedMissile < missiles.length) {
                    for (int i = 0; i < missiles.length; i++) {
                        if (i == selectedMissile && missiles[i].isReady()) {
                            availableMissile = true;
                            break;
                        } else continue;
                    }
                } else {
                    clearScreen();
                    map.showTwoMaps();
                    System.out.println(GameText.errorText[gameOptions.getLanguage()][0]); // "Please, select a valid option."
                }
            } while (availableMissile == false);
        }
        catch (Exception e) {
            clearScreen();
            map.showTwoMaps();
            selectedMissile = selectMissile(map, missiles);
        }
        return selectedMissile;
    }


    // ! NOT COMPLETED YET --------------------------------------------------------------------------------------------------------------------------

    public void setMissilesCooldown(Missile[] missiles) {

        for(int i = 0; i < missiles.length; i++){
            if(missiles[i].isReady() == false){

                if(missiles[i].getCooldown() > 0) {
                    missiles[i].setCooldown(missiles[i].getCooldown() - 1); 
                } else {
                    missiles[i].setReady(true);
                    missiles[i].setCooldown(missiles[i].getType().getCooldown());
                }
            }
        }
    }

    
    public void gameLoop(Player player, Player computer){
        sc = new Scanner(System.in);
        //  while(player.getDestroyedShips() != player.getShips().length || computer.getDestroyedShips() != computer.getShips().length){

            setMissilesCooldown(player.getMissiles());
            setMissilesCooldown(computer.getMissiles());

            playerTurn(player.getMissiles(), player.getMap(), computer.getMap(), player.getShips(), computer.getShips());
            evaluateShipsDamage(computer);

            computerTurn(computer.getMissiles(), computer.getMap(), player.getMap(), computer.getShips(), player.getShips());
            evaluateShipsDamage(player);

            System.out.println("Player Map");
            player.getMap().showTwoMaps();
            System.out.println("\nRival Map");
            computer.getMap().showTwoMaps();

        // }
        // if(computer.getDestroyedShips() == computer.getShips().length){
        //     //clearScreen();
        //     System.out.println("\nYou won.\n");
        // } else if (player.getDestroyedShips() == player.getShips().length){
        //     //clearScreen();
        //     System.out.println("\nThe computer won.\n");
        // }
    }

        
    public void playerTurn(Missile[] playerMissiles, Map playerMap, Map computerMap, Ship[] playerShips, Ship[] computerShips) {
        int userSelection;
        int x, y;
        
        userSelection = selectMissile(playerMap, playerMissiles);
            
        //clearScreen();
        //playerMap.showTwoMaps();
        
        // SETTING SHOOT COORDINATES
        System.out.println(GameText.coordinatesText[gameOptions.getLanguage()][3]); // "Introduce X coordinate"
        x = setCoordinate(playerMap);
        System.out.println(GameText.coordinatesText[gameOptions.getLanguage()][4]); // "Introduce Y coordinate"
        y = setCoordinate(playerMap);

        shootMissile(playerMissiles[userSelection], playerMap, computerMap, computerShips, x, y);
    }
    
    
    public void computerTurn(Missile[] computerMissiles, Map computerMap, Map playerMap, Ship[] computerShips, Ship[] playerShips) {
        Random random = new Random();
        int[] values = new int[3];
        boolean availableMissile = false;

        do {
            values[0] = random.nextInt(computerMissiles.length);

            for (int i = 0; i < computerMissiles.length; i++) {
                if (i == values[0] && computerMissiles[i].isReady()) {
                    availableMissile = true;
                    break;
                } else continue;
            }
        } while(availableMissile == false);

        values[1] = random.nextInt(playerMap.getMapSize()) + 1; // x
        values[2] = random.nextInt(playerMap.getMapSize()) + 1; // y

        shootMissile(computerMissiles[values[0]], computerMap, playerMap, playerShips, values[1], values[2]);
    }
    

    public void evaluateShipsDamage(Player player) {
        
        for(int i = 0; i < player.getShips().length; i++) {
            if(player.getShips()[i].isDestroyed()){
                continue;
            } else if (player.getShips()[i].getDamage() == player.getShips()[i].getLength() * player.getShips()[i].getWidth()){
                player.getShips()[i].setDestroyed(true);
                player.destroyShip();
            } else continue;
        }
    }
    
    
    public void shootMissile(Missile missile, Map shooterMap, Map rivalMap, Ship[] rivalShips, int x, int y) {
        // int xIndex = 0;
        // int yIndex = 0;
        // for(int i = 0; i < 5; i++) {
        //     for(int j = 0; j < 5; j++) {
        //         xIndex = (x-1) + i - 2;  //x+i-3
        //         yIndex = (y-1) + j - 2;  //y+j-3
        //         if(xIndex < 1 || yIndex < 1 || xIndex >= rivalMap.getMapSize() || yIndex >= rivalMap.getMapSize()){
        //             //continue;
        //         } else {
        //             if (shooterMap.getMatrix()[xIndex][yIndex][1] == 0) {
        //                 shooterMap.getMatrix()[xIndex][yIndex][1] = missile.getEffectZone()[i][j];
        //             }
        //         }
        //     }
        // }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                try {
                        // x + i - 3 Beacuse:
                        // -2 by to put x, y to be the middle of the effectZone
                        // -1 cause the matrix starts counting in 0, so when you select (1, 1) to the matrix it will be (0, 0)
                    if (missile.effectZone[i][j] !=0) {
                        shooterMap.getMatrix()[x + i - 3][y + j - 3][1] = (byte)missile.getEffectZone()[i][j];
                    }
                    if (rivalMap.getMatrix()[x + i - 3][y + j - 3][0] != 0) {
                        rivalMap.getMatrix()[x + i - 3][y + j - 3][0] = (byte)-missile.getEffectZone()[i][j];
                    }
                } catch (Exception e) {}
            }
        }


        // 

        for(int i = x - 2; i <= x + 2; i++) {
            for(int j = y - 2; j <= y - 2; j++) {
                
                if(i < 1 || j < 1 || i >= rivalMap.getMapSize() || j >= rivalMap.getMapSize()) {
                    continue;
                } else if (rivalMap.getMatrix()[i][j][0] != 0) {
                    int a = rivalMap.getMatrix()[i][j][0];

                    // for(int a = 1; a <= rivalShips.length; a++){                        
                    //     if(a == rivalMap.getMatrix()[i][j][0]){
                    System.out.println(GameText.coordinatesText[gameOptions.getLanguage()][7] +
                    GameText.shipText[gameOptions.getLanguage()][rivalShips[a-1].getType().getHash()-1000] +
                    " (" + rivalShips[a-1].getType().getLength() + " x " + rivalShips[a-1].getType().getWidth() + ")");
                    
                    rivalShips[a-1].sufferDamage();
                    }
                    //}
                    // } else {
                    //     continue;
                    // }
            }
        }
        //clearScreen();
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