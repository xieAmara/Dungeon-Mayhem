public class DungeonMayhem{

    private Player currPlayer; 
    private Card[][] allDeck; 
    private Player[] allPlayers;
    private int numPlayer;
    private int remainPlayers;   

    //==================================CONSTRUCTOR=======================================//
    public DungeonMayhem(int numPlayer){
        this.numPlayer = numPlayer;
        this.allPlayers = new Player[numPlayer];
        this.allDeck = new Card[4][20];   
        this.remainPlayers = numPlayer;  
    }

    //==================================PRIVATE METHOD====================================//


    //==================================PUBLIC METHOD======================================//

    public Player GetCurrPlayer(){
        return currPlayer; 
    }

    public int NumPlayers(){
        return numPlayer;
    }

    public Player[] GetAllPlayer(){
        return allPlayers;
    }

    public void SetCurrPlayer(Player currPlayer){
        this.currPlayer = currPlayer; 
    }

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

    public Player CreatePlayer(int pos, int heroType){
        allPlayers[pos] = new Player(heroType);
        return allPlayers[pos];
    }

    public void CreateDeck(int heroType){
        GetCurrPlayer().CreateDeck(heroType, allDeck);
    }

    public Card[][] GetDeck(){
        return allDeck;
    }

    public int GetCardDeckLength(int pos){
        return allDeck[pos].length;
    }

    public void ExtendCardDeck(){
        Card[] temp = new Card[ currPlayer.GetcurrPlayingCards().length + 1];
        for(int i=0; i<currPlayer.GetcurrPlayingCards().length ; i++){
            temp[i] = currPlayer.GetcurrPlayingCards()[i];  
        }
        currPlayer.SetCurrPlayingCard(temp);
    }

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

    public void AddCardToHand(Card card){
        currPlayer.GetcurrPlayingCards()[currPlayer.GetCardCount()] = card;
    }

    public void Discard( int pos ){
        Card[] temp = new Card[ currPlayer.GetcurrPlayingCards().length - 1];
        int count = 0; 
        for(int i=0; i<currPlayer.GetcurrPlayingCards().length ;i++){
            if(i != pos){
                temp[count] = currPlayer.GetcurrPlayingCards()[i];
                count++;
            }
        }
        currPlayer.SetCurrPlayingCard(temp);
        currPlayer.SetCardCount(currPlayer.GetCardCount() - 1);
    }

    public void Play(Card card, Player p){
        card.Attack(card.GetAttackCount(), p);
        card.Heal(card.GetHealCount(),currPlayer);
        card.Defense(card.GetDefenseCount(), currPlayer);
        card.MightyPower(card.GetSpecialCount(), p);
    }

    public boolean HasHpGone(){
        if(currPlayer.GetPlayerHp() == 0){
            return true;
        }
        return false;
    }

    public void RemovePlayer(int pos){
        Player[] temp = new Player[allPlayers.length - 1];
        int count = 0; 
        for(int i=0; i<allPlayers.length ;i++){
            if(i != pos){
                temp[count] = allPlayers[i];
                count++;
            }
        }
        allPlayers = temp;
    }

    public boolean HasGameWinner(){
        if(allPlayers.length == 1){
            return true; 
        }
        return false;
    }

}