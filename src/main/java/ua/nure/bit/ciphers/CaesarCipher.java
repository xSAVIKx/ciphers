package ua.nure.bit.ciphers;

import ua.nure.bit.ciphers.additionals.Alphabet;
import ua.nure.bit.ciphers.additionals.Language;

/**
 * Created by Iurii Sergiichuk on 12.10.2015.
 */
public class CaesarCipher implements Cipher {
    private int offset;
    private final Language language;
    private char firstLanguageAlphabet;

    /**
     * Default constructor with offset=3 and language=English
     */
    public CaesarCipher() {
        offset = 3;
        language = Language.ENGLISH;
        setFirstLanguageAlphabet();
    }

    /**
     * Constructor with pre-defined english language
     *
     * @param offset offset to be set for cipher
     */
    public CaesarCipher(int offset) {
        this.offset = offset;
        this.language = Language.ENGLISH;
        setFirstLanguageAlphabet();
    }

    public CaesarCipher(int offset, Language language) {
        this.offset = offset;
        this.language = language;
        setFirstLanguageAlphabet();
    }

    @Override
    public String decode(String message) {
        return encodeInternal(message, language.getAlphabetsAmount() - offset);
    }

    @Override
    public String encode(String message) {
        return encodeInternal(message, offset);
    }

    private String encodeInternal(String message, int offset) {
        int languageAlphabetsAmount = language.getAlphabetsAmount();
        int encodedOffset = offset % languageAlphabetsAmount + languageAlphabetsAmount;
        StringBuilder encoded = new StringBuilder();
        char upperCaseFirstLanguageAlphabet = Character.toUpperCase(firstLanguageAlphabet);
        for (char i : message.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    encoded.append((char) (upperCaseFirstLanguageAlphabet + (i - upperCaseFirstLanguageAlphabet + encodedOffset) % languageAlphabetsAmount));
                } else {
                    encoded.append((char) (firstLanguageAlphabet + (i - firstLanguageAlphabet + encodedOffset) % languageAlphabetsAmount));
                }
            } else {
                encoded.append(i);
            }
        }
        return encoded.toString();
    }

    private void setFirstLanguageAlphabet() {
        firstLanguageAlphabet = Alphabet.getAlphabet(language)[0];
    }

    public int getOffset() {
        return offset;
    }

    public Language getLanguage() {
        return language;
    }
}
