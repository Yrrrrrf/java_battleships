public class Options {    

    int size;
    int language;


    public Options() {}
    
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