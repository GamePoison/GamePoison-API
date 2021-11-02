package org.gamepoison.utils

/**
 * Converts to an unsigned byte represented in an int.
 */
fun Byte.unsign() = java.lang.Byte.toUnsignedInt(this)

/**
 * Converts to an unsigned short represented in an int.
 */
fun Short.unsign() = java.lang.Short.toUnsignedInt(this)

/**
 * Converts to an unsigned int represented in a long.
 */
fun Int.unsign() = Integer.toUnsignedLong(this)