public class Missile {

    private String name;
    public MissileType type;
    private int hash;
    private boolean ready;
    public int[][] effectZone;


    Missile(){}
        
/**
     * Set the gived parameters to create the Missile object that will be used in the Game() method
     * @param language
     * @param missileType
     */
    public void setMissile(int language, MissileType type){
        setName(language);
        setType(type);
    }

    
    // * SETTEERS
    public void setName(int language) {this.name = GameText.gameText[language][hash - 2000];}
    
    public void setType(MissileType type) {this.type = type;}
    
    public void setHash(int hash) {this.hash = hash;}

    public void setReady(boolean ready) {this.ready = ready;}

    public void setEffectZone(MissileType type) {this.effectZone = type.getEffectZone();}


    // * GETTERS
    public String getName() {return this.name;}
    
    public MissileType getType() {return this.type;}
    
    public int getHash() {return this.hash;}

    public boolean isReady() {return this.ready;}

    public int[][] getEffectZone() {return this.effectZone;}


}