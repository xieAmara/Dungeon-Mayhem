public abstract class Card {
    public static final int ROGUE = 0; 
    public static final int BARBARIAN = 1; 
    public static final int WIZARD = 2; 
    public static final int PALADIN = 3;
   
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
    }

    //==================================PRIVATE METHOD====================================//



    //==================================PUBLIC METHOD=====================================//
    public int GetAttackCount(){
        return this.attackCount;
    }

    public int GetSpecialCount(){
        return this.specialCount;
    }
    public int GetDefenseCount(){
        return this.defenseCount;
    }
    public int GetHealCount(){
        return this.healCount;
    }

    public void Attack(int attack, Player p){
        int shield = p.GetPlayerShield();
        if(shield>attack){
            p.SetPlayerShield(shield-attack);
        }
        else if(shield<=attack){
            p.SetPlayerShield(0);
            attack -= shield;
            p.SetPlayerHp(p.GetPlayerHp()-attack);
        }
    }

    public void Defense(int shieldCount, Player p){
        p.SetPlayerShield(shieldCount); 
    }



    public void Heal(int heal, Player p){
        p.SetPlayerHp(p.GetPlayerHp()+heal);
        if(p.GetPlayerHp()>10){
            p.SetPlayerHp(10);
        }
    }

    public abstract void MightyPower(int hp);
    
}
