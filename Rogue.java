public class Rogue extends Card {
    /* Default Constructor */
    public Rogue(){
    }

    // DEVELOPED BY: BEAUTY
    /* Initialize the the count of special, attack, defense and heal for Rogue
     * @param specialCount  - number of special cards
     * @param attackCount   - number of damage cards
     * @param defenseCount  - number of defense cards and sheild
     * @param healCount     - number of heal cards
     */
    public Rogue(int specialCount, int attackCount, int defenseCount, int healCount){
        super( specialCount,  attackCount,  defenseCount,  healCount);
    }

    // DEVELOPED BY: BEAUTY
    /* Attacks the selected player depending on the special count 
     * @param special  - numnber of special 
     * @param p        - player to attack
     * @param players  - all players present
     */
    public void MightyPower(int special,Player p, Player[] players){
        // apply this power only when the special is not zero 
        if(special != 0 ){
            // attack the player depending on how many specials it has 
            super.Attack(GetSpecialCount(), p);
        }
    }
}