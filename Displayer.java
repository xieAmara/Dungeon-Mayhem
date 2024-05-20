public class Displayer {
    //==================================CONSTRUCTOR====================================//
    public Displayer(){
    }

    //==================================PRIVATE METHOD====================================//

    // DEVELOPED BY: AMARA
    /* Recursive method to determine the n number of rows needed if cards are to be sorted in a 4 x n grid. 
     * @param len - number of cards that still needs to be sorted
     * @return    - number of rows (n) needed 
     */
    private int rowNum(int len){
        if(len == 4 || len/4 == 0){
            return 1; 
        }else{
            return 1 + rowNum(len-4);
        }
    }

    // DEVELOPED BY: BEAUTY
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

    // DEVELOPED BY: BEAUTY
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

    // DEVELOPED BY: BEAUTY
    private String getStatus(Player p){
        if(p.GetIsDead()){
            return "Dead";
        }
        return "Alive";
    }

    // DEVELOPED BY: AMARA
    /* Output one row of cards in the card hand. Each row can have a maximum of four cards, minimum of 1
     * @param cards - Card array of card hand 
     * @param num   - number of cards to display 
     * @param count - card number of the first card in each row 
     */
    private void printCards(Card[] cards, int num,int count){
        // display the top border of cards 
        for(int j = 0; j < num; j++){
            System.out.print("------------------------------     ");
        }
        System.out.println(" ");
        // display the info of cards 
        for(int j = 0; j < num; j++){
            // count+j is used to access the exact card in the array
            String cardInfo = cardType(cards[count + j]) +" "+ Integer.toString(count+j+1);
            System.out.printf("|%-28s|     ", cardInfo);
        }
        System.out.println(" ");
        // ddisplay the attack info of cards
        for(int j = 0; j < num; j++){
            String attack = "attack : "+Integer.toString(cards[count + j].GetAttackCount());
            System.out.printf("|%28s|     ",attack);
        }
        System.out.println(" ");
        // ddisplay the defese info of cards
        for(int j = 0; j < num; j++){
            String defense = "defense : "+Integer.toString(cards[count + j].GetDefenseCount());
            System.out.printf("|%28s|     ",defense);
        }
        System.out.println(" ");
        // ddisplay the special info of cards
        for(int j = 0; j < num; j++){
            String special = "special : "+Integer.toString(cards[count + j].GetSpecialCount());
            System.out.printf("|%28s|     ",special);
        }
        System.out.println(" ");
        // ddisplay the heal info of cards
        for(int j = 0; j < num; j++){
            String heal = "heal : "+Integer.toString(cards[count + j].GetHealCount());
            System.out.printf("|%28s|     ",heal);
        }
        System.out.println(" ");
        // ddisplay the bottom border of cards
        for(int j = 0; j < num; j++){
            System.out.print("------------------------------     ");
        }
    }

    //================================ PUBLIC METHODS =====================================// 

    // DEVELOPED BY: BEAUTY
    public void GameHeader(){
        System.out.println("=======================================");
        System.out.println("|      WELCOME TO DUNGEON MAYHEM      |");
        System.out.println("=======================================");
    }

    // DEVELOPED BY: AMARA
    /* Displays all the cards in hand with the format of a 4xn grid 
     * @param cards - Card[] array of card hand
     */
    public void ShowCardHand(Card[] cards){
        // find number of rows 
        int rows = rowNum(cards.length);
        // keep track of the remaining cards left to display 
        int col = cards.length; 
        // keep track of the card number required to dispaly 
        int count = 0; 

        // loop the cards depending on the number of rows 
        for(int i=0; i<rows; i++){
            // if there are more than 4 cards left to display, display a full row of cards 
            if(col >= 4){
                printCards(cards, 4, count);
                System.out.println(" ");
            }
            // if not display the remaining cards left for the last row 
            else{
                printCards(cards, col, count);
            }
            // incease the card number by four, and decrase the remaining cards by four to continue on the next four set of cards 
            count += 4; 
            col -=4;
        }
        System.out.println("");
    }

    // DEVELOPED BY: BEAUTY
    public void DisplayDeckChoice(int player){
        System.out.println("--------------------------------------------------------------");
        System.out.printf("|%-15s%-15s%-15s%-15s|\n","1","2","3","4");
        System.out.printf("|%-15s%-15s%-15s%-15s|\n","Rogue","Barbarian","Wizard","Paladin");
        System.out.println("--------------------------------------------------------------");
        System.out.println("Player "+ player+ " pick a deck: ");
    }

    // DEVELOPED BY: AMARA
    /* Display the HP Scale and the Sheild of each player
     * @param hp      - player's hp 
     * @param sheild  - player's number of sheilds 
     */
    public void DisplayPlayerDetails(int hp, int shield){
        System.out.println("|============== HP SCALE ===============|         |====== SHEILD ===========================|");
        System.out.println("-----------------------------------------         -------------------------------------------");
        // Display HP 
        // if there is a full hp, display an empty hp scale bar
        if(hp == 10){
            for(int i=0; i<hp; i++){
                System.out.printf("%-4s","|");
            }
            System.out.print("|");
        }
        // if not then display how many damages it took 
        else{
            // display the damages that it took 
            for(int i=0; i<10-hp;i++){
                System.out.print("| X ");
            }
            // display the empty grid of remaining hp 
            for(int i=0; i<hp; i++){
                System.out.printf("%-4s","|");
            }
            System.out.print("|");
        }
        System.out.print("         ");

        // Display Shield
        // prompt a message that there are no sheilds if the shield count is zero
        if(shield==0){
            System.out.println("You have no shields at the moment");
        }

        // display the number of sheilds that the player aquired 
        else{
            for(int i=0; i<shield; i++){
                System.out.print("| S ");
            }
            System.out.println("|");
        }
        System.out.println("-----------------------------------------         -------------------------------------------");
    }

    // DEVELOPED BY: BEAUTY
    public void ShowPlayer(Player p){
        System.out.println("");
        System.out.println("========================================");
        System.out.printf("|Player %-31s|\n",playerType(p));
        System.out.println("========================================");
        System.out.println("");
    }

    // DEVELOPED BY: BEAUTY
    public void ShowPlayers(Player[] players){
        System.out.println(" ");
        for(int i=0; i<players.length; i++){
            String status = getStatus(players[i]);
            System.out.printf((i+1)+ " %-10s - status: %-5s\n",playerType(players[i]),status);
        }
    }

    // DEVELOPED BY: BEAUTY
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
