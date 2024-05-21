public class Player {
    private int playerHp;              
    private int playerType; 
    private Card[] currPlayingCards;
    private int playerShield;
    private int cardCount; 
    private boolean isDead;

    //==================================CONSTRUCTOR=======================================//

    // DEVELOPED BY: AMARA
    /* Initialize each player's: 
     * hp to be a default of 10 
     * sheild to be a default of 0 
     * current playing cards array to have a default of 5 elements 
     * the number of cards in hand to be zero 
     * the player's status to be alive 
     * @param playerType - The type of character that the player possess 
     *                     Rogue     : 0 
     *                     Barbarian : 1 
     *                     Wizard    : 2 
     *                     Paladin   : 3
     */
    public Player(int playerType){
        playerHp = 10; 
        playerShield = 0; 
        this.playerType = playerType;
        this.currPlayingCards = new Card[5];
        this.cardCount = 0; 
        this.isDead = false; 
    }

    //==================================PRIVATE METHOD====================================//

    // DEVELOPED BY: AMARA
    /* Get the player type 
     * @return - an integer value of the corresponding hero type 
     *           Rogue     : 0 
     *           Barbarian : 1 
     *           Wizard    : 2 
     *           Paladin   : 3
     */
    public int GetPlayerType(){
        return this.playerType;
    }

    // DEVELOPED BY: AMARA
    /* Get the player's status
     * @return - true if the player is dead
     *           false if the player is alive 
     */
    public boolean GetIsDead(){
        return this.isDead;     
    }

    // DEVELOPED BY: AMARA
    /* Get the Player's Hp
     * @return - The integer value of the player's current Hp 
     */
    public int GetPlayerHp(){
        return this.playerHp;
    }

    // DEVELOPED BY: AMARA
    /* Get the Player's sheild
     * @return - The integer value of how many sheild's the player possess
     */
    public int GetPlayerShield(){
        return this.playerShield;
    }

    // DEVELOPED BY: AMARA
    /* Get the Card Count of cards in hand
     * @return - The integer value of how much cards remain in the player's hand 
     */
    public int GetCardCount(){
        return this.cardCount; 
    }

    // DEVELOPED BY: AMARA
    /* Get the array of Card objects 
     * @return - The Card[] array of the Cards that remains in hand
     */
    public Card[] GetCurrPlayingCards(){
        return this.currPlayingCards;
    }

    // DEVELOPED BY: AMARA
    /* Set the amount of cards left in the player's hand
     * @param cardCount - The value of the cards that is left in the player's hand
     */
    public void SetCardCount(int cardCount){
        this.cardCount = cardCount;
    }
    
    // DEVELOPED BY: AMARA
    /* Set the amount of shield for each player
     * @param shield - The amount of shields that the player possess 
     */
    public void SetPlayerShield(int shield){
        this.playerShield = shield;
    }

    // DEVELOPED BY: AMARA
    /* Set the Hp of each player 
     * @param - The amount of hp that each player remains with
     */
    public void SetPlayerHp(int hp){
        this.playerHp = hp;
    }

    // DEVELOPED BY: AMARA
    /* Set the player's status 
     * @param isDead - A boolean value of the player's status 
     *                 true  - dead 
     *                 false - alive 
     */
    public void SetIsDead(boolean isDead){
        this.isDead = isDead; 
    }

    // DEVELOPED BY: AMARA
    /* Set the current playing card
     * @param pos - card's position in the Card[] array 
     * @param card - Card object to be placed in the specified position 
     */
    public void SetCurrPlayingCard(int pos, Card card){
        currPlayingCards[pos] = card; 
    }

    // DEVELOPED BY: AMARA
    /* Set current playing cards
     * @param cards - Card[] array of the current playing cards 
     */
    public void SetCurrPlayingCards(Card[] cards){
        currPlayingCards = cards;
    }

    //DEVELOPED BY: AMARA
    /* Create a deck of cards with a randomized amount of attacks, special, defense and heal. Each character have a different maximum value for each power
     * @param heroType - integer value of the type of hero 
     *                   Rogue     : 0 
     *                   Barbarian : 1 
     *                   Wizard    : 2 
     *                   Paladin   : 3  
     * @param deck - 2D Card object array of the deck to refrence the cards to 
     */
    public void CreateDeck(int heroType, Card[][] deck){
        // make 28 cards for each hero type 
        for(int i=0; i<28; i++){
            int attackCount, specialCount, defenseCount, healCount;

            // depending on the hero type create a different randomized deck of cards 
            switch(heroType){
                case Card.ROGUE: 
                    do{
                        attackCount = (int)(Math.random()*3); 
                        specialCount = (int)(Math.random()*2);
                        defenseCount = (int)(Math.random()*1); 
                        healCount = (int)(Math.random()*2); 
                    }while(attackCount==0 && specialCount==0 && defenseCount==0 && healCount==0); // make sure that there is no card with zero attacks, specials, defenses and heals 
                    // by using polymorphism add the correct character's card in the Card[][] array 
                    deck[Card.ROGUE][i] = new Rogue(specialCount, attackCount, defenseCount, healCount);
                    break;
                case Card.BARBARIAN: 
                    do{
                        attackCount = (int)(Math.random()*3); 
                        specialCount = (int)(Math.random()*1);
                        defenseCount = (int)(Math.random()*2); 
                        healCount = (int)(Math.random()*2); 
                    }while(attackCount==0 && specialCount==0 && defenseCount==0 && healCount==0);
                    deck[Card.BARBARIAN][i] = new Barbarian(specialCount, attackCount, defenseCount, healCount);
                    break;
                case Card.WIZARD: 
                    do{
                        attackCount = (int)(Math.random()*2); 
                        specialCount = (int)(Math.random()*4);
                        defenseCount = (int)(Math.random()*2); 
                        healCount = (int)(Math.random()*1); 
                    }while(attackCount==0 && specialCount==0 && defenseCount==0 && healCount==0);
                    deck[Card.WIZARD][i] = new Wizard(specialCount, attackCount, defenseCount, healCount);
                    break;
                case Card.PALADIN: 
                    do{
                        attackCount = (int)(Math.random()*2); 
                        specialCount = (int)(Math.random()*1);
                        defenseCount = (int)(Math.random()*2); 
                        healCount = (int)(Math.random()*3); 
                    }while(attackCount==0 && specialCount==0 && defenseCount==0 && healCount==0);
                    deck[Card.PALADIN][i] = new Paladin(specialCount, attackCount, defenseCount, healCount);
            }
        }
    }
}




