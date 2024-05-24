public class Barbarian extends Card {
    /* Default Constructor */
    public Barbarian(){
    }

    // DEVELOPED BY: BEAUTY
    /* Initialize the count of special, attack, defense and heal 
     * @param specialCount  - number of special cards 
     * @param attackCount   - number of attack cards
     * @param defenseCount  - number of defense cards and shield
     * @param healCount     - number of heal cards
     */
    public Barbarian(int specialCount, int attackCount, int defenseCount, int healCount){
        super( specialCount,  attackCount,  defenseCount,  healCount);
    }

    // DEVELOPED BY: BEAUTY
    /* Lifesteal; heal depending on the number of damage done
     * @param special  - numebr of speical
     * @param p        - player to attack
     * @param players  - all players present
     */
    public void MightyPower(int special,Player p, Player[] players){
        if(special !=0){
            p.SetPlayerHp(p.GetPlayerHp() + super.GetAttackCount());
        }
    }
}