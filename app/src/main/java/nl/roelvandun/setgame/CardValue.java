package nl.roelvandun.setgame;

public class CardValue {

    public static final int AMOUNT_ONE = 0;
    public static final int AMOUNT_TWO = 1;
    public static final int AMOUNT_THREE = 2;

    public static final int COLOR_RED = 0;
    public static final int COLOR_BLUE = 1;
    public static final int COLOR_GREEN = 2;

    public final int amount;
    public final int color;
    public final int filling;
    public final int form;

    //TODO use int constants with annotations
    public CardValue(int amount, int color, int filling, int form) {
        this.amount = amount;
        this.color = color;
        this.filling = filling;
        this.form = form;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardValue cardValue = (CardValue) o;

        if (amount != cardValue.amount) return false;
        if (color != cardValue.color) return false;
        if (filling != cardValue.filling) return false;
        return form == cardValue.form;
    }

    @Override
    public int hashCode() {
        int result = amount;
        result = 31 * result + color;
        result = 31 * result + filling;
        result = 31 * result + form;
        return result;
    }

}
