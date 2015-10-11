package ua.nure.bit.ciphers.additionals;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created by Iurii Sergiichuk on 12.10.2015.
 */
public class Alphabet {
    private final static Map<Language, char[]> alphabetMap;
    private final static char ENGLISH_ALPHABET[] = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    static {
        alphabetMap = new EnumMap<>(Language.class);
        alphabetMap.put(Language.ENGLISH, ENGLISH_ALPHABET);
    }

    public static char[] getAlphabet(Language language) {
        return alphabetMap.get(language);
    }
}
