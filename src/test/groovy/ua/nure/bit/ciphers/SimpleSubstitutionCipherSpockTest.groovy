/**************************************************************************************************
 * Copyright (c) Iurii Sergiichuk <iurii.sergiichuk@gmail.com> 2015. You're free to use this source code, but you should keep this copyright and cannot remove it in any case.
 **************************************************************************************************/

package ua.nure.bit.ciphers

import spock.lang.Specification
import spock.lang.Unroll
import ua.nure.bit.ciphers.additionals.Alphabet
import ua.nure.bit.ciphers.additionals.Language

class SimpleSubstitutionCipherSpockTest extends Specification {
    SimpleSubstitutionCipher cipher

    @Unroll
    def "test encode"() {
        given:
        char[] substitutions = ['q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm']
        cipher = new SimpleSubstitutionCipher(Language.ENGLISH, Alphabet.generateSubstitutionAlphabet(Language.ENGLISH, substitutions));
        when:
        def result = cipher.encode(message)
        then:
        result == expectedResult
        where:
        message  | expectedResult
        "abc"    | "qwe"
        "abc de" | "qwe rt"
    }

    @Unroll
    def "test decode"() {
        given:
        char[] substitutions = ['q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm']
        cipher = new SimpleSubstitutionCipher(Language.ENGLISH, Alphabet.generateSubstitutionAlphabet(Language.ENGLISH, substitutions));
        when:
        def result = cipher.decode(message)
        then:
        result == expectedResult
        where:
        message  | expectedResult
        "qwe"    | "abc"
        "qwe rt" | "abc de"
    }
}
