package nl.roelvandun.setgame;

import android.content.Context;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {

    private final Deck deck;
    private List<Card> tableCards = new ArrayList<>(81);

    public Game(Context context) {
        this.deck = new Deck(context);
    }

    /**
     * Starts the game by:
     * <ol>
     *     <li>shuffling the deck</li>
     *     <li>putting 12 cards on the table</li>
     * </ol>
     */
    public void start() {
        deck.shuffle();

        draw3Cards();
        draw3Cards();
        draw3Cards();
        draw3Cards();
    }

    public Deck getDeck() {
        return deck;
    }

    public List<Card> getTableCards() {
        return tableCards;
    }

    public void draw3Cards() throws EmptyStackException {
        getTableCards().add(getDeck().draw());
        getTableCards().add(getDeck().draw());
        getTableCards().add(getDeck().draw());
    }

    public boolean allSameAmount(Card cardOne, Card cardTwo, Card cardThree) {
        return cardOne.getCardValue().amount == cardTwo.getCardValue().amount
                && cardOne.getCardValue().amount == cardThree.getCardValue().amount;
    }

//    public boolean allSameColor(Card cardOne, Card cardTwo, Card cardThree) {
//        return cardOne.color.equals(cardTwo.color) && cardOne.color.equals(cardThree.color);
//    }

}
