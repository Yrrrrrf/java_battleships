
    
public class Ship {

    private String name;
    private int height;
    private int width;
    private boolean vertical;
    private boolean destroyed;
    public ShipType type;

    public Ship() {}

    public void setShip(String name, int height, int width, ShipType type){
        setName(name);
        setDestroyed(false);
        setHeight(height);
        setWidth(width);
        setShipType(type);
        
    }

    public void setName(String name) {this.name = name;}
    
    public void setHeight(int height) {this.height = height;}
    
    public void setWidth(int width) {this.width = width;}
    
    public void setVertical(boolean vertical) {this.vertical = vertical;}

    public void setDestroyed(boolean destroyed) {this.destroyed = destroyed;}

    public void setShipType(ShipType type) {this.type = type;}


    public String getName() {return name;}

    public int getHeight() {return this.height;}

    public int getWidth() {return this.width;}
    
    public boolean getVertical() {return this.vertical;}

    public boolean getDestroyed() {return this.destroyed;}

    public ShipType getShipType() {return this.type;}


}