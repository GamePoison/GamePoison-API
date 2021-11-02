package org.gamepoison

import kotlin.script.experimental.api.ScriptCompilationConfiguration
import kotlin.script.experimental.api.defaultImports

object ScriptCompilation : ScriptCompilationConfiguration({
	defaultImports("org.gamepoison.*")
})