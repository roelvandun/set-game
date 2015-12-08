package nl.roelvandun.setgame;

import android.content.Context;

import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Stack;

public class Deck {

    private final Stack<Card> cards = new Stack<>();

    public Deck(Context context) {
        int idIndex = 0;
        for (int colorIndex = 0; colorIndex < 3; colorIndex++) {
            for (int amountIndex = 0; amountIndex < 3; amountIndex++) {
                for (int fillingIndex = 0; fillingIndex < 3; fillingIndex++) {
                    for (int formIndex = 0; formIndex < 3; formIndex++) {
                        CardValue cardValue = new CardValue(colorIndex, amountIndex, fillingIndex, formIndex);
                        Card card = new Card(context, idIndex, cardValue);
                        cards.add(card);

                        idIndex++;
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

    public Card draw() throws EmptyStackException {
        return cards.pop();
    }
}
