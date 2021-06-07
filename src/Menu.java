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
     * Creates the main menu with the options to start a game o view some options
     */
    public void mainMenu(){
        sc = new Scanner(System.in);
        int userInput;
        
        try {
            boolean selectOption;
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
                    case 1: // "Play"
                        mainGame = new Game(mainOptions);
                        mainGame.runGame();
                        break;
                    case 2: // "Options"
                        clearScreen();
                        mainOptions.viewConfig(mainOptions);
                        mainOptions.changeParameter(mainOptions);
                        clearScreen();
                        break;
                    case 3: // "Credits"
                        System.out.println(GameText.gameText[0][0]); // "Reza Campos Fernando Bryan"
                        System.out.println(GameText.gameText[1][0]); // "Álvaro Rodela Leonardo de Jesús"
                        break;
                    case 4: // "Exit"
                        System.out.println(GameText.gameText[3][0]); // "Goodbye"
                        break;
                    default:
                        clearScreen();
                        System.out.println(GameText.errorText[1][0]); // "Please, select a valid option"
                        selectOption = false;
                        break;
                }
            } while (selectOption == false || userInput == 2 || userInput == 3);
        } catch (Exception e) {
            clearScreen();
            System.out.println(GameText.errorText[1][0]); // "Please, select a valid option"
            mainMenu();
        }
        
        // ? Achievements
        // ? Multiplayer
            // ? BLUETOOTH
            // ? ONLINE
        // ?
    }


    /**
     * Clear all the code of the termianl written before
     */
    public void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }


}