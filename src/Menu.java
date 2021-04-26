import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    int language;
    static String[][] game_text;
    Scanner sc;


    public Menu(){}
    
    public Menu(int language){
        setLanguage(language);
        setGameText();
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
                System.out.println("1. English");
                System.out.println("2. Español");
                System.out.println("3. Deutsch");
                System.out.println("4. русский");

                language = sc.nextInt();
                switch(language){
                    case 1: language = 1; break;
                    case 2: language = 2; break;
                    case 3: language = 3; break;
                    case 4: language = 4; break;
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

    private void setGameText() {
        game_text = new String[2][50];

        game_text[0][0] = "Batalla Naval";
        game_text[1][0] = "Battleships";

        game_text[0][2] = "Coloca el tamaño del escenario personalizado";
        game_text[1][2] = "Set the size of the custom scenario";
        
        game_text[0][3] = "Solo puedes colocar números naturales";
        game_text[1][3] = "You can only insert natural numbers";
    }

    private void setLanguage(int language){
        this.language = language;
    }

    public int getLanguage() {return this.language;}




}
