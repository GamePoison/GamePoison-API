package org.gamepoison

import kotlin.script.experimental.annotations.KotlinScript

@KotlinScript(
	"GamePoison Script",
	fileExtension = "gamepoison.kts",
	compilationConfiguration = ScriptCompilation::class
)
abstract class Script {
	
	operator fun Platform.invoke(build: PlatformContext.() -> Unit) =
		PlatformContext(this).apply(build)
	
	fun <T : Game> PlatformContext.game(name: String, build: GameBuilder<T>.() -> Unit) =
		GameBuilder<T>(platform, name).apply(build)
	
}