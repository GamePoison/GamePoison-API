package org.gamepoison

import kotlin.concurrent.thread
import kotlin.reflect.KClass
import kotlin.system.measureTimeMillis

data class EveryContext(var loopTime: Long)

inline fun every(millis: Long, crossinline block: (EveryContext) -> Unit, crossinline precheck: (EveryContext) -> Boolean = {true}) {
	val context = EveryContext(millis)

	thread {
		while (!Thread.interrupted()) {
			val elapsed = measureTimeMillis {
				if (context.run(precheck)) {
					context.run(block)
				}
			}

			val sleepMillis = context.loopTime - elapsed
			if (sleepMillis > 0)
				Thread.sleep(sleepMillis)
		}
	}
}

