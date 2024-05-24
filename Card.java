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
    /* Default Constructor */
    public Card(){
    }

    // DEVELOPED BY: BEAUTY
    /* Initialize the card's instance variables: 
     * Initialize the number of special
     * Initialize the number of attack
     * Initialize the number of shields
     * Initialize the number of heal
     */
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
    /* Attacks the players regarding the attack count on the cards
     * @param attack - number of attack
     * @param p - person to attack
     */
    public void Attack(int attack, Player p){
        int shield = p.GetPlayerShield();
        // determines if the number of shield is greather than the number of attack
        if(shield>attack){
            // deducts the number of shield 
            p.SetPlayerShield(shield-attack);
        }
        else if(shield<=attack){
            // set the number of shield to 0 and detucts the remaining number of attack from the hp
            p.SetPlayerShield(0);
            attack -= shield;
            p.SetPlayerHp(p.GetPlayerHp()-attack);
        }
    }

    // DEVELOPED BY: BEAUTY
    /* Addition of number of shield depending on the card
     * @param shield - number of shield on the card
     * @param p      - the player
     */
    public void Defense(int shield, Player p){
        // Gets the number of shield and add the number of shield and updattes it 
        p.SetPlayerShield(p.GetPlayerShield() + shield ); 
    }

    // DEVELOPED BY: BEAUTY
    /* Addition of health depending on the card
     * @param heal - number of heal on the card
     * @param p    - the player
     */
    public void Heal(int heal, Player p){
        p.SetPlayerHp(p.GetPlayerHp()+heal);
        // increases player's health depending on number of heal

        // Number of health is greater than 10
        if(p.GetPlayerHp()>10){
            p.SetPlayerHp(10);
            // sets the maximum hp to 10
        }
    }

    // DEVELOPED BY: BEAUTY
    /* attacks the selected player depending on the special count 
     * @param special  - numnber of special 
     * @param p        - player to attack
     * @param players  - all players present
     */
    public abstract void MightyPower(int special,Player p, Player[] players); 
}