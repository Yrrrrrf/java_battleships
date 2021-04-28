public class Options {    

    int height;
    int width; 
    int language;
    String[][] game_text;

    Options(){};

    public Options(int height, int width) {
        setHeight(height);
        setWidth(width);
    }
    
    public Options(int language) {
        setLanguage(language);
        setHeight(10);
        setWidth(10);
    }

    public void setGameText() {
        game_text = new String[4][50];

        game_text[0][0] = "Reza Campos Fernando Bryan";     
        game_text[1][0] = "Álvaro Rodela Leonardo de Jesús";
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
        game_text[2][4] = "Kredite";
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
        game_text[2][10] = "Beenden";
        game_text[3][10] = "";
        // ?-------------------------------------------------------------------------------------------------------------------------------

        // ? SHIP NAMES--------------------------------------------------------------------------------------------------------------------
        game_text[0][11] = "Portaaviones";
        game_text[1][11] = "Aircraft Carrier";
        game_text[2][11] = "Flugzeugträger";
        game_text[3][11] = "";

        game_text[0][12] = "Crucero";
        game_text[1][12] = "Cruiser";
        game_text[2][12] = "Kreuzer";
        game_text[3][12] = "";

        game_text[0][13] = "Destructor";
        game_text[1][13] = "Destroyer";
        game_text[2][13] = "Zerstörer";
        game_text[3][13] = "";

        game_text[0][14] = "Fragata";
        game_text[1][14] = "Frigate";
        game_text[2][14] = "Fregatte";
        game_text[3][14] = "";

        game_text[0][15] = "Buque";
        game_text[1][15] = "Vessel";
        game_text[2][15] = "Schiff";
        game_text[3][15] = "";
        // ?----------------------------------------------------------------------------------------------------------------------------------
        
        
        // ? COORDINATES MESSAGES-------------------------------------------------------------------------------------------------------------
        game_text[0][16] = "Coloque el tamaño del escenario personalizado:";
        game_text[1][16] = "Set the size of the custom scenario:";
        game_text[2][16] = "Setzen Sie die Größe des persönlichen Szenario:";
        game_text[3][16] = "";
        
        game_text[0][17] = "Solo puede colocar números naturales";
        game_text[1][17] = "You can only insert natural numbers";
        game_text[2][17] = "Sie können nur natürliche Zahlen einsetzen";
        game_text[3][17] = "";

        game_text[0][18] = "Orientación: \nVertical -> 1 ; Horizontal -> 2";
        game_text[1][18] = "Orientation \nVertical -> 1 ; Horizontal -> 2";
        game_text[2][18] = "Orientation \nSenkrecht -> 1 ; Waagerecht ->2";
        game_text[3][18] = "";
        
        game_text[0][19] = "Introduzca coordenada en X:";
        game_text[1][19] = "Introduce X coordinate:";
        game_text[2][19] = "Setzen Sie X Koordinate ein:";
        game_text[3][19] = "";
        
        game_text[0][20] = "Introduzca coordenada en Y:";
        game_text[1][20] = "Introduce Y coordinate:";
        game_text[2][20] = "Setzen Sie Y Koordinate ein:";
        game_text[3][20] = "";
        
        // ?----------------------------------------------------------------------------------------------------------------------------------
    
        game_text[0][21] = "\nVas a colocar el ";
        game_text[1][21] = "\nYou are going to put ";
        game_text[2][21] = "\n";
        game_text[3][21] = "\n";
        
        // *ERROR MESSAGE
        game_text[0][22] = "Por favor, introduzca un dato válido.";
        game_text[1][22] = "Please, select a valid option.";
        game_text[2][22] = "Bitte, wähl ein stimmende Datum. ";
        game_text[3][22] = "";
        
        game_text[0][23] = "Coordenada no valida";
        game_text[1][23] = "Not valid coordinate";
        game_text[2][23] = "";
        game_text[3][23] = "";
    
        game_text[0][24] = "";
        game_text[1][24] = "";
        game_text[2][24] = "";
        game_text[3][24] = "";
        
        game_text[0][25] = "";
        game_text[1][25] = "";
        game_text[2][25] = "";
        game_text[3][25] = "";

        game_text[0][26] = "";
        game_text[1][26] = "";
        game_text[2][26] = "";
        game_text[3][26] = "";
        
        game_text[0][27] = "";
        game_text[1][27] = "";
        game_text[2][27] = "";
        game_text[3][27] = "";
        
        game_text[0][28] = "";
        game_text[1][28] = "";
        game_text[2][28] = "";
        game_text[3][28] = "";
        
        game_text[0][29] = "";
        game_text[1][29] = "";
        game_text[2][29] = "";
        game_text[3][29] = "";
        
        game_text[0][30] = "";
        game_text[1][30] = "";
        game_text[2][30] = "";
        game_text[3][30] = "";
        
        game_text[0][31] = "";
        game_text[1][31] = "";
        game_text[2][31] = "";
        game_text[3][31] = "";
        
        game_text[0][32] = "";
        game_text[1][32] = "";
        game_text[2][32] = "";
        game_text[3][32] = "";
        
        game_text[0][33] = "";
        game_text[1][33] = "";
        game_text[2][33] = "";
        game_text[3][33] = "";
        
        game_text[0][34] = "";
        game_text[1][34] = "";
        game_text[2][34] = "";
        game_text[3][34] = "";
        
        game_text[0][35] = "";
        game_text[1][35] = "";
        game_text[2][35] = "";
        game_text[3][35] = "";

        game_text[0][36] = "";
        game_text[1][36] = "";
        game_text[2][36] = "";
        game_text[3][36] = "";

        game_text[0][37] = "";
        game_text[1][37] = "";
        game_text[2][37] = "";
        game_text[3][37] = "";
        
        game_text[0][38] = "";
        game_text[1][38] = "";
        game_text[2][38] = "";
        game_text[3][38] = "";
        
        game_text[0][39] = "";
        game_text[1][39] = "";
        game_text[2][39] = "";
        game_text[3][39] = "";
        
        game_text[0][40] = "";
        game_text[1][40] = "";
        game_text[2][40] = "";
        game_text[3][40] = "";

        game_text[0][41] = "";
        game_text[1][41] = "";
        game_text[2][41] = "";
        game_text[3][41] = "";

        game_text[0][42] = "";
        game_text[1][42] = "";
        game_text[2][42] = "";
        game_text[3][42] = "";
        
        game_text[0][43] = "";
        game_text[1][43] = "";
        game_text[2][43] = "";
        game_text[3][43] = "";
        
        game_text[0][44] = "";
        game_text[1][44] = "";
        game_text[2][44] = "";
        game_text[3][44] = "";
        
        game_text[0][45] = "";
        game_text[1][45] = "";
        game_text[2][45] = "";
        game_text[3][45] = "";

        game_text[0][46] = "";
        game_text[1][46] = "";
        game_text[2][46] = "";
        game_text[3][46] = "";

        game_text[0][47] = "";
        game_text[1][47] = "";
        game_text[2][47] = "";
        game_text[3][47] = "";
        
        game_text[0][48] = "";
        game_text[1][48] = "";
        game_text[2][48] = "";
        game_text[3][48] = "";
        
        game_text[0][49] = "";
        game_text[1][49] = "";
        game_text[2][49] = "";
        game_text[3][49] = "";

    }
    
    
    // * SETTERS
    public void setLanguage(int language){this.language = language;}
    
    public void setHeight(int height) {this.height = height;}

    public void setWidth(int width) {this.width = width;}

    public void setGameText(String[][] game_text){this.game_text = game_text;}
    
    
    // * GETTERS
    public int getLanguage() {return this.language;}
    
    public String[][] getGameText(){return game_text;}
    
    public int getHeight() {return this.height;}
    
    public int getWidth() {return this.width;}

    
}