public enum MissileType {
    // 8 X 8
    SIMPLE     ("00000" + 
                "00000" +
                "00100" +
                "00000" +
                "00000", 0, 2000),

    CROSS      ("00000" + 
                "01010" +
                "00100" +
                "01010" +
                "00000", 5, 2001),
                
    SMALLT     ("00000" + 
                "00100" +
                "01110" +
                "00100" +
                "00000", 5, 2002),

    // SMALLT     ("00100" + 
    //             "00100" +
    //             "11111" +
    //             "00100" +
    //             "00100", 5, 2002),
    

    // 16 X 16
    HORSE      ("01010" + 
                "10001" +
                "00100" +
                "10001" +
                "01010", 7, 2003),

    HEART      ("01010" + 
                "10101" +
                "10001" +
                "01010" +
                "00100", 3, 2004),

    BIGCROSS   ("10001" + 
                "01010" +
                "00100" +
                "01010" +
                "10001", 15, 2005),
            
    BIGT       ("00100" +
                "00100" +
                "11111" +
                "00100" +
                "00100", 15, 2006),
    
    // 32 X 32
    NUKE       ("11111" + 
                "11111" +
                "11111" +
                "11111" +
                "11111", 40, 2007),
    
    CIRCLE     ("01110" + 
                "10001" +
                "10101" +
                "10001" +
                "01110", 22, 2008);

    //String effectString;
    int[][] effectZone;
    int cooldown;
    int hash;
                
            
    MissileType(String effectString, int cooldown, int hash){
        effectZone = new int[5][5];

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(effectString.charAt(i*5+j) == '0'){
                    this.effectZone[i][j] = 0;
                } else {
                    this.effectZone[i][j] = 1;
                }
            }
        }
        this.cooldown = cooldown;
        this.hash = hash;
    }

    // * GETTERS
    public int[][] getEffectZone() {return effectZone;}










}
