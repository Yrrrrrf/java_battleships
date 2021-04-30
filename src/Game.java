import java.util.InputMismatchException;
import java.util.Scanner;
//import java.util.Random;

public class Game {
 
    Ship[] gameShips;
    Map gameMap;
    Options gameOptions;
    Scanner sc;

    public Game(Options mainOptions) {
        
        this.gameOptions = new Options(mainOptions.getSize());
        setGameOptions(gameOptions);

        gameMap = new Map(gameOptions.getSize());

        gameMap.showMap();

        gameShips = new Ship[3];
        for (int i = 0; i < gameShips.length; i++) {
            gameShips[i] = new Ship();
        }
        
        gameShips[0].setShip(gameOptions.getLanguage(), ShipType.CARRIER);
        gameShips[1].setShip(gameOptions.getLanguage(), ShipType.CRUISER);
        gameShips[2].setShip(gameOptions.getLanguage(), ShipType.CRUISER);
        // gameShips[3].setShip(gameOptions.getLanguage(), ShipType.DESTROYER);
        // gameShips[4].setShip(gameOptions.getLanguage(), ShipType.FRIGATE);
        // gameShips[5].setShip(gameOptions.getLanguage(), ShipType.FRIGATE);
        // gameShips[6].setShip(gameOptions.getLanguage(), ShipType.VESSEL);
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
            
            validPosition = evaluateShipPosition(gameShips[i], x, y);

            if (validPosition == true) {
                adjustMapMatrix(gameShips[i], x, y);
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


    public boolean evaluateShipPosition(Ship ship, int x, int y){
        int availableSpace = 0;
        boolean confirmedShip = false;
        
        // -1 is caused by the matrix that starts the count in 0
        if(x + ship.getWidth() - 1 >= gameMap.getMapSize() || y + ship.getLength() - 1 > gameMap.getMapSize()){
            System.out.println(GameText.gameText[gameOptions.getLanguage()][29]);
        } else {
            for (int i = x; i < x + ship.getWidth(); i++) {
                for (int j = y; j < y + ship.getLength(); j++) {
                    if (gameMap.getMatrix()[i-1][j-1][0] == 0) {
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
    

    public void adjustMapMatrix(Ship ship, int x, int y){
        for (int i = x; i < x + ship.getWidth(); i++) {
            for (int j = y; j < y + ship.getLength(); j++) {
                // hash-1010 cause the value of the hash
                gameMap.getMatrix()[i-1][j-1][0] = (byte)(ship.getHash() - 1010);
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


}