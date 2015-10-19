package nl.roelvandun.setgame;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class GameTest {

    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void gameHasADeck() throws Exception {
        assertThat(game.getDeck(), notNullValue());
    }

    @Test
    public void start_tableHas12Cards() throws Exception {
        game.start();

        assertThat(game.getTableCards().size(), equalTo(12));
    }

    // start may only be called once

    // deal 3 new cards
    // - 3 new cards are added to the table && deck.length -= 3
    // - when stack is empty
}