package nl.roelvandun.setgame;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class CardTest {

    private Card card;

    @Test
    public void equalsWorks() throws Exception {
        Card identicalCard =  new Card(Card.Color.GREEN, Card.Amount.THREE, Card.Filling.FULL, Card.Form.DIAMONDS);

        assertThat(card, equalTo(identicalCard));
    }

    @Before
    public void setUp() throws Exception {
        card = new Card(Card.Color.GREEN, Card.Amount.THREE, Card.Filling.FULL, Card.Form.DIAMONDS);
    }

    @Test
    public void hashCodeWorks() throws Exception {
        Card identicalCard =  new Card(Card.Color.GREEN, Card.Amount.THREE, Card.Filling.FULL, Card.Form.DIAMONDS);

        assertThat(card.hashCode(), equalTo(identicalCard.hashCode()));
    }

    @Test
    public void toStringWorks() throws Exception {
        Card redNoneOneOvalCard = new Card(Card.Color.RED, Card.Amount.ONE, Card.Filling.NONE, Card.Form.OVAL);
        Card purpleHalfTwoWaveCard = new Card(Card.Color.PURPLE, Card.Amount.TWO, Card.Filling.HALF, Card.Form.WAVE);

        assertThat(redNoneOneOvalCard.toString(), equalTo("red \t [ ] \t O"));
        assertThat(purpleHalfTwoWaveCard.toString(), equalTo("purple \t [\\] \t ~~"));
        assertThat(card.toString(), equalTo("green \t [*] \t <><><>"));
    }
}