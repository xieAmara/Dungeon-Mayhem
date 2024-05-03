public class Player {
    private int playerHp; 
    private int playerType; 
    //==================================CONSTRUCTOR=======================================//
    public Player(int playerType){
        playerHp = 10; 
        this.playerType = playerType;
    }

    //==================================PRIVATE METHOD====================================//

    public void CreateDeck(int heroType, Card[][] deck){
        for(int i=0; i<20; i++){
            int attackCount, specialCount, defenseCount, healCount;
            do{
                attackCount = (int)(Math.random()*4); 
                specialCount = (int)(Math.random()*1);
                defenseCount = (int)(Math.random()*3); 
                healCount = (int)(Math.random()*1); 
            }while(attackCount==0 && specialCount==0 && defenseCount==0 & healCount==0);

            switch(heroType){
                case 0: 
                    deck[0][i] = new Rogue(specialCount, attackCount, defenseCount, healCount);
                    break;
                case 1: 
                    deck[1][i] = new Barbarian(specialCount, attackCount, defenseCount, healCount);
                    break;
                case 2: 
                    deck[2][i] = new Wizard(specialCount, attackCount, defenseCount, healCount);
                    break;
                case 3: 
                    deck[3][i] = new Paladin(specialCount, attackCount, defenseCount, healCount);
            }
        }
    }

    public int GetPlayerType(){
        return this.playerType;
    }


}
