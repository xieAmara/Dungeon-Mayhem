public class Displayer {
    public Displayer(){
    }

    private int rowNum(int len){
        if(len == 4 || len/4 == 0){
            return 1; 
        }else{
            return 1 + rowNum(len-4);
        }
    }

    private String playerType(Player p){
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

    private String cardType(Card card){
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

    private String getStatus(Player p){
        if(p.GetIsDead()){
            return "Dead";
        }
        return "Alive";
    }

    private void printCards(Card[] cards, int num,int count){
        for(int j = 0; j < num; j++){
            System.out.print("------------------------------     ");
        }
        System.out.println(" ");
        for(int j = 0; j < num; j++){
            String cardInfo = cardType(cards[count + j]) +" "+ Integer.toString(count+j+1);
            System.out.printf("|%-28s|     ", cardInfo);
        }
        System.out.println(" ");
        for(int j = 0; j < num; j++){
            String attack = "attack : "+Integer.toString(cards[count + j].GetAttackCount());
            System.out.printf("|%28s|     ",attack);
        }
        System.out.println(" ");
        for(int j = 0; j < num; j++){
            String defense = "defense : "+Integer.toString(cards[count + j].GetDefenseCount());
            System.out.printf("|%28s|     ",defense);
        }
        System.out.println(" ");
        for(int j = 0; j < num; j++){
            String special = "special : "+Integer.toString(cards[count + j].GetSpecialCount());
            System.out.printf("|%28s|     ",special);
        }
        System.out.println(" ");
        for(int j = 0; j < num; j++){
            String heal = "heal : "+Integer.toString(cards[count + j].GetHealCount());
            System.out.printf("|%28s|     ",heal);
        }
        System.out.println(" ");
        for(int j = 0; j < num; j++){
            System.out.print("------------------------------     ");
        }
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
        String cardInfo = cardType(card) +" "+ Integer.toString(cardPos);
        System.out.println("------------------------------");
        System.out.printf("|%-28s|\n", cardInfo);
        System.out.printf("|%28s|\n",attack);
        System.out.printf("|%28s|\n",defense);
        System.out.printf("|%28s|\n",special);
        System.out.printf("|%28s|\n",heal);
        System.out.println("------------------------------");

    }

    public void ShowCardHand(Card[] cards){
        int rows = rowNum(cards.length);
        int col = cards.length; 
        int count = 0; 
        for(int i=0; i<rows; i++){
            if(col >= 4){
                printCards(cards, 4, count);
                System.out.println(" ");
            }
            else{
                printCards(cards, col, count);
            }
            count += 4; 
            col -=4;
        }
        System.out.println("");
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
                System.out.print("| S ");
            }
            System.out.println("|");
        }
        System.out.println("-----------------------------------------         -------------------------------------------");
    }

    public void ShowPlayer(Player p){
        System.out.println("");
        System.out.println("========================================");
        System.out.printf("|Player %-31s|\n",playerType(p));
        System.out.println("========================================");
        System.out.println("");
    }

    public void ShowPlayers(Player[] players){
        System.out.println(" ");
        for(int i=0; i<players.length; i++){
            String status = getStatus(players[i]);
            System.out.printf((i+1)+ " %-10s - status: %-5s\n",playerType(players[i]),status);
        }
    }

    public void DisplayWinner(Player p){
        System.out.println("========================================"); 
        System.out.println("|                                      |");
        System.out.println("|                                      |");
        System.out.printf("| The Winner Is Player %-16s|\n",playerType(p));
        System.out.println("|                                      |");
        System.out.println("|                                      |");
        System.out.println("========================================");
    }
}
