import java.util.InputMismatchException;
import java.util.Scanner;
//import java.util.Random;

public class Game {
 
    Ship[] gameShips;
    Map gameMap;
    Options gameOptions;
    Scanner sc;

    public Game(Options gameOptions) {
        /*
        AIRCRAFT CARRIER    -> 1 barco longitud 5
        CRUISER             -> 2 barco longitud 4
        DESTROYERS          -> 1 barco longitud 3
        FRIGATES            -> 2 barco longitud 2
        VESSELS             -> 1 barco longitud 1
        */
        this.gameOptions = new Options();
        setGameOptions(gameOptions);
        
        // ! PUT THE VALUE, IT CAN´T READ THE gameOptions.get Height/Width () methods
        gameMap = new Map(10, 10);

        gameShips = new Ship[1];
        for (int i = 0; i < 1; i++) {
            gameShips[i] = new Ship();
        }
        gameShips[0].setShip(gameOptions.getGameText()[gameOptions.getLanguage()][11], 5, 1, ShipType.CARRIER);
        /*
        gameShips[1].setShip(gameOptions.getGameText()[gameOptions.getLanguage()][12], 4, 1, ShipType.CRUISER);
        gameShips[2].setShip(gameOptions.getGameText()[gameOptions.getLanguage()][12], 4, 1, ShipType.CRUISER);
        gameShips[3].setShip(gameOptions.getGameText()[gameOptions.getLanguage()][13], 3, 1, ShipType.DESTROYER);
        gameShips[4].setShip(gameOptions.getGameText()[gameOptions.getLanguage()][14], 2, 1, ShipType.FRIGATE);
        gameShips[5].setShip(gameOptions.getGameText()[gameOptions.getLanguage()][14], 2, 1, ShipType.FRIGATE);
        gameShips[6].setShip(gameOptions.getGameText()[gameOptions.getLanguage()][15], 1, 1, ShipType.VESSEL);
        */
    }


    public void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public boolean fixShipPosition(Ship ship, int x, int y){
        int availableSpace = 0;
        byte shipValue = 0;

        for (int i = x; i < x + ship.getWidth(); i++) {
            for (int j = y; j < y + ship.getHeight(); j++) {

                if (gameMap.getMatrix()[i-1][j-1][0] == 0) {
                    availableSpace++;
                }
            }
        }
        
        if (availableSpace == ship.getHeight() * ship.getWidth()) {
            switch (ship.getShipType()) {
                case VESSEL:     shipValue = 1; break;
                case FRIGATE:    shipValue = 2; break;
                case DESTROYER:  shipValue = 3; break;
                case CRUISER:    shipValue = 4; break;
                case CARRIER:    shipValue = 5; break;
            }
            for (int i = y; i < y + ship.getWidth(); i++) {
                for (int j = x; j < x + ship.getHeight(); j++) {
                    gameMap.getMatrix()[i-1][j-1][0] = shipValue;
                }
            }
        } else {
            return false;
        }
        return true;
    }
    

    public void setGameOptions(Options gameOptions){
        this.gameOptions.setGameText(gameOptions.getGameText());
        this.gameOptions.setLanguage(gameOptions.getLanguage());
        this.gameOptions.setHeight(gameOptions.getHeight());
        this.gameOptions.setWidth(gameOptions.getWidth());
    }


    public Options getGameOptions(){return gameOptions;}


    public void requestShipPosition() {
        byte x, y;
        boolean vertical;
        int auxVertical;

        gameMap.showMap();

        for (int i = 0; i < gameShips.length; i++) {
            System.out.println(gameOptions.getGameText()[gameOptions.getLanguage()][21] + gameShips[i].getName());

            // SETTING RIGHT ORIENTATION
            vertical = requestOrientation();
            gameShips[i].setVertical(vertical);
            
            if(gameShips[i].getVertical()){
                auxVertical = gameShips[i].getHeight();
                gameShips[i].setHeight(gameShips[i].getWidth());
                gameShips[i].setWidth(auxVertical);
            }

            // SETTING RIGHT COORDINATES
            System.out.println(gameOptions.getGameText()[gameOptions.getLanguage()][19]);
            x = setCoordinate();
            System.out.println(gameOptions.getGameText()[gameOptions.getLanguage()][20]);
            y = setCoordinate();

            

            if (gameShips[i].getHeight() + x > 11) {
                System.out.println("Estás pendejo morro");
            } else {
                fixShipPosition(gameShips[i], x, y);
            }
            gameMap.showMap();
        }
    }


    public boolean requestOrientation() {
        boolean vertical = false;
        sc = new Scanner(System.in);
        int orientation;

        try {
            do {
                System.out.println(gameOptions.getGameText()[gameOptions.getLanguage()][18]);
                orientation = sc.nextInt();
                if (orientation == 1) {
                    vertical = true;
                } if (orientation == 2) {
                    vertical = false;
                } else {
                    System.out.println(gameOptions.getGameText()[gameOptions.getLanguage()][22]);
                }
            } while (orientation != 1 && orientation != 2);
        } catch (Exception e) {requestOrientation();}
        return vertical;
    }


    private byte setCoordinate(){
        sc = new Scanner(System.in);
        byte coordinate = 0;
        boolean posiblePlace;
        
        try { 
            do {
                coordinate = sc.nextByte();
                posiblePlace = true;

                if (coordinate < 1 ||coordinate > gameMap.getMapOptions().getHeight()) {
                    System.out.println(gameOptions.getGameText()[gameOptions.getLanguage()][23]);
                    posiblePlace = false;
                };
            } while (posiblePlace == false);
        } catch (InputMismatchException e) {
            System.out.println(gameOptions.getGameText()[gameOptions.getLanguage()][22]);
            setCoordinate();
        }
        return coordinate;
    }





}