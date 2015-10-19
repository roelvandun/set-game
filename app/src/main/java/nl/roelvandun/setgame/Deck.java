package nl.roelvandun.setgame;

import java.util.Collections;
import java.util.Stack;

public class Deck {

    private final Stack<Card> cards = new Stack<>();

    public Deck() {
        for (int i = 0; i < Card.Color.values().length; i++) {
            for (int j = 0; j < Card.Amount.values().length; j++) {
                for (int k = 0; k < Card.Filling.values().length; k++) {
                    for (int l = 0; l < Card.Form.values().length; l++) {

                        Card.Color color = Card.Color.values()[i];
                        Card.Amount amount = Card.Amount.values()[j];
                        Card.Filling filling = Card.Filling.values()[k];
                        Card.Form form = Card.Form.values()[l];

                        Card card = new Card(color, amount, filling, form);
                        cards.add(card);
                    }
                }
            }
        }
    }

    public Stack<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.pop();
    }
}
