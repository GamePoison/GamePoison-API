package org.gamepoison.native

interface Source {
	
	val address: Long
	
	fun offset(offset: Long = defaultOffset) = address + offset
	
	val defaultOffset: Long get() = 0
	
}