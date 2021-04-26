public class Options {    

    int height;
    int width; 
    int language;
    static String[][] game_text;

    Options(){}
    
    Options(int language){
        setLanguage(language);
    }

    public void setGameText() {
        game_text = new String[4][50];

        game_text[0][0] = "Reza Campos Fernando Bryan";     
        game_text[1][0] = "Leonardo de Jesús Alvaro Rodela";
        game_text[2][0] = "";
        game_text[3][0] = "";
        
        // ? MENU --------------------------------------------------------------------------------------------------------------------------------
        game_text[0][1] = "Batalla Naval";
        game_text[1][1] = "Battleships";
        game_text[2][1] = "Schlachtschiffe";
        game_text[3][1] = "";
        
        game_text[0][2] = "Jugar";
        game_text[1][2] = "Play";
        game_text[2][2] = "Spielen";
        game_text[3][2] = "";
        
        game_text[0][3] = "Opciones";
        game_text[1][3] = "Options";
        game_text[2][3] = "Optionen";
        game_text[3][3] = "";
        
        game_text[0][4] = "Creditos";
        game_text[1][4] = "Credits";
        game_text[2][4] = "Krediten";
        game_text[3][4] = "";
        
        game_text[0][5] = "Cambiar Idioma";
        game_text[1][5] = "Change Language";
        game_text[2][5] = "Sprache Ändern";
        game_text[3][5] = "";
        
        game_text[0][6] = "Cambiar Tamaño";
        game_text[1][6] = "Change Size";
        game_text[2][6] = "Größe Ändern";
        game_text[3][6] = "";
        
        game_text[0][7] = "Sonido";
        game_text[1][7] = "Sound";
        game_text[2][7] = "Klang";
        game_text[3][7] = "";
        
        game_text[0][8] = "Efectos";
        game_text[1][8] = "Effects";
        game_text[2][8] = "Effekte";
        game_text[3][8] = "";
        
        game_text[0][9] = "Música";
        game_text[1][9] = "Music";
        game_text[2][9] = "Musik";
        game_text[3][9] = "";
        
        game_text[0][10] = "Salir";
        game_text[1][10] = "Exit";
        game_text[2][10] = "Ausgang";
        game_text[3][10] = "";
        // ?-------------------------------------------------------------------------------------------------------------------------------

        game_text[0][11] = "Coloca el tamaño del escenario personalizado";
        game_text[1][11] = "Set the size of the custom scenario";
        game_text[2][11] = "Setz die Größe des persönlichen Szenario";
        game_text[3][11] = "";
        
        game_text[0][12] = "Solo puedes colocar números naturales";
        game_text[1][12] = "You can only insert natural numbers";
        game_text[2][12] = "Du kannst nur natürliche Zahlen einsetzen";
        game_text[3][12] = "";
    }

    public String[][] getGameText(){return game_text;}

    public void setLanguage(int language){this.language = language;}

    public int getLanguage() {return this.language;}
}