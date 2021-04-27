import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    Scanner sc;
    Options mainOptions;


    public Menu(){
        mainOptions = new Options();
        mainOptions.setGameText();
    }
    
    public Menu(int language){
        mainOptions = new Options(language);
        mainOptions.setGameText();
    }

    /***
     * Inicial language selection menu
     */
    public void selectLanguage() {
        sc = new Scanner(System.in);
        boolean selectLanguage = false;

        try {
            do {
                clearScreen();
                selectLanguage = true;
                System.out.println("\nSelect language: ");
                System.out.println("1. Español");
                System.out.println("2. English");
                System.out.println("3. Deutsch");
                System.out.println("4. русский");

                mainOptions.setLanguage(sc.nextInt());
                switch(mainOptions.getLanguage()){
                    case 1: mainOptions.setLanguage(1); break;
                    case 2: mainOptions.setLanguage(2); break;
                    case 3: mainOptions.setLanguage(3); break;
                    case 4: mainOptions.setLanguage(4); break;
                    default:
                        System.out.println("Select a valid option");
                        selectLanguage = false;
                        break;
                }
            } while (selectLanguage == false);
        } catch (InputMismatchException e) {selectLanguage();}
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public void mainMenu(){
        NewGame();
        sc = new Scanner(System.in);
    // ! PLAY
        System.out.println("1. Play");
        int option = sc.nextInt();
        if (option == 1) {NewGame();}
    // ! OPTIONS
        // ! Change language
        // ! Change SIZE
        // ! Sound
            // ! Effects
            // ! Music
    // ! CREDITS
    // ! EXIT

     //   play()

    // ? Achievements
    // ? Multiplayer
        // ? BLUETOOTH 
        // ? ONLINE
    // ? 
    }

    public void provitionalMenu(){
        clearScreen();
        System.out.println(mainOptions.getGameText()[mainOptions.getLanguage()-1][1].toUpperCase() + "\n");
        System.out.println(mainOptions.getGameText()[mainOptions.getLanguage()-1][2]);
        System.out.println(mainOptions.getGameText()[mainOptions.getLanguage()-1][3]);
        System.out.println(mainOptions.getGameText()[mainOptions.getLanguage()-1][4]);
        System.out.println(mainOptions.getGameText()[mainOptions.getLanguage()-1][10]);
    }

    public void NewGame(){
        mainOptions.setDefaultSize(); 
        Map map = new Map();
        // mainOptions.getHeight(), mainOptions.getWidth()
        map.ShowMap();
    }


}
