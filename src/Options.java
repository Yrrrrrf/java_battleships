public class Options {    

    int size;
    int language;


    public Options() {}
    
    /** 
     * Assign the dimentions gived by the Menu(int size) method to the gameMap[][][]
     * @param size
     */
    public Options(int size){
        setSize(size);
    }

    
    // * SETTERS
    public void setLanguage(int language){this.language = language;}
    
    public void setSize(int size) {this.size = size;}
    
    // * GETTERS
    public int getLanguage() {return this.language;}
    
    public int getSize() {return this.size;}
    
    
}