// All contstants of the ships information
public enum ShipType{
    VESSEL      (1, 1, 1011),
    FRIGATE     (2, 1, 1012),
    DESTROYER   (3, 1, 1013),
    CRUISER     (4, 1, 1014),
    CARRIER     (5, 1, 1015);

    int length;
    int width;
    int hash;
    
    /**
     * Assign th lenght, width and hast to all the ShipType ENUMS 
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