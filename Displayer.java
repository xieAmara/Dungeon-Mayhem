public class Displayer {
    public Displayer(){
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

    public void ShowCard(Card card){
        String attack = "attack : "+Integer.toString(card.GetAttackCount());
        String defense = "defense : "+Integer.toString(card.GetDefenseCount());
        String special = "special : "+Integer.toString(card.GetSpecialCount());
        String heal = "heal : "+Integer.toString(card.GetHealCount());
        System.out.println("------------------------------");
        System.out.printf("|%-28s|\n", CardType(card));
        System.out.printf("|%28s|\n",attack);
        System.out.printf("|%28s|\n",defense);
        System.out.printf("|%28s|\n",special);
        System.out.printf("|%28s|\n",heal);
        System.out.println("------------------------------");

    }

    public void DisplayDeckChoice(int player){
        System.out.println("--------------------------------------------------------------");
        System.out.printf("|%-15s%-15s%-15s%-15s|\n","1","2","3","4");
        System.out.printf("|%-15s%-15s%-15s%-15s|\n","Rogue","Barbarian","Wizard","Paladin");
        System.out.println("--------------------------------------------------------------");
        System.out.println("Player "+ player+ " pick a deck: ");
    }
    
    public void ShowDiscard(){

    }

    public void ShowHP(){

    }

    public void ShowShield(){

    }
}
