// All the game text used in the different languajes
// Abstract class allow us to call it without create a "GameText" object
public class GameText {

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

    // Static values that belongs to the CLASS, not just to an object
    public static void setGameText(){
        gameText = new String[4][1];

        optionsText = new String[4][20];


        // ? AUTHORS ------------------------------------------------------------------------------
        gameText[0][0] = "Reza Campos Fernando Bryan";     
        gameText[1][0] = "Álvaro Rodela Leonardo de Jesús";
        gameText[2][0] = "Go back";
        gameText[3][0] = "Goodbye";


        // ? MENU TEXT ----------------------------------------------------------------------------
        menuText = new String[4][20];
        
        menuText[0][1] = "Batalla Naval";
        menuText[1][1] = "Battleships";
        menuText[2][1] = "Schlachtschiffe";
        menuText[3][1] = "";
        
        menuText[0][2] = "Jugar";
        menuText[1][2] = "Play";
        menuText[2][2] = "Spielen";
        menuText[3][2] = "";
        
        menuText[0][3] = "Opciones";
        menuText[1][3] = "Options";
        menuText[2][3] = "Optionen";
        menuText[3][3] = "";
        
        menuText[0][4] = "Creditos";
        menuText[1][4] = "Credits";
        menuText[2][4] = "Kredite";
        menuText[3][4] = "";
        
        menuText[0][5] = "Salir";
        menuText[1][5] = "Exit";
        menuText[2][5] = "Beenden";
        menuText[3][5] = "";
        
        menuText[0][6] = "Cambiar Tamaño";
        menuText[1][6] = "Change Size";
        menuText[2][6] = "Größe Ändern";
        menuText[3][6] = "";
        
        menuText[0][7] = "Sonido";
        menuText[1][7] = "Sound";
        menuText[2][7] = "Klang";
        menuText[3][7] = "";
        
        menuText[0][8] = "Efectos";
        menuText[1][8] = "Effects";
        menuText[2][8] = "Effekte";
        menuText[3][8] = "";
        
        menuText[0][9] = "Música";
        menuText[1][9] = "Music";
        menuText[2][9] = "Musik";
        menuText[3][9] = "";

        menuText[0][10] = "Cambiar Idioma";
        menuText[1][10] = "Change Language";
        menuText[2][10] = "Sprache Ändern";
        menuText[3][10] = "";
        

        // ? COORDINATES MESSAGES------------------------------------------------------------------
        coordinatesText = new String[4][7];
                
        coordinatesText[0][0] = "Vas a colocar el ";
        coordinatesText[1][0] = "You are going to put ";
        coordinatesText[2][0] = "";
        coordinatesText[3][0] = "";

        coordinatesText[0][1] = "Coloque el tamaño del escenario personalizado:";
        coordinatesText[1][1] = "Set the size of the custom scenario:";
        coordinatesText[2][1] = "Setzen Sie die Größe des persönlichen Szenario:";
        coordinatesText[3][1] = "";

        coordinatesText[0][2] = "Orientación:    Vertical = 1 ; Horizontal = 2";
        coordinatesText[1][2] = "Orientation:    Vertical = 1 ; Horizontal = 2";
        coordinatesText[2][2] = "Orientation:    Senkrecht = 1 ; Waagerecht = 2";
        coordinatesText[3][2] = "";

        coordinatesText[0][3] = "Introduzca coordenada en X:";
        coordinatesText[1][3] = "Introduce X coordinate:";
        coordinatesText[2][3] = "Setzen Sie X Koordinate ein:";
        coordinatesText[3][3] = "";

        coordinatesText[0][4] = "Introduzca coordenada en Y:";
        coordinatesText[1][4] = "Introduce Y coordinate:";
        coordinatesText[2][4] = "Setzen Sie Y Koordinate ein:";
        coordinatesText[3][4] = "";
        
        coordinatesText[0][5] = "Lanzaste un ";
        coordinatesText[1][5] = "You shoot a ";
        coordinatesText[2][5] = "";
        coordinatesText[3][5] = "";
        
        coordinatesText[0][6] = "Elige un misil: ";
        coordinatesText[1][6] = "Select missile: ";
        coordinatesText[2][6] = "";
        coordinatesText[3][6] = "";


        // ? ERROR MESSAGES -----------------------------------------------------------------------
        errorText = new String[4][5];
        
        //* MOST USED ERROR MESSAGE
        errorText[0][0] = "Por favor, introduzca un dato válido.";
        errorText[1][0] = "Please, select a valid option.";
        errorText[2][0] = "Bitte, wähl ein stimmende Datum. ";
        errorText[3][0] = "";
        
        errorText[0][1] = "Coordenada no valida";
        errorText[1][1] = "Not valid coordinate";
        errorText[2][1] = "";
        errorText[3][1] = "";

        errorText[0][2] = " está fuera de los límites del mapa";
        errorText[1][2] = " is out of the map limit";
        errorText[2][2] = "";
        errorText[3][2] = "";

        errorText[0][3] = "";
        errorText[1][3] = "";
        errorText[2][3] = "";
        errorText[3][3] = "";

        errorText[0][4] = "";
        errorText[1][4] = "";
        errorText[2][4] = "";
        errorText[3][4] = "";


        // ? SHIP NAMES ---------------------------------------------------------------------------
        shipText = new String[4][10];
        // HASH 1000
        shipText[0][0] = "Buque";
        shipText[1][0] = "Vessel";        
        shipText[2][0] = "Schiff";
        shipText[3][0] = "";
        
        // HASH 1001
        shipText[0][1] = "Fragata";
        shipText[1][1] = "Frigate";
        shipText[2][1] = "Fregatte";
        shipText[3][1] = "";
        
        // HASH 1002
        shipText[0][2] = "Destructor";
        shipText[1][2] = "Destroyer";
        shipText[2][2] = "Zerstörer";
        shipText[3][2] = "";
        
        // HASH 1003
        shipText[0][3] = "Crucero";
        shipText[1][3] = "Cruiser";
        shipText[2][3] = "Kreuzer";
        shipText[3][3] = "";
        
        // HASH 1004
        shipText[0][4] = "Portaaviones";
        shipText[1][4] = "Aircraft Carrier";
        shipText[2][4] = "Flugzeugträger";
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
        missileText[0][4] = "Corazón";
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
        missileText[0][8] = "Círculo";
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
