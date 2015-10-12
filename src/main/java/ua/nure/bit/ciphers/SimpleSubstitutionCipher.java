/**************************************************************************************************
 * Copyright (c) Iurii Sergiichuk <iurii.sergiichuk@gmail.com> 2015. You're free to use this source code, but you should keep this copyright and cannot remove it in any case.
 **************************************************************************************************/

package ua.nure.bit.ciphers;

import org.apache.commons.collections4.BidiMap;
import ua.nure.bit.ciphers.additionals.Alphabet;
import ua.nure.bit.ciphers.additionals.Language;

import javax.annotation.Nonnull;

/**
 * Implementation of simple substitution cipher
 *
 * @author Iurii Sergiichuk
 */
public class SimpleSubstitutionCipher implements Cipher {
    private Language language;
    private BidiMap<Character, Character> substitutionAlphabet;

    public SimpleSubstitutionCipher(Language language) {
        this.language = language;
        substitutionAlphabet = Alphabet.generateRandomSubstitutionAlphabet(language);
    }

    public SimpleSubstitutionCipher(Language language, BidiMap<Character, Character> substitutionAlphabet) {
        this.language = language;
        this.substitutionAlphabet = substitutionAlphabet;
    }

    @Override
    public String decode(@Nonnull String message) {
        return encodeInternal(message, substitutionAlphabet.inverseBidiMap());
    }

    @Override
    public String encode(@Nonnull String message) {
        return encodeInternal(message, substitutionAlphabet);
    }

    private String encodeInternal(String message, BidiMap<Character, Character> substitutionAlphabet) {
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            Character res = substitutionAlphabet.get(c);
            if (res == null)
                result.append(c);
            else {
                result.append(res);
            }
        }
        return result.toString();
    }
}
