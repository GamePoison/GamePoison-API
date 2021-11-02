package org.gamepoison.native

import net.openhft.chronicle.core.OS
import org.gamepoison.utils.unsign

interface ReadableSource : Source {
	
	fun source(offset: Long = defaultOffset, bytes: Long, into: Source): Boolean
	
	fun byte(offset: Long = defaultOffset): Byte = OS.memory().readByte(offset(offset))
	fun short(offset: Long = defaultOffset): Short = OS.memory().readShort(offset(offset))
	fun int(offset: Long = defaultOffset): Int = OS.memory().readInt(offset(offset))
	fun long(offset: Long = defaultOffset): Long = OS.memory().readLong(offset(offset))
	fun float(offset: Long = defaultOffset): Float = OS.memory().readFloat(offset(offset))
	fun double(offset: Long = defaultOffset): Double = OS.memory().readDouble(offset(offset))
	fun char(offset: Long = defaultOffset) = short(offset).toInt().toChar()
	fun boolean(offset: Long = defaultOffset) = byte(offset).toInt() != 0
	
	fun ubyte(offset: Long = defaultOffset) = byte(offset).unsign()
	fun ushort(offset: Long = defaultOffset) = short(offset).unsign()
	fun uint(offset: Long = defaultOffset) = int(offset).unsign()
	
	/* these are necessary due to Kotlin compiler bug with inline classes */
	
	fun source(bytes: Long, into: Source) = source(defaultOffset, bytes, into)
	
	fun byte() = byte(defaultOffset)
	fun short() = short(defaultOffset)
	fun int() = int(defaultOffset)
	fun long() = long(defaultOffset)
	fun float() = float(defaultOffset)
	fun double() = double(defaultOffset)
	fun char() = char(defaultOffset)
	fun boolean() = boolean(defaultOffset)
	
	fun ubyte() = ubyte(defaultOffset)
	fun ushort() = ushort(defaultOffset)
	fun uint() = uint(defaultOffset)
	
}