package Cards;

public class Card {
    Suit suit;
    Number number;

    public Card(Suit suit, Number number) {
        this.suit = suit;
        this.number = number;
    }

    @Override
    public String toString() {
        return suit.toString() + " of " + number.toString();
    }
}
