import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    Scanner sc;
    Options mainOptions;
    Game mainGame;


    public Menu(){
        mainOptions = new Options();
    }
    
    public Menu(int size){
        mainOptions = new Options(size);
    }

    /**
     * Initial languaje selecction menu
     */
    public void selectLanguage() {

        sc = new Scanner(System.in);
        int userInput;
        
        try {
            boolean selectLanguage;
            do {
                System.out.println("\nSelect language: ");
                System.out.println("1. Español");
                System.out.println("2. English");
                System.out.println("3. Deutsch");
                System.out.println("4. русский");

                userInput = sc.nextInt();
                selectLanguage = true;

                switch(userInput){
                    case 1: mainOptions.setLanguage(0); break;
                    case 2: mainOptions.setLanguage(1); break;
                    case 3: mainOptions.setLanguage(2); break;
                    case 4: mainOptions.setLanguage(3); break;
                    default:
                        clearScreen();
                        System.out.println(GameText.gameText[0][27]);
                        selectLanguage = false;
                        break;
                }
            } while (selectLanguage == false);

        } catch (InputMismatchException e) {
            clearScreen();
            System.out.println(GameText.gameText[0][27]);
            selectLanguage();
        }
    }

    /**
     * Clear all the code of the termianl written before
     */
    public void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public void provitionalMenu(){

        sc = new Scanner(System.in);
        boolean selectOption;
        int userInput;

        try {
            do {
                System.out.println("\n"  +  GameText.gameText[mainOptions.getLanguage()][1].toUpperCase() + "\n");
                System.out.println("1. " +  GameText.gameText[mainOptions.getLanguage()][2]);
                System.out.println("2. Set computer ships");
                // System.out.println("2. " +  GameText.gameText[mainOptions.getLanguage()][3]);
                System.out.println("3. " +  GameText.gameText[mainOptions.getLanguage()][4]);
                System.out.println("4. " +  GameText.gameText[mainOptions.getLanguage()][10] + "\n");

                userInput = sc.nextInt();
                selectOption = true;

                switch(userInput){
                    case 1: 
                        mainGame = new Game(mainOptions);
                        mainGame.setShipPosition();
                        break;
                    case 2:
                        mainGame = new Game(mainOptions);
                        mainGame.setRandomShips();
                        break;
                    case 3:
                        System.out.println(GameText.gameText[0][0]);
                        System.out.println(GameText.gameText[1][0]);
                        // * ADD A GO BACK SCANNER
                        System.out.println("\n" + GameText.gameText[2][0]);

                        break;
                    case 4:
                        System.out.println(GameText.gameText[3][0]);
                        break;
                    default:
                        System.out.println(GameText.gameText[0][27]);
                        selectOption = false;
                        break;
                }
            } while (selectOption == false);

        } catch (InputMismatchException e) {
            clearScreen();
            System.out.println(GameText.gameText[0][27]);
            provitionalMenu();
        }
    }


    public void mainMenu(){
        // ! PLAY
        // ! OPTIONS
            // ! Change language
            // ! Change SIZE
            // ! Sound
                // ! Effects
                // ! Music
        // ! CREDITS
        // ! EXIT
    
        // ? Achievements
        // ? Multiplayer
            // ? BLUETOOTH 
            // ? ONLINE
        // ?
        
    }

}