package ua.nure.bit.ciphers

import spock.lang.Specification
import spock.lang.Unroll;

public class CaesarCipherSpockTest extends Specification {
    CaesarCipher cipher

    @Unroll
    def "test encode with offset=#offset, message=#message and expectedResult=#expectedResult"() {
        given:
        cipher = new CaesarCipher(offset)
        when:
        def result = cipher.encode(message)
        then:
        result == expectedResult
        where:
        offset | message || expectedResult
        1      | "a"     || "b"
        28     | "a"     || "c"
        3      | "a"     || "d"
        4      | "HellO1"|| "LippS1"
        -1     | "a"     || "z"
    }

    @Unroll
    def "test decode with offset=#offset, message=#message and expectedResult=#expectedResult"() {
        given:
        cipher = new CaesarCipher(offset)
        when:
        def result = cipher.decode(message)
        then:
        result == expectedResult
        where:
        offset | message || expectedResult
        1      | "b"     || "a"
        28     | "c"     || "a"
        3      | "d"     || "a"
        4      | "LippS1"||"HellO1"
        -1     | "z"     || "a"
    }
}