public class Main {

    public static void main(String[] args) {
        
        GameText.setGameText();
        // Giving the "default" value to the dimanetions of the scenario
        Menu menu = new Menu(10);

        menu.clearScreen();
        menu.selectLanguage();
        
        menu.clearScreen();
        menu.provitionalMenu();

    }

}