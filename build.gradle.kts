import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.5.31"
	`java-library`
	`maven-publish`
}

version = "0.1.0"

allprojects {
	apply(plugin = "org.jetbrains.kotlin.jvm")
	
	group = "org.gamepoison"
	
	repositories {
		mavenLocal() //TODO perhaps wrong
		mavenCentral()
	}
	
	java {
		sourceCompatibility = JavaVersion.VERSION_11
		targetCompatibility = JavaVersion.VERSION_11
		
		withJavadocJar()
		withSourcesJar()
	}
	
	tasks {
		compileKotlin {
			kotlinOptions.jvmTarget = "11"
		}
		compileTestKotlin {
			kotlinOptions.jvmTarget = "11"
		}
	}
}

dependencies {
	implementation(kotlin("stdlib"))
	implementation(kotlin("scripting-common"))
	implementation("io.github.classgraph:classgraph:4.8.128")
}

val mavenRootProjectArtifact = "api"

publishing {
	publications {
		create<MavenPublication>("maven") {
			artifactId = mavenRootProjectArtifact
			from(components["java"])
		}
	}
}

subprojects {
	apply(plugin = "org.gradle.maven-publish")
	
	publishing {
		publications {
			create<MavenPublication>("maven") {
				artifactId = "$mavenRootProjectArtifact-" + project.path.substring(1).replace(':', '-')
				from(components["java"])
			}
		}
	}
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
	languageVersion = "1.4"
}