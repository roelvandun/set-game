package nl.roelvandun.setgame;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;

public class DeckTest {

    public static final int FULL_STACK_SIZE = 3 * 3 * 3 * 3;
    private List<Card> cards;
    private Deck deck;

    @Before
    public void setUp() throws Exception {
        deck = new Deck();
        cards = deck.getCards();
    }

    @Test
    public void constructor_creates81cards() {
        assertThat(cards.size(), equalTo(FULL_STACK_SIZE));
    }

    @Test
    public void randomlyChosenCardExistsInDeck() {
        Card card = new Card(Card.Color.GREEN, Card.Amount.THREE, Card.Filling.FULL, Card.Form.DIAMONDS);

        assertThat(cards, hasItem(card));
    }

    @Test
    public void draw_reducesDeckSizeBy1() throws Exception {
        Card topCard = deck.getCards().peek();

        Card drawnCard = deck.draw();

        int deckSize = deck.getCards().size();

        assertThat(deckSize, equalTo(FULL_STACK_SIZE - 1));
        assertThat(cards, not(hasItem(topCard)));
        assertThat(drawnCard, equalTo(topCard));
    }

}