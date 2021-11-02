package org.gamepoison.native

object ThreadLocalPointer {
	
	val threadLocal: ThreadLocal<Pointer> = ThreadLocal.withInitial { Pointer.allocate(8) }
	
}