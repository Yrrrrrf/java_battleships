public class Main {

    public static void main(String[] args) {
        
        GameText.setGameText();
        Menu menu = new Menu(10);

        menu.clearScreen();
        menu.selectLanguage();
        
        menu.clearScreen();
        menu.provitionalMenu();

    }

}