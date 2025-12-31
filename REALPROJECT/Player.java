package TerecsPlayground.REALPROJECT;
//avoids duplication and errors
public class Player {
    protected String name;
    protected int money;
    protected int[] hand = new int[10]; 
    protected int handTotal;

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
        resetHand();
        //name money resets hand
    }

    public void resetHand() {
        handTotal = 0;
        for (int i = 0; i < hand.length; i++) {
            hand[i] = 0;
            //clears cards from the hand
        }
        //resets hand total to 0
    }

    public void addCard(int cardValue) {
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] == 0) {
                hand[i] = cardValue;
                break;
                //places the card in the first empty slot
            }
        }
        handTotal += cardValue;
        //updates the total value of the hand
    }
}