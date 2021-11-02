package org.gamepoison.native

import net.openhft.chronicle.core.OS

interface WritableSource : Source {
	
	operator fun set(offset: Long = defaultOffset, value: Source, bytes: Long): Boolean
	
	operator fun set(offset: Long = defaultOffset, value: Byte): Boolean {
		OS.memory().writeByte(offset(offset), value)
		return true
	}
	
	operator fun set(offset: Long = defaultOffset, value: Short): Boolean {
		OS.memory().writeShort(offset(offset), value)
		return true
	}
	
	operator fun set(offset: Long = defaultOffset, value: Int): Boolean {
		OS.memory().writeInt(offset(offset), value)
		return true
	}
	
	operator fun set(offset: Long = defaultOffset, value: Long): Boolean {
		OS.memory().writeLong(offset(offset), value)
		return true
	}
	
	operator fun set(offset: Long = defaultOffset, value: Float): Boolean {
		OS.memory().writeFloat(offset(offset), value)
		return true
	}
	
	operator fun set(offset: Long = defaultOffset, value: Double): Boolean {
		OS.memory().writeDouble(offset(offset), value)
		return true
	}
	
	operator fun set(offset: Long = defaultOffset, value: Char) = set(offset, value.code.toShort())
	operator fun set(offset: Long = defaultOffset, value: Boolean) = set(offset, if (value) 1 else 0)
	
	/* these are necessary due to Kotlin compiler bug with inline classes */
	
	fun set(value: Source, bytes: Long) = set(defaultOffset, value, bytes)
	
	fun set(value: Byte) = set(defaultOffset, value)
	fun set(value: Short) = set(defaultOffset, value)
	fun set(value: Int) = set(defaultOffset, value)
	fun set(value: Long) = set(defaultOffset, value)
	fun set(value: Float) = set(defaultOffset, value)
	fun set(value: Double) = set(defaultOffset, value)
	fun set(value: Char) = set(defaultOffset, value)
	fun set(value: Boolean) = set(defaultOffset, value)
	
}