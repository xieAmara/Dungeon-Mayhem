public class Player {
    private int playerHp; 
    private int playerType; 
    private Card[] currPlayingCards;
    private int playerShield;
    private int cardCount; 
    private boolean isDead;

    //==================================CONSTRUCTOR=======================================//
    public Player(int playerType){
        playerHp = 10; 
        playerShield = 0; 
        this.playerType = playerType;
        this.currPlayingCards = new Card[5];
        this.cardCount = 0; 
        this.isDead = false; 
    }

    //==================================PRIVATE METHOD====================================//

    public int GetPlayerType(){
        return this.playerType;
    }

    public boolean GetIsDead(){
        return this.isDead; 
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

    public void SetIsDead(boolean isDead){
        this.isDead = isDead; 
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
        for(int i=0; i<28; i++){
            int attackCount, specialCount, defenseCount, healCount;

            switch(heroType){
                case Card.ROGUE: 
                    do{
                        attackCount = (int)(Math.random()*2); 
                        specialCount = (int)(Math.random()*2);
                        defenseCount = (int)(Math.random()*2); 
                        healCount = (int)(Math.random()*2); 
                    }while(attackCount==0 && specialCount==0 && defenseCount==0 && healCount==0);
                    deck[Card.ROGUE][i] = new Rogue(specialCount, attackCount, defenseCount, healCount);
                    break;
                case Card.BARBARIAN: 
                    do{
                        attackCount = (int)(Math.random()*4); 
                        specialCount = (int)(Math.random()*1);
                        defenseCount = (int)(Math.random()*2); 
                        healCount = (int)(Math.random()*2); 
                    }while(attackCount==0 && specialCount==0 && defenseCount==0 && healCount==0);
                    deck[Card.BARBARIAN][i] = new Barbarian(specialCount, attackCount, defenseCount, healCount);
                    break;
                case Card.WIZARD: 
                    do{
                        attackCount = (int)(Math.random()*2); 
                        specialCount = (int)(Math.random()*3);
                        defenseCount = (int)(Math.random()*2); 
                        healCount = (int)(Math.random()*3); 
                    }while(attackCount==0 && specialCount==0 && defenseCount==0 && healCount==0);
                    deck[Card.WIZARD][i] = new Wizard(specialCount, attackCount, defenseCount, healCount);
                    break;
                case Card.PALADIN: 
                    do{
                        attackCount = (int)(Math.random()*4); 
                        specialCount = (int)(Math.random()*1);
                        defenseCount = (int)(Math.random()*4); 
                        healCount = (int)(Math.random()*2); 
                    }while(attackCount==0 && specialCount==0 && defenseCount==0 && healCount==0);
                    deck[Card.PALADIN][i] = new Paladin(specialCount, attackCount, defenseCount, healCount);
            }
        }
    }

    


}
