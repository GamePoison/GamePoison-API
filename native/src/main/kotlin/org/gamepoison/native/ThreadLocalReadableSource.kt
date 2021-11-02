package org.gamepoison.native

interface ThreadLocalReadableSource<T : ReadableSource> : ThreadLocalSource<T>, ReadableSource {
	
	/* need to performance test this first to ensure we're not dealing with boxing */
/*	inline fun <reified T> get(offset: Long, bytes: Long, defaultValue: T, get: Pointer.() -> T): T {
		val source = threadLocalsource.get()
		return if (getSource(offset, bytes, source))
			source.get()
		else defaultValue
	}*/
	
	override fun byte(offset: Long): Byte {
		val source = threadLocal.get()
		return if (source(offset, 1, source))
			source.byte(0)
		else 0
	}
	
	override fun short(offset: Long): Short {
		val source = threadLocal.get()
		return if (source(offset, 2, source))
			source.short(0)
		else 0
	}
	
	override fun int(offset: Long): Int {
		val source = threadLocal.get()
		return if (source(offset, 4, source))
			source.int(0)
		else 0
	}
	
	override fun long(offset: Long): Long {
		val source = threadLocal.get()
		return if (source(offset, 8, source))
			source.long(0)
		else 0
	}
	
	override fun float(offset: Long): Float {
		val source = threadLocal.get()
		return if (source(offset, 4, source))
			source.float(0)
		else 0F
	}
	
	override fun double(offset: Long): Double {
		val source = threadLocal.get()
		return if (source(offset, 8, source))
			source.double(0)
		else 0.0
	}
	
}