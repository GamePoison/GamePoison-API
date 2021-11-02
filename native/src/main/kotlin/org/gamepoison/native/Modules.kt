package org.gamepoison.native

interface Modules {
	
	val process: Process
	
	fun load(): Modules
	
	val loaded: Int
	
	operator fun get(moduleName: String): Module?
	
}