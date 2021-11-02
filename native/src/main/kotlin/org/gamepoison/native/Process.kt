package org.gamepoison.native

interface Process : ReadableSource, WritableSource {
	
	override val address get() = 0L
	
	val modules: Modules
	
}