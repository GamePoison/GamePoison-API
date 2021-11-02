package org.gamepoison.native

interface ThreadLocalModule : Module,
	ThreadLocalReadableSource<Pointer>,
	ThreadLocalWritableSource<Pointer> {
	
	override val threadLocal: ThreadLocal<Pointer>
		get() = ThreadLocalPointer.threadLocal
	
}