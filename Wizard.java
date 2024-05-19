public class Wizard extends Card {
    public Wizard(){
    }

    // DEVELOPED BY: BEAUTY
    public Wizard(int specialCount, int attackCount, int defenseCount, int healCount){
        super( specialCount,  attackCount,  defenseCount,  healCount);
    }

    // DEVELOPED BY: BEAUTY
    public void MightyPower(int special,Player p, Player[] players){
        if(special != 0){
            for(int i=0; i<players.length; i++){
                if(i != Card.WIZARD){
                    players[i].SetPlayerHp(players[i].GetPlayerHp()-3);
                }
            }
        }
    }
}
