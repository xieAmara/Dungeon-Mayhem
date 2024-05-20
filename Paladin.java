public class Paladin extends Card{
    public Paladin(){
    }

    // DEVELOPED BY: BEAUTY
    /* Initialize the count of special, attack, defense and heal for Paladin
     * @param specialCount  - number of special cards
     * @param attackCount   - number of attack cards
     * @param defenseCount  - number of defense cards and shield
     * @param healCount     - number of heal cards
     */
    public Paladin(int specialCount, int attackCount, int defenseCount, int healCount){
        super( specialCount,  attackCount,  defenseCount,  healCount);
    }

    // DEVELOPED BY: BEAUTY
    /* destorys the sheild of every character, including themselves 
     * @param special  - number of special
     * @param p        - player to attack
     * @param players  - all players present
     */
    public void MightyPower(int special,Player p, Player[] players) {
        if(special != 0){
            for(int i=0; i<players.length; i++){
                if(i != Card.PALADIN){
                    players[i].SetPlayerShield(0);
                }
            }
        }
    }
}
