package org.gamepoison.native

interface ThreadLocalProcess
	: Process,
	ThreadLocalReadableSource<Pointer>,
	ThreadLocalWritableSource<Pointer> {
	
	override val threadLocal: ThreadLocal<Pointer>
		get() = ThreadLocalPointer.threadLocal
	
}