import java.util.Scanner; 
public class DungeonMayhemMain {
    /*
     * Game starts here
     */
     public static void main(String[] args) {
        DungeonMayhem dm; 
        Displayer displayer = new Displayer(); 
        Scanner input = new Scanner(System.in);

        displayer.GameHeader();
        System.out.print("How many players? (minimum 2, maximum 4): ");
        int player = input.nextInt();
        while(player>4 || player <2){
            System.out.println("ERROR! Please enter a valid amount of player");
            System.out.print("How many players? (minimum 2, maximum 4): ");
            player = input.nextInt();
        }
        dm = new DungeonMayhem(player); 
        boolean[] deckTrack = {false, false, false, false}; 
        for(int i=0; i<player; i++){
            displayer.DisplayDeckChoice(i+1);
            int deckChoice = input.nextInt();

            while(deckChoice<1 || deckChoice>4){
                System.out.println("ERROR! Please enter a valid deck choice");
                displayer.DisplayDeckChoice(i+1);
                deckChoice = input.nextInt();
            }
            while(deckTrack[deckChoice - 1]){
                System.out.println("ERROR! This deck is taken, please choose another deck");
                displayer.DisplayDeckChoice(i+1);
                deckChoice = input.nextInt();
            }
            dm.SetCurrPlayer(dm.CreatePlayer(i, deckChoice - 1));
            dm.CreateDeck(deckChoice - 1);
            deckTrack[deckChoice - 1] = true; 
            for(int j=0; j<5; j++){
                dm.AddCardToHand(dm.Draw());
                dm.GetCurrPlayer().SetCardCount(dm.GetCurrPlayer().GetCardCount() + 1);
            }
        }
        dm.SetCurrPlayer(dm.GetAllPlayer()[0]);
        
        while(!dm.HasGameWinner()){
            if(dm.HasHpGone()){
                dm.RemovePlayer();
            }else{
                Player currPlayer = dm.GetCurrPlayer();
                displayer.ShowPlayer(currPlayer);
                System.out.println("========================================");
                System.out.println("|              DRAW PHASE              |");
                System.out.println("========================================");
                System.out.println("");
                for(int j=0; j<2; j++){
                    dm.ExtendCardDeck();
                    dm.AddCardToHand(dm.Draw());
                    currPlayer.SetCardCount(currPlayer.GetCardCount() + 1);
                }
                displayer.DisplayPlayerDetails(currPlayer.GetPlayerHp(), currPlayer.GetPlayerShield());
                System.out.println("");
                System.out.println("");

                System.out.println("========================================");
                System.out.println("|             ACTION PHASE             |");
                System.out.println("========================================");
                int cardOpt, playerOpt; 
                System.out.print("How many action will you play (minimum 0 maximum 2): ");
                int actionOpt = input.nextInt();
                while(actionOpt <0 || actionOpt>2){
                    System.out.println("ERROR! Invalid Option");
                    System.out.print("How many action will you play (minimum 0 maximum 2): ");
                    actionOpt = input.nextInt();
                }

                for(int i=0; i<actionOpt; i++){
                    displayer.ShowCardHand(currPlayer.GetcurrPlayingCards());
                    System.out.print("Choose a card to play action: ");
                    cardOpt = input.nextInt();
                    System.out.print("Choose a player to play action:  ");
                    playerOpt = input.nextInt();
                    dm.Play(currPlayer.GetcurrPlayingCards()[cardOpt-1], dm.GetAllPlayer()[playerOpt-1]);
                    dm.Discard(cardOpt-1);
                }

                
                if(currPlayer.GetCurrPlayingCardNum() > 7){
                    System.out.println("========================================");
                    System.out.println("|             DISCARD PHASE            |");
                    System.out.println("========================================");
                    System.out.println("");
                    int discardCount = currPlayer.GetCurrPlayingCardNum() - 7; 
                    for(int i=0; i<discardCount; i++){
                        displayer.ShowCardHand(currPlayer.GetcurrPlayingCards());
                        System.out.print("Pick a card to discard: ");
                        int discardOpt = input.nextInt(); 
                        dm.Discard(discardOpt-1);
                    }
                }
                dm.SwitchPlayer();  
            } 
        }
        System.out.println("The winner of the game is: "+ dm.GetAllPlayer()[0]);
    }
}
