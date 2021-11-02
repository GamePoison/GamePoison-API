package org.gamepoison

interface Platform {
	
	fun <T : Game> game(name: String, build: GameBuilder<T>.() -> Unit) =
		GameBuilder<T>(this, name).apply(build)
	
}