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
    public void game_constructed_hasADeck() throws Exception {
        assertThat(game.getDeck(), notNullValue());
    }

    @Test
    public void drawCards_atLeast3InStack_adds3cardsToTable() throws Exception {
        int initialTableCardsCount = game.getTableCards().size();

        game.draw3Cards();

        int afterDrawingTableCardsCount = game.getTableCards().size();

        assertThat(afterDrawingTableCardsCount, equalTo(initialTableCardsCount + 3));
    }

    @Test(expected = Exception.class)
    public void drawCards_emptyStack_throwsException() throws Exception {

    }

    @Test
    public void start_tableHas12Cards() throws Exception {
        game.start();

        assertThat(game.getTableCards().size(), equalTo(12));
    }

}