public abstract class Card {
    public static final int ROGUE = 0; 
    public static final int BARBARIAN = 1; 
    public static final int WIZARD = 2; 
    public static final int PALADIN = 3;
   
    private int shield; 
    private int specialCount; 
    private int attackCount; 
    private int defenseCount; 
    private int drawCount; 
    private int healCount; 

    
    //==================================CONSTRUCTOR=======================================//
    public Card(){
    }

    public Card(int specialCount, int attackCount, int defenseCount, int healCount){
        this.specialCount = specialCount; 
        this.attackCount = attackCount; 
        this.defenseCount = defenseCount; 
        this.healCount = healCount; 
        this.shield = 0; 
    }

    //==================================PRIVATE METHOD====================================//



    //==================================PUBLIC METHOD=====================================//
    public int GetAttackCount(){
        return attackCount;
    }

    public int GetSpecialCount(){
        return specialCount;
    }
    public int GetDefenseCount(){
        return defenseCount;
    }
    public int GetHealCount(){
        return healCount;
    }

    public int GetShield(){
        return 0; 
    }

    public void SetShield(int shield){
        this.shield = shield; 
    }

    public void Attack(int attack, int hp){
        hp -= attack; 
    }

    public void DefenseSheild(int attack, int hp){
        if(shield>0){
            shield -= attack; 
            if(shield<0){
                shield+= attack; 
                attack -= shield; 
                shield = 0;
                hp -= attack;  
            }
        }
    }

    public void Heal(int heal, int hp){
        hp += heal;
    }

    public abstract void MightyPower(int hp);
    
}
