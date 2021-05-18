import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Game {
 
    Options gameOptions;
    Player[] players;
    Scanner sc;


    /**
     * Start a new game with the Options that the user gives (using the Options class that can the changed in the Main Menu)
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
    

    /**
     * Runs the game
     */
    public void runGame(){
        // setShipsPostions();
        setRandomShips(players[0].getMap(), players[0].getShips());
        setRandomShips(players[1].getMap(), players[1].getShips());
        gameLoop(players[0], players[1]);
    }


    /**
     * Places all the ships on the map
     * <p>
     * Calls other functions to receive only valid positons 
     */
    public void setShipsPositions(Map map, Ship[] ships) {
        byte x, y;
        boolean validPosition;
        boolean isVertical;

        clearScreen();
        for (int i = 0; i < ships.length; i++) {
            System.out.println(GameText.coordinatesText[gameOptions.getLanguage()][0] + ships[i].getName()); // "You're going to put " + ship.name

            map.showMap();
           isVertical = requestVertical(map);
           setShipOrientation(ships[i], isVertical);

            // SETTING RIGHT COORDINATES
            System.out.println(GameText.coordinatesText[gameOptions.getLanguage()][3]);     // "Introduce X coordinate"
            x = setCoordinate(map);
            System.out.println(GameText.coordinatesText[gameOptions.getLanguage()][4]);     // "Introduce Y coordinate"
            y = setCoordinate(map);
            
            validPosition = evaluateShipPosition(map, ships[i], x, y);

            if (validPosition == true) {
                adjustMapMatrix(map, ships[i], x, y, (byte)(i + 1));
                map.showMap();
            } else {
                clearScreen();
                // To change a second time the value of a Ship, in case you put it in Vertical and in a position without space
                if (isVertical == true) {setShipOrientation(ships[i], isVertical);}
                System.out.println(GameText.errorText[gameOptions.getLanguage()][0]);       // "Please, select a valid option"
                i--;
            }
        }
    }


    /**
     * Change the Ship orientation
     * <p>
     * Need a Ship that will be changed, and an isVertical value, given by the 
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
     * Asks the user the orientation of the Ship 
     * <p>
     * It will execute a loop until the user gives a value 1(true = vertical) or 2(false = horizontal) 
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
     * Asks for an integer value that cannot be lower than 0 or higher than Map Size
     * <p>
     * It will execute a loop until the user gives a value that meets the parameters
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
     * Evaluates if the ship can be in the given position considering the Orientation
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
        if(!(x - 1 + ship.getWidth() > map.getMapSize() || y - 1 + ship.getLength() > map.getMapSize())){
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
     * Assigns different values for every ship on the Map Matrix
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
     * Generates random numbers that the machine will use to put its ships on the map
     */
    public void setRandomShips(Map map, Ship[] ships){
        Random random = new Random();
        int[] values = new int[3];
        boolean validPosition = false;

        for(int i = 0; i < ships.length; i++){
            values[0] = random.nextInt(10) + 1;
            if(values[0] > 5){                                                                      // VERTICAL
                setShipOrientation(ships[i], true);
                values[1] = random.nextInt(10) + 1;                                                 // X value
                values[2] = random.nextInt(map.getMapSize() - ships[i].getLength() + 1) + 1;        // Y value

            } else {                                                                                // HORIZONTAL
                setShipOrientation(ships[i], false);
                values[1] = random.nextInt(map.getMapSize() - ships[i].getLength() + 1) + 1;        // X value
                values[2] = random.nextInt(10) + 1;                                                 // Y value
            }

            validPosition = evaluateShipPosition(map, ships[i], values[1], values[2]);

            if (validPosition == true) {
                adjustMapMatrix(map, ships[i], values[1], values[2], (byte)(i + 1));
            } else {
                i--;
            }
        }
    }


    /**
     * Asks for missile selection and return it's value only if it's ready to shoot
     * @return selectedMissile
     */
    public int selectMissile(Map map, Missile[] missiles) {
        sc = new Scanner(System.in);
        boolean availableMissile = false;
        int selectedMissile = 0;

        try{
            do {
                System.out.println(GameText.coordinatesText[gameOptions.getLanguage()][6]);          // "Select missile: "
                
                for(int k = 0; k < missiles.length; k++){
                    if(missiles[k].isReady()){
                        System.out.println( (k+1) + ". " + missiles[k].getName() + "  " +
                                            GameText.missileText[gameOptions.getLanguage()][29]);   // "Ready       " + "missiles[k].getName()"
                    } else {
                        System.out.println( (k+1) + ". " + missiles[k].getName() +  "  " +
                                            GameText.missileText[gameOptions.getLanguage()][28]);   // "Loading...  " + "missiles[k].getName()"
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


    /**
     * Change the missiles cooldown in every turn. When cooldown is == 0 the missile will be set as Ready
     * <p>
     * This function depends on gameLoop()
     * @param missiles
     */
    private void setMissilesCooldown(Missile[] missiles) {
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


    /**
     * Starts the game Loop that allows the players to shoot a missle on every turn
     * @param player
     * @param computer
     */
    public void gameLoop(Player player, Player computer){
        sc = new Scanner(System.in);
        while(player.getDestroyedShips() != player.getShips().length && computer.getDestroyedShips() != computer.getShips().length){

            setMissilesCooldown(player.getMissiles());
            setMissilesCooldown(computer.getMissiles());

            //clearScreen();

            System.out.println(GameText.gameText[gameOptions.getLanguage()][1]); // "Player Map""
            player.getMap().showTwoMaps();
            
            playerTurn(player.getMissiles(), player.getMap(), computer.getMap(), player.getShips(), computer.getShips());
            evaluateShipsDamage(computer);

            computerTurn(computer.getMissiles(), computer.getMap(), player.getMap(), computer.getShips(), player.getShips());
            evaluateShipsDamage(player);
        }

        clearScreen();

        if(computer.getDestroyedShips() == computer.getShips().length){
            System.out.println(GameText.gameText[gameOptions.getLanguage()][2]); // "YOU WIN!"
            player.getMap().showTwoMaps();
        } else {
            System.out.println(GameText.gameText[gameOptions.getLanguage()][3]); // "The Machine Wins. You Lose"
            computer.getMap().showTwoMaps();
        }
    }


    /**
     * Allow the player to shoot a missile on the rival's map
     * @param playerMissiles
     * @param playerMap
     * @param computerMap
     * @param playerShips
     * @param computerShips
     */
    private void playerTurn(Missile[] playerMissiles, Map playerMap, Map computerMap, Ship[] playerShips, Ship[] computerShips) {
        int userSelection;
        int x, y;
        
        userSelection = selectMissile(playerMap, playerMissiles);

        // SETTING SHOOT COORDINATES
        System.out.println(GameText.coordinatesText[gameOptions.getLanguage()][3]); // "Introduce X coordinate"
        x = setCoordinate(playerMap);
        System.out.println(GameText.coordinatesText[gameOptions.getLanguage()][4]); // "Introduce Y coordinate"
        y = setCoordinate(playerMap);

        shootMissile(playerMissiles[userSelection], playerMap, computerMap, computerShips, x - 1, y - 1);
    }
    

    /**
     * Set a random available missile, and random shoot coordinates to the computer 
     * @param computerMissiles
     * @param computerMap
     * @param playerMap
     * @param computerShips
     * @param playerShips
     */
    private void computerTurn(Missile[] computerMissiles, Map computerMap, Map playerMap, Ship[] computerShips, Ship[] playerShips) {
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

        values[1] = random.nextInt(playerMap.getMapSize()); // x
        values[2] = random.nextInt(playerMap.getMapSize()); // y
        
        shootMissile(computerMissiles[values[0]], computerMap, playerMap, playerShips, values[1], values[2]);
    }
    

    /**
     * Verifies the damage done to each player's ship
     * <p>
     * Set it asDestroyed when the damage is the same as the ship area.
     * @param player
     */
    private void evaluateShipsDamage(Player player) {
        for(int i = 0; i < player.getShips().length; i++) {
            if(player.getShips()[i].isDestroyed()){
                continue;
            } else if (player.getShips()[i].getDamage() == player.getShips()[i].getLength() * player.getShips()[i].getWidth()){
                player.getShips()[i].setDestroyed(true);
                player.destroyShip();
            } else continue;
        }
    }
    

    /**
     * Assigns values to both Maps (player and computer) according to the positions of the ships and the effect-zone of the missile
     * <p>
     * The values represent map regions hit: 1 for "water" and a negative value for a ship.
     * <p>
     * Shows when the player hits a rival ship
     * @param missile
     * @param shooterMap
     * @param rivalMap
     * @param rivalShips
     * @param x
     * @param y
     */
    private void shootMissile(Missile missile, Map shooterMap, Map rivalMap, Ship[] rivalShips, int x, int y) {
        for (int i = x - 2; i <= x + 2; i++) {
            for (int j = y - 2; j <= y + 2; j++) {
                if (i < 0 || j < 0 || i > rivalMap.getMapSize() - 1 || j > rivalMap.getMapSize() - 1) {
                    continue;
                } else {
                    if (missile.effectZone[i-(x-2)][j-(y-2)] == 1) {
                        if (rivalMap.getMatrix()[i][j][0] > 0) {                // If there's a not damaged ship part here
                            int a = rivalMap.getMatrix()[i][j][0] - 1;

                            if (shooterMap == players[0].getMap()) {
                                System.out.println(GameText.coordinatesText[gameOptions.getLanguage()][7] + 
                                GameText.shipText[gameOptions.getLanguage()][rivalShips[a].getType().getHash()-1000] + 
                                " (" + rivalShips[a].getType().getLength() + " x " + rivalShips[a].getType().getWidth() + ")");
                                // Succesful impact in "shipName" (length x width)
                            }

                            rivalShips[a].sufferDamage();

                            shooterMap.getMatrix()[i][j][1] = (byte)-(a + 1);   // The shooter hit a ship
                            rivalMap.getMatrix()[i][j][0] = -1;                 // The rival has been hit
                        } else {
                            shooterMap.getMatrix()[i][j][1] = 1;
                        }
                    }
                }
            }
        }
        // To restart the missile cooldown
        missile.setReady(false);
    }
    
    
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
    private void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }


}