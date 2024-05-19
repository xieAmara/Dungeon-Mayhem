import java.util.Scanner; 
public class DungeonMayhemMain {
     public static void main(String[] args) {
        DungeonMayhem dm; 
        Displayer displayer = new Displayer(); 
        Scanner input = new Scanner(System.in);


        //====HOME PAGE====//
        // DEVELOPED BY: AMARA
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
        
        //=====GAME PAGE WHILE LOOP=====//
        // DEVELOPED BY: AMARA
        while(!dm.HasGameWinner()){
            Player currPlayer = dm.GetCurrPlayer();

            //=====CHECK PLAYER STATUS=====//
            // DEVELOPED BY: BEAUTY
            if(dm.HasHpGone()){
                System.out.println("========================================");
                System.out.printf("|Player %-24s : Dead|\n",dm.GetCurrPlayerName());
                System.out.println("========================================");
                currPlayer.SetIsDead(true);
            }


            if(currPlayer.GetIsDead() == false){

                //=====CREATE DECK FOR PLAYER=====//
                // DEVELOPED BY: AMARA
                displayer.ShowPlayer(currPlayer);
                if(dm.GetCardDeckLength(currPlayer.GetPlayerType()) <= 5){
                    dm.CreateDeck(currPlayer.GetPlayerType());
                }

                //=====DRAW PHASE=====//
                System.out.println("========================================");
                System.out.println("|              DRAW PHASE              |");
                System.out.println("========================================");
                System.out.println("");

                // DEVELOPED BY: AMARA
                for(int j=0; j<2; j++){
                    dm.ExtendCardDeck();
                    dm.AddCardToHand(dm.Draw());
                    currPlayer.SetCardCount(currPlayer.GetCardCount() + 1);
                }
                displayer.DisplayPlayerDetails(currPlayer.GetPlayerHp(), currPlayer.GetPlayerShield());
                System.out.println("");
                System.out.println("");


                //=====ACTION PHASE=====//
                // DEVELOPED BY: BEAUTY 
                System.out.println("========================================");
                System.out.println("|             ACTION PHASE             |");
                System.out.println("========================================");
                int cardOpt, playerOpt; 
                System.out.print("How many action will you play (minimum 1 maximum 2): ");
                int actionOpt = input.nextInt();
                while(actionOpt <1 || actionOpt>2){
                    System.out.println("ERROR! Invalid Option");
                    System.out.print("How many action will you play (minimum 1 maximum 2): ");
                    actionOpt = input.nextInt();
                }

                for(int i=0; i<actionOpt; i++){
                    displayer.ShowCardHand(currPlayer.GetCurrPlayingCards());
                    while(true){
                        System.out.print("Choose a card to play action: ");
                        cardOpt = input.nextInt();
                        if(cardOpt<1 || cardOpt > currPlayer.GetCardCount()){
                            System.out.println("ERROR! Invalid card option.");
                        }
                        else{
                            break;
                        }
                    }

                    //=====CHECK PLAYER VALIDITY=====//
                    // DEVLOPED BY: AMARA
                    while(true){
                        System.out.println("Choose a player to play action:  ");
                        displayer.ShowPlayers(dm.GetAllPlayer());
                        System.out.print("Option: ");
                        playerOpt = input.nextInt();
                        if(playerOpt < 1 || playerOpt > dm.NumPlayers()){
                            System.out.println("Invalid player option try again");
                        }
                        else if(dm.GetAllPlayer()[playerOpt-1].GetIsDead() == true){
                            System.out.println("This player is dead choose another player");
                        }
                        else if(dm.GetAllPlayer()[playerOpt-1].GetPlayerType() == currPlayer.GetPlayerType()){
                            System.out.println("You cannot place an action on yourself, please pick another player");
                        }
                        else{
                            break;
                        }
                    }

                    //DEVELOPED BY: BEAUTY
                    dm.Play(currPlayer.GetCurrPlayingCards()[cardOpt-1], dm.GetAllPlayer()[playerOpt-1], dm.GetAllPlayer());
                    dm.Discard(cardOpt-1);
                }

                
                //=====DISCARD PHASE=====//
                // DEVELOPED BY: BEAUTY
                if(currPlayer.GetCurrPlayingCardNum() > 7){
                    System.out.println("========================================");
                    System.out.println("|             DISCARD PHASE            |");
                    System.out.println("========================================");
                    System.out.println("");
                    int discardCount = currPlayer.GetCurrPlayingCardNum() - 7; 
                    int discardOpt = 0;
                    for(int i=0; i<discardCount; i++){
                        displayer.ShowCardHand(currPlayer.GetCurrPlayingCards());
                        
                        //=====CHECK CARD VALITY=====//
                        // DEVELOPED BY: BEAUTY
                        while(true){
                            System.out.print("Pick a card to discard: ");
                            discardOpt = input.nextInt(); 
                            if(discardOpt<1 || discardOpt>currPlayer.GetCardCount()){
                                System.out.println("ERROR! Invalid card option.");
                            }
                            else{
                                break;
                            }
                        }
                        dm.Discard(discardOpt-1);
                    }
                } 
            } 
            //=====SWITCH PLAYER AND DISPLAY WINNER=====// 
            // DEVELOPED BY: AMARA
            dm.SwitchPlayer(); 
        }
        displayer.DisplayWinner(dm.GetAllPlayer()[0]);
    input.close();  
    }
    
}
