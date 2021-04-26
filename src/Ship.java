public class Ship {

    private String name;
    private byte size;
    private boolean orientation;
    private boolean destroyed;
    private short[] position = new short[2];


    public Ship() {}

    public Ship(String name, byte size, boolean orientation){
        setName(name);
        setSize(size);
        setOrientation(orientation);
        setDestroyed(false);
    }

    public void setName(String name) {this.name = name;}

    public void setSize(byte size) {this.size = size;}

    public void setOrientation(boolean orientation) {this.orientation = orientation;}

    public void setDestroyed(boolean destroyed) {this.destroyed = destroyed;}


    public String getName() {return name;}

    public byte getSize() {return size;}
    
    public boolean getOrientation() {return orientation;}

    public boolean getDestroyed() {return destroyed;}
    


}