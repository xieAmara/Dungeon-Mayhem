import java.util.Scanner; 
public class DungeonMayhemMain {
     public static void main(String[] args) {
        DungeonMayhem dm; 
        Displayer displayer = new Displayer(); 
        Scanner input = new Scanner(System.in);


        //====HOME PAGE====//
        // DEVELOPED BY: AMARA
        // start by displaying the game header and promoting how many players there will be 
        displayer.GameHeader();
        System.out.print("How many players? (minimum 2, maximum 4): ");
        int player = input.nextInt();
        // make sure the value entered is minimum 2 and maximum 4 
        while(player>4 || player <2){
            System.out.println("ERROR! Please enter a valid amount of player");
            System.out.print("How many players? (minimum 2, maximum 4): ");
            player = input.nextInt();
        }
        // construct a dungeon mayhem (backend) object depending on the number of players 
        dm = new DungeonMayhem(player); 

        // keep track if the decks are chosen. One player cannot possess the same deck of cards 
        boolean[] deckTrack = {false, false, false, false}; 

        // for each player, prompt them to enter their desired deck number 
        for(int i=0; i<player; i++){

            //display the deck choices and make sure the value entered is valid 
            displayer.DisplayDeckChoice(i+1);
            int deckChoice = input.nextInt();

            while(deckChoice<1 || deckChoice>4){
                System.out.println("ERROR! Please enter a valid deck choice");
                displayer.DisplayDeckChoice(i+1);
                deckChoice = input.nextInt();
            }

            // make sure that the deck choice that the user prompted is not taken 
            while(deckTrack[deckChoice - 1]){
                System.out.println("ERROR! This deck is taken, please choose another deck");
                displayer.DisplayDeckChoice(i+1);
                deckChoice = input.nextInt();
            }

            // create the player according to the deck choice chosen and set the current player to him 
            // then create the deck for the current player depending on their deck choice 
            dm.SetCurrPlayer(dm.CreatePlayer(i, deckChoice - 1));
            dm.CreateDeck(deckChoice - 1);

            // set the valid deck choice as chosen 
            deckTrack[deckChoice - 1] = true; 

            // automatically draw 5 cards for the current player 
            for(int j=0; j<5; j++){
                dm.AddCardToHand(dm.Draw());
                dm.GetCurrPlayer().SetCardCount(dm.GetCurrPlayer().GetCardCount() + 1);
            }
        }

        // Finally set Player 1 to be the first to play the game 
        dm.SetCurrPlayer(dm.GetAllPlayer()[0]);
        
        //=====GAME PAGE WHILE LOOP=====//
        // DEVELOPED BY: AMARA
        // Continue the game if there is no winner yet 
        while(!dm.HasGameWinner()){
            // get the current player and place it into a variable 
            Player currPlayer = dm.GetCurrPlayer();

            //=====CHECK PLAYER STATUS=====//
            // DEVELOPED BY: BEAUTY
            if(dm.HasHpGone()){
                System.out.println("========================================");
                System.out.printf("|Player %-24s : Dead|\n",dm.GetCurrPlayerName());
                System.out.println("========================================");
                currPlayer.SetIsDead(true);
            }

            //=====CREATE DECK FOR PLAYER=====//
            // DEVELOPED BY: AMARA
            /* If the player is still alive  */
            if(currPlayer.GetIsDead() == false){
                 /* Show the current player's character and title  */
                displayer.ShowPlayer(currPlayer);

                // if the drawing pile is less than or equal to five, shuffle the discard pile by creating a new deck 
                if(dm.GetCardDeckLength(currPlayer.GetPlayerType()) <= 5){
                    dm.CreateDeck(currPlayer.GetPlayerType());
                }

                //=====DRAW PHASE=====//
                System.out.println("========================================");
                System.out.println("|              DRAW PHASE              |");
                System.out.println("========================================");
                System.out.println("");

                // DEVELOPED BY: AMARA
                // each time the player draws two card for the draw phase 
                // extend the hand to fit one more card, add the drawn card into the hand and increment the cardCount 
                for(int j=0; j<2; j++){
                    dm.ExtendCardDeck();
                    dm.AddCardToHand(dm.Draw());
                    currPlayer.SetCardCount(currPlayer.GetCardCount() + 1);
                }

                // display out the player's Hp and Sheild after the card is drawn 
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
                            // make sure that the player number entered is valid
                            System.out.println("Invalid player option try again");
                        }
                        else if(dm.GetAllPlayer()[playerOpt-1].GetIsDead() == true){
                            // make sure the player choose an alive player to attack on
                            System.out.println("This player is dead choose another player");
                        }
                        else if(dm.GetAllPlayer()[playerOpt-1].GetPlayerType() == currPlayer.GetPlayerType()){
                            // make sure the player is not choosing itself to attack 
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
                if(currPlayer.GetCardCount() > 7){
                    System.out.println("========================================");
                    System.out.println("|             DISCARD PHASE            |");
                    System.out.println("========================================");
                    System.out.println("");
                    int discardCount = currPlayer.GetCardCount() - 7; 
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
            // switch to the next player 
            dm.SwitchPlayer(); 
        }
        // display the details of the winning player 
        displayer.DisplayWinner(dm.GetAllPlayer()[0]);
    input.close();  
    }
    
}
