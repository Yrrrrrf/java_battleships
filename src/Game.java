import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Game {
 
    Options gameOptions;
    Ship[] gameShips;
    Map gameMap;
    Map randomMap;
    Scanner sc;

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
    }


    public void requestShipPosition() {
        byte x, y;
        boolean validPosition;

        clearScreen();
        for (int i = 0; i < gameShips.length; i++) {
            System.out.println(GameText.gameText[gameOptions.getLanguage()][26] + gameShips[i].getName());

            gameMap.showMap();
            
            setShipOrientation(gameShips[i]);

            // SETTING RIGHT COORDINATES
            System.out.println(GameText.gameText[gameOptions.getLanguage()][24]);
            x = setCoordinate();
            System.out.println(GameText.gameText[gameOptions.getLanguage()][25]);
            y = setCoordinate();
            
            validPosition = evaluateShipPosition(gameMap, gameShips[i], x, y);

            if (validPosition == true) {
                adjustMapMatrix(gameMap, gameShips[i], x, y);
                gameMap.showMap();
            } else {
                clearScreen();
                System.out.println(GameText.gameText[gameOptions.getLanguage()][28]);
                i--;
            }
        }
    }


    private void setShipOrientation(Ship ship){
        boolean isVertical;
        int auxVertical;
        
        isVertical = requestVertical();
        ship.setVertical(isVertical);
        
        if(!ship.isVertical()){
            auxVertical = ship.getLength();
            ship.setLength(ship.getWidth());
            ship.setWidth(auxVertical);
        }
    }


    private boolean requestVertical() {
        boolean isVertical = false;
        sc = new Scanner(System.in);
        int orientation;

        try {
            do {
                System.out.println("\n" + GameText.gameText[gameOptions.getLanguage()][23]);
                orientation = sc.nextInt();
                if (orientation == 1) {
                    isVertical = true;
                } else if (orientation == 2) {
                    isVertical = false;
                } else {
                    System.out.println(GameText.gameText[gameOptions.getLanguage()][27]);
                }
            } while (orientation != 1 && orientation != 2);
        } catch (Exception e) {isVertical = requestVertical();}
        return isVertical;
    }


    private byte setCoordinate(){
        sc = new Scanner(System.in);
        byte coordinate = 0;
        boolean validCoordinate;
        
        try {
            do {
                coordinate = sc.nextByte();

                if (coordinate < 1 || coordinate > gameMap.getMapSize()) {
                    System.out.println(GameText.gameText[gameOptions.getLanguage()][27]);
                    validCoordinate = false;
                } else {
                    validCoordinate = true;
                }
            } while (validCoordinate == false);
        } catch (InputMismatchException e) {
            System.out.println(GameText.gameText[gameOptions.getLanguage()][27]);
            coordinate = setCoordinate();
        }
        return coordinate;
    }


    public boolean evaluateShipPosition(Map map, Ship ship, int x, int y){
        int availableSpace = 0;
        boolean confirmedShip = false;
        
        // -1 is caused because the ship width/height should be counted from the value of x/y henceforth and not after it.
        if(x - 1 + ship.getWidth() > map.getMapSize() || y - 1 + ship.getLength() > map.getMapSize()){
            System.out.println(GameText.gameText[gameOptions.getLanguage()][29]);
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
    

    public void adjustMapMatrix(Map map, Ship ship, int x, int y){
        for (int i = x; i < x + ship.getWidth(); i++) {
            for (int j = y; j < y + ship.getLength(); j++) {
                // the value of "hash - 1010" is a one-digit integer unique for each ship type, thus, appropriate to show in the matrix.
                map.getMatrix()[i-1][j-1][0] = (byte)(ship.getHash() - 1010);
            }
        }
    }


    // * SETTERS
    public void setGameOptions(Options gameOptions){
        this.gameOptions.setLanguage(gameOptions.getLanguage());
        this.gameOptions.setSize(gameOptions.getSize());
    }

    // * GETTERS
    public Options getGameOptions(){return gameOptions;}
    

    public void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }


    public void setRandomShips(){
        Random random = new Random();
        int[] values = new int[3];
        boolean validPosition = false;

        for(int i = 0; i < gameShips.length; i++){

            values[0] = random.nextInt(10) + 1;
    
            if(values[0] > 5){                                                                         // VERTICAL
                gameShips[i].setVertical(true);
                values[1] = random.nextInt(10) + 1;                                                     // X value
                values[2] = random.nextInt(randomMap.getMapSize() - gameShips[i].getLength() + 1) + 1;  // Y value

            } else {                                                                                    // HORIZONTAL
                gameShips[i].setVertical(false);
                values[1] = random.nextInt(randomMap.getMapSize() - gameShips[i].getLength() + 1) + 1;   // X value
                values[2] = random.nextInt(10) + 1;                                                     // Y value
            }
    
            validPosition = evaluateShipPosition(randomMap, gameShips[i], values[1], values[2]);

            if (validPosition == true) {
                adjustMapMatrix(randomMap, gameShips[i], values[1], values[2]);
            } else {
                i--;
            }    
        }
        clearScreen();
        randomMap.showMap();
    }

}