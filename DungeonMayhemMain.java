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
            dm.CreatePlayer(i, deckChoice - 1);
            dm.SetCurrPlayer(dm.GetAllPlayer()[i]);
            dm.CreateDeck(deckChoice - 1);
            deckTrack[deckChoice - 1] = true; 
        }
        while(!dm.HasGameWinner()){
            displayer.ShowHP(7);
            for(int i=0; i<5; i++){
                displayer.ShowCard(dm.Draw());
            }
            break;

        }
    }


}
