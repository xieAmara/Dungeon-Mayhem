public class Barbarian extends Card {
    public Barbarian(){
    }
    public Barbarian(int specialCount, int attackCount, int defenseCount, int healCount){
        super( specialCount,  attackCount,  defenseCount,  healCount);
    }

    public void MightyPower(int special, Player p){
        p.SetPlayerHp(p.GetPlayerHp + p.GetAttackCount);
    }
}