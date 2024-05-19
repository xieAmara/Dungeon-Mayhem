public class Player {
    private int playerHp; 
    private int playerType; 
    private Card[] currPlayingCards;
    private int playerShield;
    private int cardCount; 
    private boolean isDead;

    //==================================CONSTRUCTOR=======================================//

    // DEVELOPED BY: AMARA
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
    public int GetPlayerType(){
        return this.playerType;
    }

    // DEVELOPED BY: AMARA
    public boolean GetIsDead(){
        return this.isDead;     
    }

    // DEVELOPED BY: AMARA
    public int GetPlayerHp(){
        return this.playerHp;
    }

    // DEVELOPED BY: AMARA
    public int GetPlayerShield(){
        return this.playerShield;
    }

    // DEVELOPED BY: AMARA
    public int GetCardCount(){
        return this.cardCount; 
    }

    // DEVELOPED BY: AMARA
    public void SetCardCount(int cardCount){
        this.cardCount = cardCount;
    }
    
    // DEVELOPED BY: AMARA
    public void SetPlayerShield(int shield){
        this.playerShield = shield;
    }

    // DEVELOPED BY: AMARA
    public void SetPlayerHp(int hp){
        this.playerHp = hp;
    }

    // DEVELOPED BY: AMARA
    public void SetIsDead(boolean isDead){
        this.isDead = isDead; 
    }

    // DEVELOPED BY: AMARA
    public int GetCurrPlayingCardNum(){
        return this.currPlayingCards.length; 
    }

    // DEVELOPED BY: AMARA
    public Card[] GetCurrPlayingCards(){
        return this.currPlayingCards;
    }

    // DEVELOPED BY: AMARA
    public void SetCurrPlayingCard(int pos, Card card){
        currPlayingCards[pos] = card; 
    }

    // DEVELOPED BY: AMARA
    public void SetCurrPlayingCards(Card[] cards){
        currPlayingCards = cards;
    }

    //DEVELOPED BY: AMARA
    public void CreateDeck(int heroType, Card[][] deck){
        for(int i=0; i<28; i++){
            int attackCount, specialCount, defenseCount, healCount;

            switch(heroType){
                case Card.ROGUE: 
                    do{
                        attackCount = (int)(Math.random()*4); 
                        specialCount = (int)(Math.random()*2);
                        defenseCount = (int)(Math.random()*1); 
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
                        attackCount = (int)(Math.random()*3); 
                        specialCount = (int)(Math.random()*4);
                        defenseCount = (int)(Math.random()*1); 
                        healCount = (int)(Math.random()*1); 
                    }while(attackCount==0 && specialCount==0 && defenseCount==0 && healCount==0);
                    deck[Card.WIZARD][i] = new Wizard(specialCount, attackCount, defenseCount, healCount);
                    break;
                case Card.PALADIN: 
                    do{
                        attackCount = (int)(Math.random()*3); 
                        specialCount = (int)(Math.random()*1);
                        defenseCount = (int)(Math.random()*2); 
                        healCount = (int)(Math.random()*3); 
                    }while(attackCount==0 && specialCount==0 && defenseCount==0 && healCount==0);
                    deck[Card.PALADIN][i] = new Paladin(specialCount, attackCount, defenseCount, healCount);
            }
        }
    }
}




