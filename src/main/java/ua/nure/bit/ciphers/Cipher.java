package ua.nure.bit.ciphers;


/**
 * Created by Iurii Sergiichuk on 12.10.2015.
 */
public interface Cipher {
    public String decode(String message);

    public String encode(String message);
}
