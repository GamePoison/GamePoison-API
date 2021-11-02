package org.gamepoison.native

import net.openhft.chronicle.core.OS

@JvmInline
value class Pointer(override val address: Long) : ReadableSource, WritableSource {
	
	override fun source(offset: Long, bytes: Long, into: Source): Boolean {
		TODO("Not yet implemented")
	}
	
	override fun set(offset: Long, value: Source, bytes: Long): Boolean {
		TODO("Not yet implemented")
	}
	
	companion object {
		
		fun allocate(bytes: Long) = Pointer(OS.memory().allocate(bytes))
		
		inline fun allocateAndUse(bytes: Long, use: (Pointer) -> Unit) {
			val pointer = allocate(bytes)
			try {
				use(pointer)
			} finally {
				pointer.release(bytes)
			}
		}
		
	}
	
	fun release(size: Long) = OS.memory().freeMemory(address, size)
	
}