public class Displayer {
    public Displayer(){
    }

    private String PlayerType(Player p){
        int type = p.GetPlayerType();
        if(type == Card.ROGUE){
            return "Rogue";
        }
        else if(type == Card.BARBARIAN){
            return "Barbarian";
        }
        else if(type == Card.WIZARD){
            return "Wizard";
        }
        return "Paladin";
    }

    private String CardType(Card card){
        if(card instanceof Rogue){
            return "Rogue";
        }
        else if(card instanceof Barbarian){
            return "Barbarian";
        }
        else if(card instanceof Wizard){
            return "Wizard";
        }
        return "Paladin";
    }

    public void GameHeader(){
        System.out.println("=======================================");
        System.out.println("|      WELCOME TO DUNGEON MAYHEM      |");
        System.out.println("=======================================");
    }

    public void ShowCard(Card card, int cardPos){
        String attack = "attack : "+Integer.toString(card.GetAttackCount());
        String defense = "defense : "+Integer.toString(card.GetDefenseCount());
        String special = "special : "+Integer.toString(card.GetSpecialCount());
        String heal = "heal : "+Integer.toString(card.GetHealCount());
        String cardInfo = CardType(card) +" "+ Integer.toString(cardPos);
        System.out.println("------------------------------");
        System.out.printf("|%-28s|\n", cardInfo);
        System.out.printf("|%28s|\n",attack);
        System.out.printf("|%28s|\n",defense);
        System.out.printf("|%28s|\n",special);
        System.out.printf("|%28s|\n",heal);
        System.out.println("------------------------------");

    }

    public void ShowCardHand(Card[] cards){
        for(int i = 0; i < cards.length; i++){
            if(cards[i] != null){
                ShowCard(cards[i], i+1);
            }
        }
    }

    public void DisplayDeckChoice(int player){
        System.out.println("--------------------------------------------------------------");
        System.out.printf("|%-15s%-15s%-15s%-15s|\n","1","2","3","4");
        System.out.printf("|%-15s%-15s%-15s%-15s|\n","Rogue","Barbarian","Wizard","Paladin");
        System.out.println("--------------------------------------------------------------");
        System.out.println("Player "+ player+ " pick a deck: ");
    }

    public void DisplayPlayerDetails(int hp, int shield){
        System.out.println("|============== HP SCALE ===============|         |====== SHEILD ===========================|");
        System.out.println("-----------------------------------------         -------------------------------------------");
        if(hp == 10){
            for(int i=0; i<hp; i++){
                System.out.printf("%-4s","|");
            }
            System.out.print("|");
        }
        else{
            for(int i=0; i<10-hp;i++){
                System.out.print("| X ");
            }
            for(int i=0; i<hp; i++){
                System.out.printf("%-4s","|");
            }
            System.out.print("|");
        }
        System.out.print("         ");
        if(shield==0){
            System.out.println("You have no shields at the moment");
        }
        else{
            for(int i=0; i<shield; i++){
                System.out.print("----");
            }
            System.out.println("-");
            for(int i=0; i<shield; i++){
                System.out.print("| S ");
            }
            System.out.println("|");
            for(int i=0; i<shield; i++){
                System.out.print("----");
            }
            System.out.println("-");
        }
        System.out.println("-----------------------------------------");
    }

    public void ShowPlayer(Player p){
        System.out.printf("| Player %s               |\n",PlayerType(p));
        
    }
}
