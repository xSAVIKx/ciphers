/**************************************************************************************************
 * Copyright (c) Iurii Sergiichuk <iurii.sergiichuk@gmail.com> 2015. You're free to use this source code, but you should keep this copyright and cannot remove it in any case.
 **************************************************************************************************/

package ua.nure.bit.ciphers

import spock.lang.Specification
import spock.lang.Unroll

class VigenereCipherSpockTest extends Specification {
    VigenereCipher cipher

    @Unroll
    def "test encode with key=%key, message=%message and expectedResult=%expectedResult"() {
        given:
        cipher = new VigenereCipher(key)
        when:
        def result = cipher.encode(message)
        then:
        result == expectedResult
        where:
        key    | message           || expectedResult
        "TEST" | "FIRST"           || "YMJLM"
        "test" | "first"           || "ymjlm"
        "test" | "test, is a test" || "mikm, bw s mxwl"
    }

    @Unroll
    def "test decode with key=%key, message=%message and expectedResult=%expectedResult"() {
        given:
        cipher = new VigenereCipher(key)
        when:
        def result = cipher.decode(message)
        then:
        result == expectedResult
        where:
        key    | message           || expectedResult
        "TEST" | "YMJLM"           || "FIRST"
        "test" | "ymjlm"           || "first"
        "test" | "mikm, bw s mxwl" || "test, is a test"
    }
}
