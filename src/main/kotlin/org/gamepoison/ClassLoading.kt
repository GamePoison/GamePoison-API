package org.gamepoison

import io.github.classgraph.ClassGraph
import kotlin.reflect.KClass

object ClassLoading {
	
	fun <T> load(baseClass: Class<out T>, loadClass: Class<out T>.() -> Unit) {
		ClassGraph().enableClassInfo().scan().use { scanResult ->
			val classList =
				if (baseClass.isInterface)
					scanResult.getClassesImplementing(baseClass)
				else scanResult.getSubclasses(baseClass)
			classList.forEach {
				val loadedClass = it.loadClass(baseClass)
				loadedClass.loadClass()
			}
		}
	}
	
	fun <T : Any> load(baseClass: KClass<out T>, loadClass: KClass<out T>.() -> Unit) =
		load(baseClass.java) { kotlin.loadClass() }
	
}