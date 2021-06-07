// All the game text used in the different languajes
// Abstract class allow us to call it without create a "GameText" object
public class GameText {
    
    // static values that belongs to the CLASS, not just to an object
    public static String[][] gameText;
    public static String[][] menuText;
    public static String[][] coordinatesText;
    public static String[][] errorText;
    public static String[][] shipText;
    public static String[][] missileText;
    public static String[][] optionsText;

    public static String[][] auxiliarText;
    public static String[][] additionalText;
    public static String[][] extraText;

    private static String redColor = "\033[31m";
    private static String blueColor = "\033[34m";
    private static String endColor = "\u001B[0m";
    
    public static void setGameText(){
        
        // ? AUTHORS ------------------------------------------------------------------------------
        gameText = new String[4][4];

        gameText[0][0] = blueColor + "Reza Campos Fernando Bryan"       + endColor;
        gameText[1][0] = blueColor + "Alvaro Rodela Leonardo de Jesus"  + endColor;
        //gameText[1][0] = "Alvaro Rodela Leonardo de Jesús";
        gameText[2][0] = "Go back";
        gameText[3][0] = "Goodbye";

        gameText[0][1] = "\nMapa del jugador";
        gameText[1][1] = "\nPlayer Map";
        gameText[2][1] = "\n";
        gameText[3][1] = "\n";

        gameText[0][2] = "\nGANASTE!";
        gameText[1][2] = "\nYOU WIN!";
        gameText[2][2] = "\n";
        gameText[3][2] = "\n";

        //gameText[0][3] = "\nGanó la máquina. Perdiste";
        gameText[0][3] = "\nGano la maquina. Perdiste";
        gameText[1][3] = "\nMachine wins. You lose";
        gameText[2][3] = "\n";
        gameText[3][3] = "\n";


        // ? MENU TEXT ----------------------------------------------------------------------------
        menuText = new String[4][20];
        
        menuText[0][1] = "Batalla Naval" + endColor;
        menuText[1][1] = "Battleships" + endColor;
        menuText[2][1] = "Schlachtschiffe" + endColor;
        menuText[3][1] = "" + endColor;
        
        menuText[0][2] = "Jugar";
        menuText[1][2] = "Play";
        //menuText[2][2] = "Spielen";
        menuText[3][2] = "";
        
        menuText[0][3] = "Opciones";
        menuText[1][3] = "Options";
        //menuText[2][3] = "Optionen";
        menuText[3][3] = "";
        
        menuText[0][4] = "Creditos";
        menuText[1][4] = "Credits";
        //menuText[2][4] = "Kredite";
        menuText[3][4] = "";
        
        menuText[0][5] = "Salir";
        menuText[1][5] = "Exit";
        //menuText[2][5] = "Beenden";
        menuText[3][5] = "";
        
        menuText[0][6] = "Elige ";
        menuText[1][6] = "Select ";
        menuText[2][6] = "";
        menuText[3][6] = "";


        // ? OPTIONS TEXT--------------------------------------------------------------------------
        optionsText = new String[4][20];

        optionsText[0][0] = "Elige el parámetro a cambiar:";
        optionsText[1][0] = "Select the parameter to change:";
        optionsText[2][0] = "";
        optionsText[3][0] = "";

        optionsText[0][1] = "La configuración actual es: ";
        optionsText[1][1] = "The actual configuration is: ";
        optionsText[2][1] = "";
        optionsText[3][1] = "";

        optionsText[0][2] = "Español";
        optionsText[1][2] = "English";
        optionsText[2][2] = "Deutsch";
        optionsText[3][2] = "Ruso";

        optionsText[0][3] = "El nuevo tamaño del mapa es: ";
        optionsText[1][3] = "The new map size is: ";
        optionsText[2][3] = "";
        optionsText[3][3] = "";

        optionsText[0][4] = "Solo numeros pares, entre 8 y 64";
        optionsText[1][4] = "Only pair numbers between 8 and 64";
        optionsText[2][4] = "";
        optionsText[3][4] = "";

        optionsText[0][5] = "";
        optionsText[1][5] = "";
        optionsText[2][5] = "";
        optionsText[3][5] = "";

        optionsText[0][6] = "Idioma";
        optionsText[1][6] = "Language";
        optionsText[2][6] = "";
        optionsText[3][6] = "";

        optionsText[0][7] = "Tamaño de Mapa";
        optionsText[1][7] = "Map Size";
        optionsText[2][7] = "";
        optionsText[3][7] = "";

        optionsText[0][8] = "Cambiar ";
        optionsText[1][8] = "Change ";
        optionsText[2][8] = " ";
        optionsText[3][8] = " ";


        // ? COORDINATES MESSAGES------------------------------------------------------------------
        coordinatesText = new String[4][8];
                
        coordinatesText[0][0] = "Vas a colocar el ";
        coordinatesText[1][0] = "You are going to put ";
        coordinatesText[2][0] = "";
        coordinatesText[3][0] = "";

        coordinatesText[0][1] = "Coloque el tamaño del escenario personalizado:";
        coordinatesText[1][1] = "Set the size of the custom scenario:";
        //coordinatesText[2][1] = "Setzen Sie die Größe des persönlichen Szenario:";
        coordinatesText[3][1] = "";

        //coordinatesText[0][2] = "Orientación:    Vertical = 1 ; Horizontal = 2";
        coordinatesText[0][2] = "Orientacion:    Vertical = 1 ; Horizontal = 2";
        coordinatesText[1][2] = "Orientation:    Vertical = 1 ; Horizontal = 2";
        //coordinatesText[2][2] = "Orientation:    Senkrecht = 1 ; Waagerecht = 2";
        coordinatesText[3][2] = "";

        coordinatesText[0][3] = "Introduzca coordenada en X:";
        coordinatesText[1][3] = "Introduce X coordinate:";
        //coordinatesText[2][3] = "Setzen Sie X Koordinate ein:";
        coordinatesText[3][3] = "";

        coordinatesText[0][4] = "Introduzca coordenada en Y:";
        coordinatesText[1][4] = "Introduce Y coordinate:";
        //coordinatesText[2][4] = "Setzen Sie Y Koordinate ein:";
        coordinatesText[3][4] = "";
        
        coordinatesText[0][5] = "Lanzaste un ";
        coordinatesText[1][5] = "You shoot a ";
        coordinatesText[2][5] = "";
        coordinatesText[3][5] = "";
        
        coordinatesText[0][6] = "Elige un misil: ";
        coordinatesText[1][6] = "Select missile: ";
        coordinatesText[2][6] = "";
        coordinatesText[3][6] = "";

        coordinatesText[0][7] = "Impacto exitoso en ";
        coordinatesText[1][7] = "Succesful impact in ";
        coordinatesText[2][7] = "";
        coordinatesText[3][7] = "";


        // ? ERROR MESSAGES -----------------------------------------------------------------------
        errorText = new String[4][5];
        
        //* MOST USED ERROR MESSAGE
        //errorText[0][0] = "Por favor, introduzca un dato válido.";
        errorText[0][0] = redColor + "Por favor, introduzca un dato valido" + endColor;
        errorText[1][0] = redColor + "Please, select a valid option"        + endColor;
        errorText[2][0] = redColor + " "+ endColor;
        errorText[3][0] = redColor + " "+ endColor;
        
        errorText[0][1] = redColor + "Coordenada no valida"                 + endColor;
        errorText[1][1] = redColor + "Not valid coordinate"                 + endColor;
        errorText[2][1] = redColor + " " + endColor;
        errorText[3][1] = redColor + " " + endColor;

        errorText[0][2] = redColor + " está fuera de los límites del mapa"  + endColor;
        errorText[1][2] = redColor + " is out of the map limit"             + endColor;
        errorText[2][2] = redColor + " " + endColor;
        errorText[3][2] = redColor + " " + endColor;

        errorText[0][3] = redColor + " " + endColor;
        errorText[1][3] = redColor + " " + endColor;
        errorText[2][3] = redColor + " " + endColor;
        errorText[3][3] = redColor + " " + endColor;

        errorText[0][4] = redColor + " " + endColor;
        errorText[1][4] = redColor + " " + endColor;
        errorText[2][4] = redColor + " " + endColor;
        errorText[3][4] = redColor + " " + endColor;


        // ? SHIP NAMES ---------------------------------------------------------------------------
        shipText = new String[4][10];
        // HASH 1000
        shipText[0][0] = "Buque";
        shipText[1][0] = "Vessel";        
        //shipText[2][0] = "Schiff";
        shipText[3][0] = "";
        
        // HASH 1001
        shipText[0][1] = "Fragata";
        shipText[1][1] = "Frigate";
        //shipText[2][1] = "Fregatte";
        shipText[3][1] = "";
        
        // HASH 1002
        shipText[0][2] = "Destructor";
        shipText[1][2] = "Destroyer";
        //shipText[2][2] = "Zerstörer";
        shipText[3][2] = "";
        
        // HASH 1003
        shipText[0][3] = "Crucero";
        shipText[1][3] = "Cruiser";
        //shipText[2][3] = "Kreuzer";
        shipText[3][3] = "";
        
        // HASH 1004
        shipText[0][4] = "Portaaviones";
        shipText[1][4] = "Aircraft Carrier";
        //shipText[2][4] = "Flugzeugträger";
        shipText[3][4] = "";
        
        // HASH 1016
        shipText[0][5] = "";
        shipText[1][5] = "";
        shipText[2][5] = "";
        shipText[3][5] = "";
        
        // HASH 1017
        shipText[0][6] = "";
        shipText[1][6] = "";
        shipText[2][6] = "";
        shipText[3][6] = "";
        
        // HASH 1018
        shipText[0][7] = "";
        shipText[1][7] = "";
        shipText[2][7] = "";
        shipText[3][7] = "";
        
        // HASH 1019
        shipText[0][8] = "";
        shipText[1][8] = "";
        shipText[2][8] = "";
        shipText[3][8] = "";
        
        // HASH 1020
        shipText[0][9] = "";
        shipText[1][9] = "";
        shipText[2][9] = "";
        shipText[3][9] = "";

        
        // ? MISSILE TEXT -------------------------------------------------------------------------
        missileText = new String[4][30];
        
        // HASH 2000
        missileText[0][0] = "Simple";
        missileText[1][0] = "Simple";
        missileText[2][0] = "";
        missileText[3][0] = "";
        
        // HASH 2001
        missileText[0][1] = "Cruz";
        missileText[1][1] = "Cross";
        missileText[2][1] = "";
        missileText[3][1] = "";

        // HASH 2002
        missileText[0][2] = "Pequeño T";
        missileText[1][2] = "Small T";
        missileText[2][2] = "";
        missileText[3][2] = "";

        // HASH 2003
        missileText[0][3] = "Caballo";
        missileText[1][3] = "Horse";
        missileText[2][3] = "";
        missileText[3][3] = "";

        // HASH 2004
        //missileText[0][4] = "Corazón";
        missileText[0][4] = "Corazon";
        missileText[1][4] = "Heart";
        missileText[2][4] = "";
        missileText[3][4] = "";
        
        // HASH 2005
        missileText[0][5] = "Gran Cruz";
        missileText[1][5] = "Big Cross";
        missileText[2][5] = "";
        missileText[3][5] = "";
        
        // HASH 2006
        missileText[0][6] = "Gran T";
        missileText[1][6] = "Big T";
        missileText[2][6] = "";
        missileText[3][6] = "";

        // HASH 2007
        missileText[0][7] = "Nuclear";
        missileText[1][7] = "Nuke";
        missileText[2][7] = "";
        missileText[3][7] = "";

        // HASH 2008
        //missileText[0][8] = "Círculo";
        missileText[0][8] = "Circulo";
        missileText[1][8] = "Circle";
        missileText[2][8] = "";
        missileText[3][8] = "";
        
        // HASH 2009
        missileText[0][9] = "";
        missileText[1][9] = "";
        missileText[2][9] = "";
        missileText[3][9] = "";
        
        // HASH 2010
        missileText[0][10] = "";
        missileText[1][10] = "";
        missileText[2][10] = "";
        missileText[3][10] = "";
        
        // HASH 2011
        missileText[0][11] = "";
        missileText[1][11] = "";
        missileText[2][11] = "";
        missileText[3][11] = "";

        missileText[0][12] = "";
        missileText[1][12] = "";
        missileText[2][12] = "";
        missileText[3][12] = "";
        
        missileText[0][13] = "";
        missileText[1][13] = "";
        missileText[2][13] = "";
        missileText[3][13] = "";
        
        missileText[0][14] = "";
        missileText[1][14] = "";
        missileText[2][14] = "";
        missileText[3][14] = "";
        
        missileText[0][15] = "";
        missileText[1][15] = "";
        missileText[2][15] = "";
        missileText[3][15] = "";

        missileText[0][16] = "";
        missileText[1][16] = "";
        missileText[2][16] = "";
        missileText[3][16] = ""; 
        
        missileText[0][17] = "";
        missileText[1][17] = "";
        missileText[2][17] = "";
        missileText[3][17] = "";
        
        missileText[0][18] = "";
        missileText[1][18] = "";
        missileText[2][18] = "";
        missileText[3][18] = "";
        
        // HASH 2011
        missileText[0][19] = "";
        missileText[1][19] = "";
        missileText[2][19] = "";
        missileText[3][19] = "";

        missileText[0][20] = "";
        missileText[1][20] = "";
        missileText[2][20] = "";
        missileText[3][20] = "";
        
        missileText[0][21] = "";
        missileText[1][21] = "";
        missileText[2][21] = "";
        missileText[3][21] = "";
        
        missileText[0][22] = "";
        missileText[1][22] = "";
        missileText[2][22] = "";
        missileText[3][22] = "";
        
        missileText[0][23] = "";
        missileText[1][23] = "";
        missileText[2][23] = "";
        missileText[3][23] = "";

        missileText[0][24] = "";
        missileText[1][24] = "";
        missileText[2][24] = "";
        missileText[3][24] = ""; 
        
        missileText[0][25] = "";
        missileText[1][25] = "";
        missileText[2][25] = "";
        missileText[3][25] = "";
        
        missileText[0][26] = "";
        missileText[1][26] = "";
        missileText[2][26] = "";
        missileText[3][26] = "";
        
        missileText[0][27] = "";
        missileText[1][27] = "";
        missileText[2][27] = "";
        missileText[3][27] = "";
        
        missileText[0][28] = "Cargando... ";
        missileText[1][28] = "Loading...  ";
        missileText[2][28] = "";
        missileText[3][28] = "";
        
        missileText[0][29] = "Listo       ";
        missileText[1][29] = "Ready       ";
        missileText[2][29] = "";
        missileText[3][29] = "";
    }

}