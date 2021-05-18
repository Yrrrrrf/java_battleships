public class Main {

    public static void main(String[] args) {
        // Giving the "default" value to the dimanetions of the scenario
        GameText.setGameText();
        Menu menu = new Menu(10, 0);

        menu.clearScreen();
        menu.selectLanguage();
        
        menu.clearScreen();
        menu.provitionalMenu();

    }

}