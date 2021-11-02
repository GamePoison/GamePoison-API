package org.gamepoison

import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

inline fun every(millis: Long, crossinline block: () -> Unit) {
	thread {
		while (!Thread.interrupted()) {
			val elapsed = measureTimeMillis(block)
			val sleepMillis = millis - elapsed
			if (sleepMillis > 0)
				Thread.sleep(sleepMillis)
		}
	}
}