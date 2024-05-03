public class Player {
    private int playerHp; 
    private int playerType; 
    private Card[] currPlayerCards;
    //==================================CONSTRUCTOR=======================================//
    public Player(int playerType){
        playerHp = 10; 
        this.playerType = playerType;
        this.currPlayerCards = new Card[7];
    }

    //==================================PRIVATE METHOD====================================//

    public int GetPlayerType(){
        return this.playerType;
    }

    public int GetPlayerHp(){
        return this.playerHp;
    }
    
    public void ReduceHp(int hp){
        playerHp -= hp;
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
