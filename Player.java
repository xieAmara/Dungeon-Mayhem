public class Player {
    private int playerHp; 
    private int playerType; 
    private Card[] currPlayingCards;
    private int playerShield;
    private int cardCount; 
    //==================================CONSTRUCTOR=======================================//
    public Player(int playerType){
        playerHp = 10; 
        playerShield = 0; 
        this.playerType = playerType;
        this.currPlayingCards = new Card[5];
        this.cardCount = 0; 
    }

    //==================================PRIVATE METHOD====================================//

    public int GetPlayerType(){
        return this.playerType;
    }

    public int GetPlayerHp(){
        return this.playerHp;
    }

    public int GetPlayerShield(){
        return this.playerShield;
    }

    public int GetCardCount(){
        return this.cardCount; 
    }

    public void SetCardCount(int cardCount){
        this.cardCount = cardCount;
    }
    public void SetPlayerShield(int shield){
        this.playerShield = shield;
    }

    public void SetPlayerHp(int hp){
        this.playerHp = hp;
    }

    public int GetCurrPlayingCardNum(){
        return this.currPlayingCards.length; 
    }
    

    public Card[] GetcurrPlayingCards(){
        return this.currPlayingCards;
    }

    public void SetCurrPlayingCard(int pos, Card card){
        currPlayingCards[pos] = card; 
    }

    public void SetCurrPlayingCards(Card[] cards){
        currPlayingCards = cards;
    }

    public void CreateDeck(int heroType, Card[][] deck){
        for(int i=0; i<20; i++){
            int attackCount, specialCount, defenseCount, healCount;
            do{
                attackCount = (int)(Math.random()*4); 
                specialCount = (int)(Math.random()*2);
                defenseCount = (int)(Math.random()*3); 
                healCount = (int)(Math.random()*2); 
            }while(attackCount==0 && specialCount==0 && defenseCount==0 & healCount==0);

            switch(heroType){
                case Card.ROGUE: 
                    deck[Card.ROGUE][i] = new Rogue(specialCount, attackCount, defenseCount, healCount);
                    break;
                case Card.BARBARIAN: 
                    deck[Card.BARBARIAN][i] = new Barbarian(specialCount, attackCount, defenseCount, healCount);
                    break;
                case Card.WIZARD: 
                    deck[Card.WIZARD][i] = new Wizard(specialCount, attackCount, defenseCount, healCount);
                    break;
                case Card.PALADIN: 
                    deck[Card.PALADIN][i] = new Paladin(specialCount, attackCount, defenseCount, healCount);
            }
        }
    }

    


}
