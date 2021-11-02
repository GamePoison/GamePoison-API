package org.gamepoison.native

interface Module : ReadableSource, WritableSource {
	
	val process: Process
	
	val name: String
	
	val size: Long
	
}