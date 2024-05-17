public class Rogue extends Card {

    public Rogue(){
    }

    public Rogue(int specialCount, int attackCount, int defenseCount, int healCount){
        super( specialCount,  attackCount,  defenseCount,  healCount);
    }

    public void MightyPower(int special,Player p, Player[] players){
        if(special != 0 ){
            if(p.GetPlayerHp()+special>=10){
                p.SetPlayerHp(10);
            }
            else{
                p.SetPlayerHp(p.GetPlayerHp()+special);
            }
            super.Attack(special, p);
        }
    }
}