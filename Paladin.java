public class Paladin extends Card{
    public Paladin(){
    }

    public Paladin(int specialCount, int attackCount, int defenseCount, int healCount){
        super( specialCount,  attackCount,  defenseCount,  healCount);
    }
    
    public void MightyPower(int special, Player p) {
        for (int i = 0; i < p.GetAllPlayer; i++) {
            p.Player(i).setPlayerShield(0);
        }
    }
}
