import java.util.InputMismatchException;
import java.util.Scanner;

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

        gameShips = new Ship[7];
        for (int i = 0; i < 7; i++) {
            gameShips[i] = new Ship();
        }

        gameMap = new Map(gameOptions.getHeight(), gameOptions.getWidth());

        gameShips[0].setShip(gameOptions.getGameText()[gameOptions.getLanguage()][11], 5, 1, ShipType.CARRIER);
        gameShips[1].setShip(gameOptions.getGameText()[gameOptions.getLanguage()][12], 4, 1, ShipType.CRUISER);
        gameShips[2].setShip(gameOptions.getGameText()[gameOptions.getLanguage()][12], 4, 1, ShipType.CRUISER);
        gameShips[3].setShip(gameOptions.getGameText()[gameOptions.getLanguage()][13], 3, 1, ShipType.DESTROYER);
        gameShips[4].setShip(gameOptions.getGameText()[gameOptions.getLanguage()][14], 2, 1, ShipType.FRIGATE);
        gameShips[5].setShip(gameOptions.getGameText()[gameOptions.getLanguage()][14], 2, 1, ShipType.FRIGATE);
        gameShips[6].setShip(gameOptions.getGameText()[gameOptions.getLanguage()][15], 1, 1, ShipType.VESSEL);
    }

    public void setShipsPositions() {
        //sc = new Scanner(System.in);
        int userInputX;
        int userInputY;
        boolean confirmedShip;

  // weeeee
  // no me compila esta madre xD
  
  //Hiciste el commit?
// nel
//

// seas mamon
// jajaja lo estaba arreglando

//deja que lo vea we... has un commit para que tenga todo actualizado

// ya casi queda we
// va va pues, ya te lo dejo, a ver si encuentras qué falla.
    try {
            for (int k = 0; k < 7; k++) {
                
                gameMap.showMap();

                System.out.println("\n" + gameOptions.getGameText()[gameOptions.getLanguage()][18]);
                userInputX = sc.nextInt();

                System.out.println("\n" + gameOptions.getGameText()[gameOptions.getLanguage()][19]);
                userInputY = sc.nextInt();

                confirmedShip = fixShipPosition(gameShips[k], userInputX, userInputY);

                if (confirmedShip == true){
                    clearScreen();
                    continue;
                } else {
                    clearScreen();
                    System.out.println("This is not a valid position.");
                    k--;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Please, introduce a valid number.");
        }
        //sc.close();
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
                else {
                    break;
                }
            }
        }
        
        if (availableSpace == ship.getHeight() * ship.getWidth()) {

            switch (ship.getShipType()) {
                case CARRIER:    shipValue = 5; break;
                case CRUISER:    shipValue = 4; break;
                case DESTROYER:  shipValue = 3; break;
                case FRIGATE:    shipValue = 2; break;
                case VESSEL:     shipValue = 1; break;
            }
    
            for (int i = x; i < x + ship.getWidth(); i++) {
                for (int j = y; j < y + ship.getHeight(); j++) {
                    gameMap.getMatrix()[i-1][j-1][0] = shipValue;
                }
            }
        } else {
            return false;
        }

        return true;
    }



    // ! FUNCIÓN PITERA... NO SIRVE PARA UN CULO!!!!!!
    // * SI VA A SERVIR WE uwu
    // ya no le cambies nada culero, ya voy a hacer el commit.
    public void setShitPosition(Ship ship) {
        sc = new Scanner(System.in);
        boolean free = false;
        try {
            boolean freex = false;
            do {
                int x = sc.nextInt();
                if (x >= 0 || x < gameMap.mapOptions.getWidth()) {freex = true;}
            } while (freex == false);
            try {
                boolean freey = false;
                do {
                    int y = sc.nextInt();
                    if (y >= 0 || y < gameMap.mapOptions.getHeight()) {freey = true;}
                } while (freey == false);
                try {
                    do {
                        
                    } while (free);
                    try {
                        do {
                            if ((gameMap.getMatrix()[x][y][0]) == 0) {
            
                                for(int i = x; i <= x + ship.getWidth(); i++){
                                    for(int j = y; j <= y + ship.getHeight(); j++){  
                                        if ((gameMap.getMatrix()[x][y][0]) == 0) {
                                            
                                        } else {
                                            break;
                                        }
                                    }
                                }
                                free = true;
            
                            } else {
                                System.out.println("there´s a ship already");
                            }
                        } while (free == false);
                    } catch (InputMismatchException e) {setShipPosition(ship);}
                } catch (InputMismatchException e) {}
            } catch (InputMismatchException e) {}
        } catch (InputMismatchException e) {}
    } 
    
    public void setGameOptions(Options gameOptions){
        this.gameOptions.setGameText(gameOptions.getGameText());
        this.gameOptions.setLanguage(gameOptions.getLanguage());
        this.gameOptions.setHeight(gameOptions.getHeight());
        this.gameOptions.setWidth(gameOptions.getWidth());
    }

    public Options getGameOptions(){return gameOptions;}

}
