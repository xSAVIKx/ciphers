/**************************************************************************************************
 * Copyright (c) Iurii Sergiichuk <iurii.sergiichuk@gmail.com> 2015. You're free to use this source code, but you should keep this copyright and cannot remove it in any case.
 **************************************************************************************************/

package ua.nure.bit.ciphers;

import ua.nure.bit.ciphers.additionals.Alphabet;
import ua.nure.bit.ciphers.additionals.Language;

import javax.annotation.Nonnull;

/**
 * Implementation of Vigenere cipher
 *
 * @author Iurii Sergiichuk
 */
public class VigenereCipher implements Cipher {
    private final String key;
    private final Language language;
    private final char firstLanguageAlphabet;
    private final int offset;

    public VigenereCipher(String key) {
        this.key = key;
        this.offset = 2;
        this.language = Language.ENGLISH;
        this.firstLanguageAlphabet = Alphabet.getAlphabet(language)[0];
    }

    @Override
    public String decode(@Nonnull String message) {
        return encodeInternal(message, key, false);
    }

    @Override
    public String encode(@Nonnull String message) {
        return encodeInternal(message, key, true);
    }

    private String encodeInternal(String message, String key, boolean encrypt) {
        StringBuilder result = new StringBuilder();
        int languageAlphabetsAmount = language.getAlphabetsAmount();
        char upperCaseFirstLanguageAlphabet = Character.toUpperCase(firstLanguageAlphabet);
        int j = 0;
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    if (encrypt)
                        result.append((char) ((c + key.charAt(j) - offset * upperCaseFirstLanguageAlphabet) % languageAlphabetsAmount + upperCaseFirstLanguageAlphabet));
                    else
                        result.append((char) ((c - key.charAt(j) + languageAlphabetsAmount) % languageAlphabetsAmount + upperCaseFirstLanguageAlphabet));
                } else {
                    if (encrypt)
                        result.append((char) ((c + key.charAt(j) - offset * firstLanguageAlphabet) % languageAlphabetsAmount + firstLanguageAlphabet));
                    else
                        result.append((char) ((c - key.charAt(j) + languageAlphabetsAmount) % languageAlphabetsAmount + firstLanguageAlphabet));
                }
                j = ++j % key.length();
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public String getKey() {
        return key;
    }
}
