/**************************************************************************************************
 * Copyright (c) Iurii Sergiichuk <iurii.sergiichuk@gmail.com> 2015. You're free to use this source code, but you should keep this copyright and cannot remove it in any case.
 **************************************************************************************************/

package ua.nure.bit.ciphers.additionals

import spock.lang.Specification

class AlphabetSpockTest extends Specification {

    def "test getAlphabet with english language"() {
        given:
        def lang = Language.ENGLISH
        when:
        def result = Alphabet.getAlphabet(lang)
        then:
        result != null
        result.length == 26
    }

    def "test generateSubstitutionAlphabet throws illegal argument"() {
        when:
        Alphabet.generateSubstitutionAlphabet(Language.ENGLISH, null)
        then:
        thrown(IllegalArgumentException)
        when:
        char[] substitutions = ['p', 'a', 's', 's']
        Alphabet.generateSubstitutionAlphabet(Language.ENGLISH, substitutions)
        then:
        thrown(IllegalArgumentException)
    }

    def "test generateSubstitutionAlphabet"() {
        given:
        char[] substitutions = ['q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm']
        when:
        def result = Alphabet.generateSubstitutionAlphabet(Language.ENGLISH, substitutions)
        then:
        result != null
        result.size() == 26
    }

    def "test generateRandomSubstitutionAlphabet"() {
        when:
        def result = Alphabet.generateRandomSubstitutionAlphabet(Language.ENGLISH)
        then:
        result != null
        result.size() == 26
    }
}
