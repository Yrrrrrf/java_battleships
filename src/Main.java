public class Main {

    public static void main(String[] args) {
        // ! ADD THE RANDOM OR INDIVIDUAL COLOCATRION METHOD
        // Giving the "default" value to the dimanetions of the scenario
        GameText.setGameText();
        Menu menu = new Menu(10, 1);
        
        System.out.print(GameText.menuText[menu.mainOptions.getLanguage()][6]); // "Select..."
        menu.mainOptions.selectLanguage(menu.mainOptions);                      // "... Language"
        menu.clearScreen();

        menu.mainMenu();

    }

}