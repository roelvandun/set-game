package nl.roelvandun.setgame;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class CardTest {

    private Card card;

    @Test
    public void equalsWorks() throws Exception {
        Card identicalCard =  new Card(Card.Color.GREEN, Card.Amount.THREE, Card.Filling.FULL, Card.Form.DIAMOND);

        assertThat(card, equalTo(identicalCard));
    }

    @Before
    public void setUp() throws Exception {
        card = new Card(Card.Color.GREEN, Card.Amount.THREE, Card.Filling.FULL, Card.Form.DIAMOND);
    }

    @Test
    public void hashCodeWorks() throws Exception {
        Card identicalCard =  new Card(Card.Color.GREEN, Card.Amount.THREE, Card.Filling.FULL, Card.Form.DIAMOND);

        assertThat(card.hashCode(), equalTo(identicalCard.hashCode()));
    }

    @Test
    public void toString_colorPurple() throws Exception {
        Card purpleCard = new Card(Card.Color.PURPLE, Card.Amount.ONE, Card.Filling.NONE, Card.Form.OVAL);

        assertThat(purpleCard.toString(), containsString(Card.COLOR_PURPLE_SYMBOL));
    }

    @Test
    public void toString_colorGreen() throws Exception {
        Card purpleCard = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.NONE, Card.Form.OVAL);

        assertThat(purpleCard.toString(), containsString(Card.COLOR_GREEN_SYMBOL));
    }

    @Test
    public void toString_colorRed() throws Exception {
        Card purpleCard = new Card(Card.Color.RED, Card.Amount.ONE, Card.Filling.NONE, Card.Form.OVAL);

        assertThat(purpleCard.toString(), containsString(Card.COLOR_RED_SYMBOL));
    }

    @Test
    public void toString_fillingNone() throws Exception {
        Card noFillingCard = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.NONE, Card.Form.OVAL);

        assertThat(noFillingCard.toString(), containsString(Card.FILLING_NONE_CHARACTER));
    }

    @Test
    public void toString_fillingHalf() throws Exception {
        Card halfFillingCard = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.HALF, Card.Form.OVAL);

        assertThat(halfFillingCard.toString(), containsString(Card.FILLING_HALF_CHARACTER));
    }

    @Test
    public void toString_fillingFull() throws Exception {
        Card fullFillingCard = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.FULL, Card.Form.OVAL);

        assertThat(fullFillingCard.toString(), containsString(Card.FILLING_FULL_CHARACTER));
    }

    @Test
    public void toString_oneDiamond() throws Exception {
        Card oneDiamondCard = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.FULL, Card.Form.DIAMOND);

        assertThat(oneDiamondCard.toString(), endsWith(Card.FORM_DIAMOND_CHARACTER));
    }

    @Test
    public void toString_twoWaves() throws Exception {
        Card twoWavesCard = new Card(Card.Color.GREEN, Card.Amount.TWO, Card.Filling.FULL, Card.Form.WAVE);

        assertThat(twoWavesCard.toString(), endsWith(Card.FORM_WAVE_CHARACTER + Card.FORM_WAVE_CHARACTER));
    }

    @Test
    public void toString_threeOvals() throws Exception {
        Card threeOvalsCard = new Card(Card.Color.GREEN, Card.Amount.THREE, Card.Filling.FULL, Card.Form.OVAL);

        assertThat(threeOvalsCard.toString(), endsWith(Card.FORM_OVAL_CHARACTER + Card.FORM_OVAL_CHARACTER + Card.FORM_OVAL_CHARACTER));
    }

    @Test
    public void toString_amountOne_length3() throws Exception {
        Card amountOne = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.NONE, Card.Form.OVAL);

        assertThat(amountOne.toString().length(), equalTo(3));
    }

    @Test
    public void toString_amountTwo_length4() throws Exception {
        Card amountOne = new Card(Card.Color.GREEN, Card.Amount.TWO, Card.Filling.NONE, Card.Form.OVAL);

        assertThat(amountOne.toString().length(), equalTo(4));
    }

    @Test
    public void toString_amountThree_length5() throws Exception {
        Card amountOne = new Card(Card.Color.GREEN, Card.Amount.THREE, Card.Filling.NONE, Card.Form.OVAL);

        assertThat(amountOne.toString().length(), equalTo(5));
    }

}