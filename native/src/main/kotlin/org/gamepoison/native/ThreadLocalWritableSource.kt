package org.gamepoison.native

interface ThreadLocalWritableSource<T : WritableSource> : ThreadLocalSource<T>, WritableSource {
	
	/* need to performance test this first to ensure we're not dealing with boxing */
/*	inline fun <reified T> set(offset: Long, value: T, bytes: Long, set: Pointer.(T) -> Unit): Boolean {
		val source = threadLocalPointer.get()
		source.set(value)
		return setSource(offset, source, bytes)
	}*/
	
	override fun set(offset: Long, value: Byte): Boolean {
		val source = threadLocal.get()
		source[0] = value
		return set(offset, source, 1)
	}
	
	override fun set(offset: Long, value: Short): Boolean {
		val source = threadLocal.get()
		source[0] = value
		return set(offset, source, 2)
	}
	
	override fun set(offset: Long, value: Int): Boolean {
		val source = threadLocal.get()
		source[0] = value
		return set(offset, source, 4)
	}
	
	override fun set(offset: Long, value: Long): Boolean {
		val source = threadLocal.get()
		source[0] = value
		return set(offset, source, 8)
	}
	
	override fun set(offset: Long, value: Float): Boolean {
		val source = threadLocal.get()
		source[0] = value
		return set(offset, source, 4)
	}
	
	override fun set(offset: Long, value: Double): Boolean {
		val source = threadLocal.get()
		source[0] = value
		return set(offset, source, 8)
	}
	
}