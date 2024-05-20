public abstract class Card {
    public static final int ROGUE = 0;           // Rogue     position in deck[][] array
    public static final int BARBARIAN = 1;       // Barbarian position in deck[][] array
    public static final int WIZARD = 2;          // Wizard    position in deck[][] array
    public static final int PALADIN = 3;         // Paladin   position in deck[][] array
   
    private int specialCount;                    // number of specials in the card 
    private int attackCount;                     // number of attacks  in the card 
    private int defenseCount;                    // number of defenses in the card 
    private int healCount;                       // number of heals    in the card 

    
    //==================================CONSTRUCTOR=======================================//
    public Card(){
    }

    // DEVELOPED BY: BEAUTY
    public Card(int specialCount, int attackCount, int defenseCount, int healCount){
        this.specialCount = specialCount; 
        this.attackCount = attackCount; 
        this.defenseCount = defenseCount; 
        this.healCount = healCount;  
    }

    //==================================PUBLIC METHOD=====================================//

    // DEVELOPED BY: BEAUTY
    /* Get the number of attacks in the card
     * @return - an integer value of how many attack counts are present in the action card chosen 
     */
    public int GetAttackCount(){
        return this.attackCount;
    }

    // DEVELOPED BY: BEAUTY
    /* Get the number of specials in the card
     * @return - an integer value of how many special counts are present in the action card chosen 
     */
    public int GetSpecialCount(){
        return this.specialCount;
    }

    // DEVELOPED BY: BEAUTY
    /* Get the number of defenses in the card
     * @return - an integer value of how many defense counts are present in the action card chosen 
     */
    public int GetDefenseCount(){
        return this.defenseCount;
    }

    // DEVELOPED BY: BEAUTY
    /* Get the number of heals in the card
     * @return - an integer value of how many heal counts are present in the action card chosen 
     */
    public int GetHealCount(){
        return this.healCount;
    }

    // DEVELOPED BY: BEAUTY
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

    // DEVELOPED BY: BEAUTY
    public void Defense(int shield, Player p){
        p.SetPlayerShield(p.GetPlayerShield() + shield ); 
    }

    // DEVELOPED BY: BEAUTY
    public void Heal(int heal, Player p){
        p.SetPlayerHp(p.GetPlayerHp()+heal);
        if(p.GetPlayerHp()>10){
            p.SetPlayerHp(10);
        }
    }

    // DEVELOPED BY: BEAUTY
    public abstract void MightyPower(int special,Player p, Player[] players);
    
}