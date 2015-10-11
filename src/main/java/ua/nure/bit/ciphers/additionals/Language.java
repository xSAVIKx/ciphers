package ua.nure.bit.ciphers.additionals;

/**
 * Created by Iurii Sergiichuk on 12.10.2015.
 */
public enum Language {
    ENGLISH(26);
    private int alphabetsAmount;

    Language(int alphabetsAmount) {
        this.alphabetsAmount = alphabetsAmount;
    }

    public int getAlphabetsAmount() {
        return alphabetsAmount;
    }
}
