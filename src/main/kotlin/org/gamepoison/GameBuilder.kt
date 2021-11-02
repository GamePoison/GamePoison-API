package org.gamepoison

open class GameBuilder<T : Game>(
	override val platform: Platform,
	override val name: String
) : Game {
	
	inner class FunBuilder {
		var invoke: (T.() -> Unit)? = null
		
		operator fun invoke(invoke: T.() -> Unit) {
			this.invoke = invoke
		}
		
		fun invoke() {
			invoke?.invoke(@Suppress("UNCHECKED_CAST") (this as T))
		}
	}
	
	val start = FunBuilder()
	val stop = FunBuilder()
	val process = FunBuilder()
	
	override fun start() = start.invoke()
	
	override fun stop() = stop.invoke()
	
	override fun process() = process.invoke()
	
}