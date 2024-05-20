public class Barbarian extends Card {
    public Barbarian(){
    }

    // DEVELOPED BY: BEAUTY
    public Barbarian(int specialCount, int attackCount, int defenseCount, int healCount){
        super( specialCount,  attackCount,  defenseCount,  healCount);
    }

    // DEVELOPED BY: BEAUTY
    public void MightyPower(int special,Player p, Player[] players){
        if(special !=0){
            p.SetPlayerHp(p.GetPlayerHp() + super.GetAttackCount());
        }
    }
}