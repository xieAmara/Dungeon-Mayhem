public class DungeonMayhem{

    final static int DECK_NOT_FOUND = -3;      // Returns -3 if the deck aquired is not found

    private Player currPlayer;                 // Keep track of current Player that is in action 
    private Card[][] allDeck;                  // 2D array of all the cards in deck: allDeck[i][j], where i is the character type for the deck and j is all the cards 
    private Player[] allPlayers;               // Array of all the Players in game 
    private int numPlayer;                     // Kee[ track of the number of players present in the game (minimum 1 and maximum 4)

    //==================================CONSTRUCTOR=======================================//
    // DEVELOPED BY: AMARA
    /* Initialize the game's instance variables: 
     * initalize the number of players, 
     * initialize a Player array depending on the number of players, 
     * initialize a 2D Card array that creates four empty decks for the resepective characters 
     * @param numPlayer - number of players present in the game 
     */
    public DungeonMayhem(int numPlayer){
        this.numPlayer = numPlayer;                           
        this.allPlayers = new Player[numPlayer];
        this.allDeck = new Card[4][];    
    }

    //==================================PUBLIC METHOD======================================//

    //DEVELOPED BY: BEAUTY
    /* Get the Player object of the current player
     * @return - The current player
     */
    public Player GetCurrPlayer(){
        return currPlayer; 
    }

    //DEVELOPED BY: BEAUTY
    /* Get the number of players
     * @return - an integer of how many players are in game
     */
    public int NumPlayers(){
        return numPlayer;
    } 

    //DEVELOPED BY: BEAUTY
    /* Get the Player object array
     * @return - the array that contains all of the players object
     */
    public Player[] GetAllPlayer(){
        return allPlayers;
    }

    //DEVELOPED BY: BEAUTY
    /* Get the String of the current player name
     * @return - the character name of the current player
     */
    public String GetCurrPlayerName(){
        int type = currPlayer.GetPlayerType();
        switch(type){
            case Card.ROGUE: 
                return "Rogue";
            case Card.BARBARIAN: 
                return "Barbarian";
            case Card.PALADIN:
                return "Paladin";
            case Card.WIZARD: 
                return "Wizard";
        }
        return null;
    }

    //DEVELOPED BY: BEAUTY
    /* Get the 2D Card object array of the card deck
     * @return - the array that contains all of the cards for each respective character 
     */
    public Card[][] GetDeck(){
        return allDeck;
    }

    //DEVELOPED BY: BEAUTY
    /* Get the length of the card deck 
     * @param heroType - type of hero the player possess 
     * @return - an integer of the card deck length for the hero type specified 
     */
    public int GetCardDeckLength(int heroType){
        switch(heroType){
            case Card.ROGUE: 
                return allDeck[Card.ROGUE].length;
            case Card.BARBARIAN: 
                return allDeck[Card.BARBARIAN].length;
            case Card.WIZARD: 
                return allDeck[Card.WIZARD].length;
            case Card.PALADIN: 
                return allDeck[Card.PALADIN].length;
            default: 
                return DECK_NOT_FOUND;
        }
    }

    // DEVELOPED BY: AMARA
    /* Set who will be the current player 
     * @param currPlayer - the object of the player 
     */
    public void SetCurrPlayer(Player currPlayer){   
        this.currPlayer = currPlayer; 
    }


    // DEVELOPED BY: AMARA
    /* Switches the player to the next in action. 
     * If the current player is player 1, it will switch to player 2. 
     * If the current player is the last player in turn, it will switch back to player 1
     */
    public void SwitchPlayer(){
        // loop for all of the players in the array 
        for(int i=0; i<allPlayers.length;i++){
        // if the current player is the player accessed in the loop array
            if(currPlayer.GetPlayerType() == allPlayers[i].GetPlayerType()){
                // check if the current player is the last player in the array 
                // if it is not then proceed to the next player in action
                if(i!=(allPlayers.length - 1)){
                    currPlayer = allPlayers[i+1];
                    break;
                }
                // if the current player is the last in the array, return back to player 1
                else{
                    currPlayer = allPlayers[0];
                    break;
                }
            }  
        }
    }

    // DEVELOPED BY: AMARA
    /* Creates and returns the player of the specified heroType
     * @param pos - position of the player in the allPlayers array
     * @param heroType - integer value of the type of hero 
     *                   Rogue     : 0 
     *                   Barbarian : 1 
     *                   Wizard    : 2 
     *                   Paladin   : 3 
     * @return - Returns the created player 
     */
    public Player CreatePlayer(int pos, int heroType){
        allPlayers[pos] = new Player(heroType);
        return allPlayers[pos];
    }

    // DEVELOPED BY: AMARA
    /* Creates a 28 card deck for the specified hero Type
     * @param heroType - integer value of the type of hero 
     *                   Rogue     : 0 
     *                   Barbarian : 1 
     *                   Wizard    : 2 
     *                   Paladin   : 3  
     */
    public void CreateDeck(int heroType){
        allDeck[heroType] = new Card[28];
        GetCurrPlayer().CreateDeck(heroType, allDeck);
    }



    // DEVELOPED BY: AMARA
    /* Extends the array of the cards in hand */
    public void ExtendCardDeck(){
        // creates a temporary Card array with an incremented length of the currPlayingCards array 
        Card[] temp = new Card[ currPlayer.GetCurrPlayingCards().length + 1];

        // copy all of the values from the old array to the temp 
        for(int i=0; i<currPlayer.GetCurrPlayingCards().length ; i++){
            temp[i] = currPlayer.GetCurrPlayingCards()[i];  
        }

        // change the reference of the currPlayingCards array to temp 
        currPlayer.SetCurrPlayingCards(temp);
    }

    // DEVELOPED BY: AMARA
    /* Draws one random card from their respective pile and remove that card from the pile (allDeck length will also decrement)
     * @return - Returns the Card that is drawn
     */
    public Card Draw(){
        // access the player type of the current player 
        int currType = currPlayer.GetPlayerType();

        // randomize a card to pick from the pile 
        int cardPos = (int)(Math.random()*allDeck[currType].length);

        // access the randomized card
        Card card = allDeck[currType][cardPos];

        // create a temporary Card array with a decremented length of the currPlayingCards array 
        Card[] temp = new Card[allDeck[currType].length - 1];

        // keep track of the cards that excludes the removed card 
        int count = 0;
        
        // copy all the values BUT the removed card 
        for(int i=0; i<allDeck[currType].length ;i++){
            if(i != cardPos){
                temp[count] = allDeck[currType][i];
                count++;
            }
        }

        // change the card refrence 
        allDeck[currType] = temp;
        return card; 
    }

    // DEVELOPED BY: AMARA
    /* Add the current Card into the currPlayingCards array */
    public void AddCardToHand(Card card){
        currPlayer.GetCurrPlayingCards()[currPlayer.GetCardCount()] = card;
    }

    // DEVELOPED BY: AMARA
    /* Discard the card by removing it from the currPlayingCards
     * @param pos - position of the card that is in the currPlayingCards (pos 0 being the first card) 
     */
    public void Discard( int pos ){
        // create a temporary Card[] array with one less length of currPlayingCards
        Card[] temp = new Card[ currPlayer.GetCurrPlayingCards().length - 1];

        // keep track of the card count and copy all the cards but the discarded one
        int count = 0; 
        for(int i=0; i<currPlayer.GetCurrPlayingCards().length ;i++){
            if(i != pos){
                temp[count] = currPlayer.GetCurrPlayingCards()[i];
                count++;
            }
        }

        // change the refrence of the temp and reduce the card count by one 
        currPlayer.SetCurrPlayingCards(temp);
        currPlayer.SetCardCount(currPlayer.GetCardCount() - 1);
    }

    // DEVELOPED BY: AMARA
    /* Play the actions on the chosen card 
     * @param card    - the card that is chosen 
     * @param p       - the targetted player that you are attacking or applying special powers (defense and heal is applied to the currentPlayer not the targetted)
     * @param players - the array of all the players in game 
     */
    public void Play(Card card, Player p, Player[] players){
        card.Attack(card.GetAttackCount(), p);
        card.Heal(card.GetHealCount(),currPlayer);
        card.Defense(card.GetDefenseCount(), currPlayer);
        card.MightyPower(card.GetSpecialCount(), p, players);
    }

    // DEVELOPED BY: AMARA
    /* Check if Hp of the current player is gone
     * @return - Returns true if the hp is less than or equal to zero
     *           Returns false if the hp is still above zero
     */
    public boolean HasHpGone(){
        if(currPlayer.GetPlayerHp() <= 0){
            return true;
        }
        return false;
    }

    // DEVELOPED BY: AMARA
    /* Determine if there is a game winner by checking how many players are left 
     * @return - Returns true if only one player is remaining
     *         - Returns false if there is more than one player remaining
     */
    public boolean HasGameWinner(){
        // count of how many player are alive
        int count = 0; 
        // loop the players array 
        for(int i=0; i<allPlayers.length; i++){
            if(allPlayers[i].GetIsDead() == false){
                count++;
            }
        }

        // if only one player is remaining then return true, else return fales 
        if(count == 1){
            return true; 
        }
        return false;
    }
}