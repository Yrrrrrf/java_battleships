import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    Scanner sc;
    Options mainOptions;
    Game mainGame;


    public Menu(){
        mainOptions = new Options();
    }
    
    
    public Menu(int size, int language){
        mainOptions = new Options(size, language);
    }


    /**
     * Initial language selecction menu
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

                System.out.print("-> ");
                userInput = sc.nextInt();
                selectLanguage = true;

                switch(userInput){
                    case 1: mainOptions.setLanguage(0); break;
                    case 2: mainOptions.setLanguage(1); break;
                    case 3: mainOptions.setLanguage(2); break;
                    default:
                        clearScreen();
                        System.out.println(GameText.errorText[1][0]); // "Please, select a valid option"
                        selectLanguage = false;
                        break;
                }
            } while (selectLanguage == false);

        } catch (InputMismatchException e) {
            clearScreen();
            System.out.println(GameText.errorText[1][0]); // "Please, select a valid option"
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


    /**
     * Creates the main menu with the options to start a game o view some options
     */
    public void provitionalMenu(){

        sc = new Scanner(System.in);
        boolean selectOption;
        int userInput;

        try {
            do {
                System.out.println("\n"  +  GameText.menuText[mainOptions.getLanguage()][1].toUpperCase() + "\n"); // "BATTLESHIPS"
                System.out.println("1. " +  GameText.menuText[mainOptions.getLanguage()][2]); // "Play"
                System.out.println("2. " +  GameText.menuText[mainOptions.getLanguage()][3]); // "Options"
                System.out.println("3. " +  GameText.menuText[mainOptions.getLanguage()][4]); // "Credits"
                System.out.println("4. " +  GameText.menuText[mainOptions.getLanguage()][5]); // "Exit"

                System.out.print("-> ");
                userInput = sc.nextInt();
                selectOption = true;

                switch(userInput){
                    case 1: 
                        mainGame = new Game(mainOptions);
                        mainGame.runGame();
                        break;
                    case 2:
                        System.out.println("Wait for future improvements");
                        System.out.println(GameText.gameText[2][0]); // "Go Back"
                        break;
                    case 3:
                        System.out.println(GameText.gameText[0][0]); // "Reza Campos Fernando Bryan"
                        // ! poner los acentos :c
                        System.out.println(GameText.gameText[1][0]); // "Alvaro Rodela Leonardo de Jesús"
                        break;
                    case 4:
                    System.out.println(GameText.gameText[3][0]); // "Goodbye"
                        break;
                    default:
                        System.out.println(GameText.errorText[1][0]); // "Please, select a valid option"
                        selectOption = false;
                        break;
                }
            } while (selectOption == false || userInput == 3);
        } catch (InputMismatchException e) {
            clearScreen();
            System.out.println(GameText.errorText[1][0]); // "Please, select a valid option"
            provitionalMenu();
        }
    }


    /**
     * THE FUTURE START MENU
     */
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