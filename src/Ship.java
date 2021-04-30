public class Ship {

    private String name;
    private boolean vertical;
    private boolean destroyed;
    public ShipType type;
    private int length;
    private int width;
    private int hash;


    public Ship() {}


    /**
     * Set the gived parameters to create the Ship object that will be used in the Game() method
     * @param language
     * @param shipType
     */
    public void setShip(int language, ShipType shipType){
        setType(shipType);
        setName(language);
        setDestroyed(false);
        setVertical(true);
    }
    
    
    // * SETTEERS
    public void setName(int language) {
            this.name = GameText.gameText[language][hash-1000];
    }
    
    public void setVertical(boolean vertical) {this.vertical = vertical;}
    
    public void setDestroyed(boolean destroyed) {this.destroyed = destroyed;}
        
    public void setLength(int length) {this.length = length;}    
    
    public void setWidth(int width) {this.width = width;}
    
    public void setHash(int hash) {this.hash = hash;}
    
    public void setType(ShipType type) {
        setLength(type.getLength());
        setWidth(type.getWidth());
        setHash(type.getHash());
    }


    // * GETTERS
    public String getName() {return this.name;}

    public boolean isVertical() {return this.vertical;}

    public boolean isDestroyed() {return this.destroyed;}

    public int getLength() {return this.length;}
    
    public int getWidth() {return this.width;}
    
    public int getHash() {return this.hash;}
    
    public ShipType getType() {return this.type;}
}