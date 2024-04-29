public abstract class Card {
    public static final int ROGUE = 0; 
    public static final int BARBARIAN = 1; 
    public static final int WIZARD = 2; 
    public static final int PALADIN = 3;
    
    private int hp; 
    

    public Card(int hp){
        this.hp = hp; 
    }
}
