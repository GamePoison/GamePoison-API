package org.gamepoison.native

interface ThreadLocalSource<T : Source> {
	
	val threadLocal: ThreadLocal<T>
	
}