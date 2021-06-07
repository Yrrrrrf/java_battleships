import java.util.Scanner;

public class Options {    

    Scanner sc;
    int size;
    int language;


    public Options() {}


    /** 
     * Assign the dimentions gived by the Menu(int size) method to the gameMap[][][]
     * @param size
     */
    public Options(int size, int language){
        setSize(size);
        setLanguage(language);
    }


    /**
     * Initial language selecction menu
     */
    public void selectLanguage(Options options) {
        sc = new Scanner(System.in);
        int userInput;

        try {
            boolean selectLanguage;
            do {
                selectLanguage = true;
                System.out.println(GameText.optionsText[options.getLanguage()][6]); // ... + "language"
                for (int i = 0; i < 4; i++) {
                    System.out.println((i + 1) + ". " + GameText.optionsText[i][2]);
                }
                System.out.print("-> ");
                userInput = sc.nextInt();

                switch(userInput){
                    case 1: setLanguage(0); break;
                    case 2: setLanguage(1); break;
                    case 3: setLanguage(2); break;
                    default:
                        System.out.println(GameText.errorText[options.getLanguage()][0]); // "Please, select a valid option"
                        selectLanguage = false;
                        break;
                }
            } while (!selectLanguage);

        } catch (Exception e) {
            System.out.println(GameText.errorText[options.getLanguage()][0]); // "Please, select a valid option"
            selectLanguage(options);
        }
    }


    /**
     * Change the mapSize, only multiples of 2 between 8 and 64
     */
    public void selectSize(Options options) {
        int size = 10;
        sc = new Scanner(System.in);

        try {
            boolean validOption = true;
            do {
                System.out.println(GameText.optionsText[options.getLanguage()][8] + GameText.optionsText[options.getLanguage()][7]);    // "Change" + "Map Size";
                System.out.println(GameText.optionsText[options.getLanguage()][4]);    // Only pair numbers between 8 and 64";
                size = sc.nextInt();

                if (size >= 8 && size <= 64) {
                    if (size%2==0) {
                        System.out.println(GameText.optionsText[options.getLanguage()][3] + size + "x" + size); // "The new map size is: " + size x size;
                        validOption = false;
                    } else {System.out.println(GameText.errorText[options.getLanguage()][0]);}  // "Please, select a valid option"
                } else {System.out.println(GameText.errorText[options.getLanguage()][0]);}      // "Please, select a valid option"

            } while (validOption);

        } catch (Exception e) {
            selectSize(options);
        }
        setSize(size);
    }


    /**
     * View the actual configuration of the Options object
     * @param options
     */
    public void viewConfig(Options options) {
        System.out.println(GameText.optionsText[options.getLanguage()][1]);     // "Select the parameter to change:"
        System.out.println(GameText.optionsText[options.getLanguage()][6] + ": " + GameText.optionsText[options.getLanguage()][2]); // "Language: " + language
        System.out.println(GameText.optionsText[options.getLanguage()][7] + ": " + options.getSize() + "x" + options.getSize());    // "Map Size: " + mapSize x mapSize
    }


    /**
     * Change the parameter that you want in the Options object
     * <p>
     * This needs to be changed before start a newGame
     * @param options
     */
    public void changeParameter(Options options) {
        sc = new Scanner(System.in);
        int userInput;
        
        try {
            boolean validOption = false;
            do {
                System.out.println("\n" + GameText.optionsText[options.getLanguage()][0]);      // "Select the parameter to change:"
                System.out.println("1. " + GameText.optionsText[options.getLanguage()][6]);     // "Change" + "Language"
                System.out.println("2. " + GameText.optionsText[options.getLanguage()][7]);     // "Change" + "Map Size"

                userInput = sc.nextInt();

                switch (userInput) {
                    case 1:
                        System.out.print(GameText.optionsText[options.getLanguage()][8]);       // "Change ..."
                        selectLanguage(options);                                                // "... Language"
                        break;
                    case 2:
                        selectSize(options);
                        break;
                // !case 3: // Sound -> Change volume
                    // !selectEffects(options)
                    // !selectMusic(options)
                    default:
                        clearScreen();
                        System.out.println(GameText.errorText[options.getLanguage()][0]);       // "Please, select a valid option"
                        validOption = true;
                        break;
                }

            } while (validOption);
        } catch (Exception e) {
            changeParameter(options);
        }
    }


    // * SETTERS
    public void setLanguage(int language){this.language = language;}
    
    public void setSize(int size) {this.size = size;}
    

    // * GETTERS
    public int getLanguage() {return this.language;}
    
    public int getSize() {return this.size;} 


    /**
     * Clear all the code of the termianl written before
     */
    public void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

}