public class DungeonMayhem{

    final static int DECK_NOT_FOUND = -3; 

    private Player currPlayer; 
    private Card[][] allDeck; 
    private Player[] allPlayers;
    private int numPlayer;

    //==================================CONSTRUCTOR=======================================//
    // DEVELOPED BY: AMARA
    public DungeonMayhem(int numPlayer){
        this.numPlayer = numPlayer;
        this.allPlayers = new Player[numPlayer];
        this.allDeck = new Card[4][];    
    }

    //==================================PUBLIC METHOD======================================//

    //DEVELOPED BY: BEAUTY
    public Player GetCurrPlayer(){
        return currPlayer; 
    }

    //DEVELOPED BY: BEAUTY
    public int NumPlayers(){
        return numPlayer;
    } 

    //DEVELOPED BY: BEAUTY
    public Player[] GetAllPlayer(){
        return allPlayers;
    }

    //DEVELOPED BY: BEAUTY
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
    public Card[][] GetDeck(){
        return allDeck;
    }

    //DEVELOPED BY: BEAUTY
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
    public void SetCurrPlayer(Player currPlayer){   
        this.currPlayer = currPlayer; 
    }


    // DEVELOPED BY: AMARA
    public void SwitchPlayer(){
        for(int i=0; i<allPlayers.length;i++){
            if(currPlayer.GetPlayerType() == allPlayers[i].GetPlayerType()){
                if(i!=(allPlayers.length - 1)){
                    currPlayer = allPlayers[i+1];
                    break;
                }
                else{
                    currPlayer = allPlayers[0];
                    break;
                }
            }  
        }
    }

    // DEVELOPED BY: AMARA
    public Player CreatePlayer(int pos, int heroType){
        allPlayers[pos] = new Player(heroType);
        return allPlayers[pos];
    }

    // DEVELOPED BY: AMARA
    public void CreateDeck(int heroType){
        allDeck[heroType] = new Card[28];
        GetCurrPlayer().CreateDeck(heroType, allDeck);
    }



    // DEVELOPED BY: AMARA
    public void ExtendCardDeck(){
        Card[] temp = new Card[ currPlayer.GetCurrPlayingCards().length + 1];
        for(int i=0; i<currPlayer.GetCurrPlayingCards().length ; i++){
            temp[i] = currPlayer.GetCurrPlayingCards()[i];  
        }
        currPlayer.SetCurrPlayingCards(temp);
    }

    // DEVELOPED BY: AMARA
    public Card Draw(){
        int currType = currPlayer.GetPlayerType();
        int cardPos = (int)(Math.random()*allDeck[currType].length);

        Card card = allDeck[currType][cardPos];

        Card[] temp = new Card[allDeck[currType].length - 1];
        int count = 0; 
        for(int i=0; i<allDeck[currType].length ;i++){
            if(i != cardPos){
                temp[count] = allDeck[currType][i];
                count++;
            }
        }
        allDeck[currType] = temp;
        return card; 
    }

    // DEVELOPED BY: AMARA
    public void AddCardToHand(Card card){
        currPlayer.GetCurrPlayingCards()[currPlayer.GetCardCount()] = card;
    }

    // DEVELOPED BY: AMARA
    public void Discard( int pos ){
        Card[] temp = new Card[ currPlayer.GetCurrPlayingCards().length - 1];
        int count = 0; 
        for(int i=0; i<currPlayer.GetCurrPlayingCards().length ;i++){
            if(i != pos){
                temp[count] = currPlayer.GetCurrPlayingCards()[i];
                count++;
            }
        }
        currPlayer.SetCurrPlayingCards(temp);
        currPlayer.SetCardCount(currPlayer.GetCardCount() - 1);
    }

    // DEVELOPED BY: AMARA
    public void Play(Card card, Player p, Player[] players){
        card.Attack(card.GetAttackCount(), p);
        card.Heal(card.GetHealCount(),currPlayer);
        card.Defense(card.GetDefenseCount(), currPlayer);
        card.MightyPower(card.GetSpecialCount(), p, players);
    }

    // DEVELOPED BY: AMARA
    public boolean HasHpGone(){
        if(currPlayer.GetPlayerHp() <= 0){
            return true;
        }
        return false;
    }

    // DEVELOPED BY: AMARA
    public boolean HasGameWinner(){
        int count = 0; 
        for(int i=0; i<allPlayers.length; i++){
            if(allPlayers[i].GetIsDead() == false){
                count++;
            }
        }
        if(count == 1){
            return true; 
        }
        return false;
    }

}