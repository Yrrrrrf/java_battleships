public class Main {

    public static void main(String[] args) {
        
        GameText.setGameText();
        
        {
            System.out.println(GameText.gameText[0][0]);
        }
    
        Menu menu = new Menu(10);
        menu.clearScreen();

        menu.selectLanguage();
        
        menu.clearScreen();
        menu.provitionalMenu();

    }

}