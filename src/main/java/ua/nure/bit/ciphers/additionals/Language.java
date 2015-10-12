/**********************************************************************************************************************
 * Copyright (c) Iurii Sergiichuk <iurii.sergiichuk@gmail.com> 2015. You're free to use this source code, but you should keep this copyright and cannot remove it in any case.
 **********************************************************************************************************************/

package ua.nure.bit.ciphers.additionals;

public enum Language {
    ENGLISH(26),
    RUSSIAN(33);
    private int alphabetsAmount;

    Language(int alphabetsAmount) {
        this.alphabetsAmount = alphabetsAmount;
    }

    public int getAlphabetsAmount() {
        return alphabetsAmount;
    }
}
