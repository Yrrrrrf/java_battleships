public class Ship {

    private String name;
    public ShipType type;

    private int length;
    private int width;
    private int hash;
    
    private boolean vertical;

    private int xCoordinate;
    private int yCoordinate; 

    private int damage;
    private boolean destroyed;


    public Ship() {}

    public void sufferDamage(){
        damage++;
    }


    /**
     * Sets given parameters to create a Ship object [used in the Game() method]
     * @param language
     * @param shipType
     */
    public void setShip(int language, ShipType shipType){
        setType(shipType);
        setName(language);
        setDestroyed(false);
        setVertical(true);
        setDamage(0);
    }
    
    
    // * SETTEERS
    public void setName(int language) {this.name = GameText.shipText[language][hash-1000];}
    
    public void setLength(int length) {this.length = length;}    
    
    public void setWidth(int width) {this.width = width;}
    
    public void setHash(int hash) {this.hash = hash;}
    
    public void setVertical(boolean vertical) {this.vertical = vertical;}

    public void setXCoordinate(int xCoordinate) {this.xCoordinate = xCoordinate;}
    
    public void setYCoordinate(int yCoordinate) {this.yCoordinate = yCoordinate;}
    
    public void setDamage(int damage) {this.damage = damage;}
    
    public void setDestroyed(boolean destroyed) {this.destroyed = destroyed;}

    public void setType(ShipType type) {
        setLength(type.getLength());
        setWidth(type.getWidth());
        setHash(type.getHash());
        this.type = type;
    }


    // * GETTERS
    public String getName() {return this.name;}
    
    public int getLength() {return this.length;}
    
    public int getWidth() {return this.width;}
    
    public int getHash() {return this.hash;}
    
    public boolean isVertical() {return this.vertical;}

    public int getXCoordinate() {return this.xCoordinate;}

    public int getYCoordinate() {return this.yCoordinate;}
    
    public ShipType getType() {return this.type;}
    
    public int getDamage() {return this.damage;}

    public boolean isDestroyed() {return this.destroyed;}
    
}