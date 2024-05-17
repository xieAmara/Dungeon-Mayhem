public class Paladin extends Card{
    public Paladin(){
    }

    public Paladin(int specialCount, int attackCount, int defenseCount, int healCount){
        super( specialCount,  attackCount,  defenseCount,  healCount);
    }
    
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
