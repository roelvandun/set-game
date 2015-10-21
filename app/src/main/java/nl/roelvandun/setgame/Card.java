package nl.roelvandun.setgame;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Card {

    public static final String COLOR_RED_SYMBOL = "R";
    public static final String COLOR_GREEN_SYMBOL = "G";
    public static final String COLOR_PURPLE_SYMBOL = "P";
    public static final String FORM_WAVE_CHARACTER = "~";
    public static final String FORM_DIAMOND_CHARACTER = "\u0394";
    public static final String FORM_OVAL_CHARACTER = "O";
    public static final String FILLING_NONE_CHARACTER = "\u206E"; //TODO replace with unicode
    public static final String FILLING_HALF_CHARACTER = "\u25CD"; //TODO replace with unicode
    public static final String FILLING_FULL_CHARACTER = "\u220E"; //TODO replace with unicode

    private final Map<Class<? extends Characteristic>, Characteristic> characteristics;

    public final Amount amount;
    public final Color color;
    public final Filling filling;
    public final Form form;

    public Card(Color color, Amount amount, Filling filling, Form form) {
        this.color = color;
        this.amount = amount;
        this.filling = filling;
        this.form = form;

        characteristics = new HashMap<>(4);
        characteristics.put(Color.class, color);
        characteristics.put(Amount.class, amount);
        characteristics.put(Filling.class, filling);
        characteristics.put(Form.class, form);
    }

    /**
     * Marker interface
     */
    public interface Characteristic {

    }

    enum Amount implements Characteristic {
        ONE, TWO, THREE;

    }

    enum Color implements Characteristic {
        RED(COLOR_RED_SYMBOL), GREEN(COLOR_GREEN_SYMBOL), PURPLE(COLOR_PURPLE_SYMBOL);

        public final String character;

        Color(String character) {
            this.character = character;
        }
    }

    enum Filling implements Characteristic {
        NONE(FILLING_NONE_CHARACTER), HALF(FILLING_HALF_CHARACTER), FULL(FILLING_FULL_CHARACTER);

        public final String character;

        Filling(String character) {
            this.character = character;
        }
    }

    enum Form implements Characteristic {
        DIAMOND(FORM_DIAMOND_CHARACTER), WAVE(FORM_WAVE_CHARACTER), OVAL(FORM_OVAL_CHARACTER);

        public final String character;

        Form(String character) {
            this.character = character;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (amount != card.amount) return false;
        if (color != card.color) return false;
        if (filling != card.filling) return false;
        return form == card.form;

    }

    @Override
    public int hashCode() {
        int result = amount.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + filling.hashCode();
        result = 31 * result + form.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.color.character);

        switch (this.filling) {
            case NONE:
                sb.append(FILLING_NONE_CHARACTER);
                break;
            case HALF:
                sb.append(FILLING_HALF_CHARACTER);
                break;
            case FULL:
                sb.append(FILLING_FULL_CHARACTER);
                break;
        }

        switch (this.amount) {
            case ONE:
                sb.append(this.form.character);
                break;
            case TWO:
                sb.append(this.form.character);
                sb.append(this.form.character);
                break;
            case THREE:
                sb.append(this.form.character);
                sb.append(this.form.character);
                sb.append(this.form.character);
                break;
        }
        return sb.toString();
    }

    public Map<Class<? extends Characteristic>, Characteristic> getCharacteristics() {
        return Collections.unmodifiableMap(characteristics);
    }

}
