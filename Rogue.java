public class Rogue extends Card {
    public Rogue(){
    }

    // DEVELOPED BY: BEAUTY
    public Rogue(int specialCount, int attackCount, int defenseCount, int healCount){
        super( specialCount,  attackCount,  defenseCount,  healCount);
    }

    // DEVELOPED BY: BEAUTY
    public void MightyPower(int special,Player p, Player[] players){
        if(special != 0 ){
            super.Attack(GetSpecialCount(), p);
        }
    }
}