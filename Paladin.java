public class Paladin extends Card{
    /* Default Constructor */
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
    /* Destorys the sheild of every character, including themselves 
     * @param special  - number of special
     * @param p        - player to attack
     * @param players  - all players present
     */
    public void MightyPower(int special,Player p, Player[] players) {
        // only apply this when the special count is not zero 
        if(special != 0){
            for(int i=0; i<players.length; i++){
                    // set everyone's shield to zero 
                    players[i].SetPlayerShield(0);
            }
        }
    }
}