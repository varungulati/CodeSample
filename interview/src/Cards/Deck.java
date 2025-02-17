package Cards;

/*Design a deck of cards
Constraints and assumptions
Is this a generic deck of cards for games like poker and black jack?
Yes, design a generic deck then extend it to black jack
Can we assume the deck has 52 cards (2-10, Jack, Queen, King, Ace) and 4 suits?
Yes
Can we assume inputs are valid or do we have to validate them?
Assume they're valid*/

public class Deck {

    Card[] deck = new Card[52];

    public Deck() {
        deck[0] = new Card(Suit.SPADE, Number.ACE);
        deck[1] = new Card(Suit.SPADE, Number.TWO);
        deck[2] = new Card(Suit.SPADE, Number.THREE);
        deck[3] = new Card(Suit.SPADE, Number.FOUR);
        deck[4] = new Card(Suit.SPADE, Number.FIVE);
        deck[5] = new Card(Suit.SPADE, Number.SIX);
        deck[6] = new Card(Suit.SPADE, Number.SEVEN);
        deck[7] = new Card(Suit.SPADE, Number.EIGHT);
        deck[8] = new Card(Suit.SPADE, Number.NINE);
        deck[9] = new Card(Suit.SPADE, Number.TEN);
        deck[10] = new Card(Suit.SPADE, Number.JACK);
        deck[11] = new Card(Suit.SPADE, Number.QUEEN);
        deck[12] = new Card(Suit.SPADE, Number.KING);
        deck[13] = new Card(Suit.HEART, Number.ACE);
        deck[14] = new Card(Suit.HEART, Number.TWO);
        deck[15] = new Card(Suit.HEART, Number.THREE);
        deck[16] = new Card(Suit.HEART, Number.FOUR);
        deck[17] = new Card(Suit.HEART, Number.FIVE);
        deck[18] = new Card(Suit.HEART, Number.SIX);
        deck[19] = new Card(Suit.HEART, Number.SEVEN);
        deck[20] = new Card(Suit.HEART, Number.EIGHT);
        deck[21] = new Card(Suit.HEART, Number.NINE);
        deck[22] = new Card(Suit.HEART, Number.TEN);
        deck[23] = new Card(Suit.HEART, Number.JACK);
        deck[24] = new Card(Suit.HEART, Number.QUEEN);
        deck[25] = new Card(Suit.HEART, Number.KING);
        deck[26] = new Card(Suit.DIAMOND, Number.ACE);
        deck[27] = new Card(Suit.DIAMOND, Number.TWO);
        deck[28] = new Card(Suit.DIAMOND, Number.THREE);
        deck[29] = new Card(Suit.DIAMOND, Number.FOUR);
        deck[30] = new Card(Suit.DIAMOND, Number.FIVE);
        deck[31] = new Card(Suit.DIAMOND, Number.SIX);
        deck[32] = new Card(Suit.DIAMOND, Number.SEVEN);
        deck[33] = new Card(Suit.DIAMOND, Number.EIGHT);
        deck[34] = new Card(Suit.DIAMOND, Number.NINE);
        deck[35] = new Card(Suit.DIAMOND, Number.TEN);
        deck[36] = new Card(Suit.DIAMOND, Number.JACK);
        deck[37] = new Card(Suit.DIAMOND, Number.QUEEN);
        deck[38] = new Card(Suit.DIAMOND, Number.KING);
        deck[39] = new Card(Suit.CLUB, Number.ACE);
        deck[40] = new Card(Suit.CLUB, Number.TWO);
        deck[41] = new Card(Suit.CLUB, Number.THREE);
        deck[42] = new Card(Suit.CLUB, Number.FOUR);
        deck[43] = new Card(Suit.CLUB, Number.FIVE);
        deck[44] = new Card(Suit.CLUB, Number.SIX);
        deck[45] = new Card(Suit.CLUB, Number.SEVEN);
        deck[46] = new Card(Suit.CLUB, Number.EIGHT);
        deck[47] = new Card(Suit.CLUB, Number.NINE);
        deck[48] = new Card(Suit.CLUB, Number.TEN);
        deck[49] = new Card(Suit.CLUB, Number.JACK);
        deck[50] = new Card(Suit.CLUB, Number.QUEEN);
        deck[51] = new Card(Suit.CLUB, Number.KING);
    }

    public boolean validateDeck() {
        return false;
    }

    public boolean shuffleDeck() {
        return false;
    }

    public Card getRandomCard() {
        return deck[(int) (Math.random() * deck.length)];
    }

    public static void main(String[] args) {
        Deck cards = new Deck();
        System.out.println(cards);
    }
}
