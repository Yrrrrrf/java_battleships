// All constants of the ships information
public enum ShipType{

    VESSEL      (1, 1, 1000),
    FRIGATE     (2, 1, 1001),
    DESTROYER   (3, 1, 1002),
    CRUISER     (4, 1, 1003),
    CARRIER     (5, 1, 1004);

    private int length;
    private int width;
    private int hash;

    
    /**
     * Assigns the lenght, width and hash to all the ShipType ENUMS 
     * @param length
     * @param width
     * @param hash
     */
    ShipType(int length, int width, int hash){
        this.length = length;
        this.width = width;
        this.hash = hash;

    }


    // * GETTERS
    public int getLength() {return length;}

    public int getWidth() {return width;}

    public int getHash() {return hash;}

}