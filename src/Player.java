public class Player {

    String name;
    String email;
    int age;
    Map map;
    Ship[] ships;
    Missile[] missiles;
    int destroyedShips;


    Player() {}


    /**
     * Creates the Player Object with his own ships and missiles
     * @param mapSize
     * @param language
     */
    Player(int mapSize, int language) {
        map = new Map(mapSize);
        ships = new Ship[7];
        missiles = new Missile[3];

        for (int i = 0; i < ships.length; i++) {
            ships[i] = new Ship();
        }
        for (int i = 0; i < missiles.length; i++) {
            missiles[i] = new Missile();
        }

        ships[0].setShip(language, ShipType.CARRIER);
        ships[1].setShip(language, ShipType.CRUISER);
        ships[2].setShip(language, ShipType.CRUISER);
        ships[3].setShip(language, ShipType.DESTROYER);
        ships[4].setShip(language, ShipType.FRIGATE);
        ships[5].setShip(language, ShipType.FRIGATE);
        ships[6].setShip(language, ShipType.VESSEL);

        missiles[0].setMissile(language, MissileType.SIMPLE);
        missiles[1].setMissile(language, MissileType.CROSS);
        missiles[2].setMissile(language, MissileType.SMALLT);

        setDestroyedShips(0);
    }


    /**
     * Add +1 to the destroyed ships. To know when does the game ends
     */
    public void destroyShip() {
        destroyedShips++;
    }
    
    
    // * SETTERS
    public void setName(String name) {this.name = name;}

    public void setEmail(String email) {this.email = email;}

    public void setAge(int age) {this.age = age;}

    public void setMap(Map map) {this.map = map;}

    public void setShips(Ship[] ships) {this.ships = ships;}

    public void setMissiles(Missile[] missiles) {this.missiles = missiles;}

    public void setDestroyedShips(int destroyedShips) {this.destroyedShips = destroyedShips;}


    // * GETTERS
    public String getName() {return this.name;}

    public String getEmail() {return this.email;}

    public int getAge() {return this.age;}

    public Map getMap() {return this.map;}

    public Ship[] getShips() {return this.ships;}

    public Missile[] getMissiles() {return this.missiles;}    

    public int getDestroyedShips() {return this.destroyedShips;}


}