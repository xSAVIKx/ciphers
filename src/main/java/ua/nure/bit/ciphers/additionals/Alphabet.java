/**********************************************************************************************************************
 * Copyright (c) Iurii Sergiichuk <iurii.sergiichuk@gmail.com> 2015. You're free to use this source code, but you should keep this copyright and cannot remove it in any case.
 **********************************************************************************************************************/

package ua.nure.bit.ciphers.additionals;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

/**
 * This class provides number of useful methods
 *
 * @author Iurii Sergiichuk
 */
public final class Alphabet {
    private static final Map<Language, char[]> alphabetMap;
    private static final char ENGLISH_ALPHABET[] = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final char RUSSIAN_ALPHABET[] = new char[]{'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'щ', 'ш', 'ь', 'ы', 'ъ', 'э', 'ю', 'я'};

    static {
        alphabetMap = new EnumMap<>(Language.class);
        alphabetMap.put(Language.ENGLISH, ENGLISH_ALPHABET);
        alphabetMap.put(Language.RUSSIAN, RUSSIAN_ALPHABET);
    }

    /**
     * Get language alphabet as char[]
     *
     * @param language language to look for
     * @return char[] with language alphabets
     */
    public static char[] getAlphabet(Language language) {
        return alphabetMap.get(language);
    }

    /**
     * Generates map of substitution symbols for given language and substitution array
     *
     * @param language      language to generate substitution for
     * @param substitutions array of substitution characters
     * @return bi-directional map with 1:1 alphabets for given language
     */
    public static BidiMap<Character, Character> generateSubstitutionAlphabet(Language language, char[] substitutions) {
        char[] languageAlphabet = getAlphabet(language);
        if (!ArrayUtils.isSameLength(substitutions, languageAlphabet))
            throw new IllegalArgumentException("Substitution array should have same alphabets as given language has");
        BidiMap<Character, Character> substitutionAlphabet = new DualHashBidiMap<>();
        for (int i = 0; i < languageAlphabet.length; i++) {
            char key = languageAlphabet[i];
            char value = substitutions[i];
            substitutionAlphabet.put(key, value);
        }
        return substitutionAlphabet;
    }

    /**
     * Generate map with random substitutions for given language
     *
     * @param language language to generate substitution for
     * @return bi-directional map with random 1:1 alphabets for given language
     */
    public static BidiMap<Character, Character> generateRandomSubstitutionAlphabet(Language language) {
        List<Character> substitutions = Arrays.asList(ArrayUtils.toObject(getAlphabet(language)));
        Collections.shuffle(substitutions);
        return generateSubstitutionAlphabet(language, ArrayUtils.toPrimitive(substitutions.toArray(new Character[substitutions.size()])));
    }
}
