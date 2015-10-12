/**************************************************************************************************
 * Copyright (c) Iurii Sergiichuk <iurii.sergiichuk@gmail.com> 2015. You're free to use this source code, but you should keep this copyright and cannot remove it in any case.
 **************************************************************************************************/

package ua.nure.bit.ciphers;


import javax.annotation.Nonnull;

/**
 * Each cipher should implement this interface and should have encode and decode methods.
 *
 * @author Iurii Sergiichuk
 */
public interface Cipher {
    String decode(@Nonnull String message);

    String encode(@Nonnull String message);
}
