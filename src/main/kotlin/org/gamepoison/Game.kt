package org.gamepoison

interface Game {
	
	val name: String
	
	val platform: Platform
	
	fun start()
	
	fun stop() {
	}
	
	fun process()
	
}