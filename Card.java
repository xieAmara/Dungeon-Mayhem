public abstract class Card {
    public static final int ROGUE = 0; 
    public static final int BARBARIAN = 1; 
    public static final int WIZARD = 2; 
    public static final int PALADIN = 3;

    private int hp;     
    private int shield; 
    private int specialCount; 
    private int attackCount; 
    private int defenseCount; 
    private int drawCount; 
    private int healCount; 

    
    //==================================CONSTRUCTOR=======================================//
    public Card(int hp){
        this.hp = hp; 
    }

    public Card(int specialCount, int attackCount, int defenseCount, int drawCount, int healCount, int hp){
        this.specialCount = specialCount; 
        this.attackCount = attackCount; 
        this.defenseCount = defenseCount; 
        this.drawCount = drawCount; 
        this.healCount = healCount; 
        this.hp = hp; 
        this.shield = 0; 
    }

    //==================================PRIVATE METHOD====================================//



    //==================================PUBLIC METHOD=====================================//
    public int GetHP(){
        return 0; 
    }

    public void SetHp(int hp){
        this.hp = hp; 
    }

    public int GetShield(){
        return 0; 
    }

    public void SetShield(int shield){
        this.shield = shield; 
    }

    public void Attack(int attack){
        this.hp -= attack; 
    }

    public void Defense(){
        
    }

    public void Heal(int hp){
        this.hp += hp;
    }

    public abstract void MightyPower(int hp);
     

}
