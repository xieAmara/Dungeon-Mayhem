public class Wizard extends Card {
    public Wizard(int specialCount, int attackCount, int defenseCount, int healCount){
        super( specialCount,  attackCount,  defenseCount,  healCount);
    }

    public void MightyPower(int special, Player p){
        for (int i = 0; i < p.GetAllPlayer; i++) {
            Player target = p.Player(i);
            if (target != p) {
                p.Player(i).SetPlayerHp(p.GetPlayerHp()-3);
            }
        }
    }
}
