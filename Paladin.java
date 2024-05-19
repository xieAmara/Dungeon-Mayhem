public class Paladin extends Card{
    public Paladin(){
    }

    // DEVELOPED BY: BEAUTY
    public Paladin(int specialCount, int attackCount, int defenseCount, int healCount){
        super( specialCount,  attackCount,  defenseCount,  healCount);
    }

    // DEVELOPED BY: BEAUTY
    public void MightyPower(int special,Player p, Player[] players) {
        if(special != 0){
            for(int i=0; i<players.length; i++){
                if(i != Card.PALADIN){
                    players[i].SetPlayerShield(0);;
                }
            }
        }
    }
}
