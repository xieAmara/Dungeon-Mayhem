public class Wizard extends Card {
    public Wizard(){
    }

    // DEVELOPED BY: BEAUTY
    /* Initialize the count of special, attack, defense and heal
     * @param specialCount  - number of special cards
     * @param attackCount   - number of attack cards
     * @param defenseCount  - number of defense cards and shield
     * @param healCount     - number of heal cards
     */
    public Wizard(int specialCount, int attackCount, int defenseCount, int healCount){
        super( specialCount,  attackCount,  defenseCount,  healCount);
    }

    // DEVELOPED BY: BEAUTY
    /* attack the count of special to all players present,except themselves
     * @param special  - number of special
     * @param p        - player to attack 
     * @param players  - all players present
     */
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
