public class DungeonMayhem{

    private Player currPlayer; 
    private Card[][] allDeck; 
    private Player[] allPlayers;
    private int numPlayer;  
    

    //==================================CONSTRUCTOR=======================================//
    public DungeonMayhem(){

    }
    public DungeonMayhem(int numPlayer){
        this.numPlayer = numPlayer;
        this.allPlayers = new Player[numPlayer];
        this.allDeck = new Card[4][20];   
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

    }

    public void CreatePlayer(int pos, int heroType){
        allPlayers[pos] = new Player(heroType);
    }

    public void CreateDeck(int heroType){
        GetCurrPlayer().CreateDeck(heroType, allDeck);
    }

    public Card[][] GetDeck(){
        return allDeck;
    }



}