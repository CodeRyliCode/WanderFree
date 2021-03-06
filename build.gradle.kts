
buildscript {
    repositories {
        mavenCentral()
        google()
    }

        dependencies {
            classpath("com.android.tools.build:gradle:7.1.2")
            classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")

            // NOTE: Do not place your application dependencies here; they belong
            // in the individual module build.gradle.kts files
        }
    }

    allprojects {
        repositories {
            mavenCentral()
            google()
        }
    }

    tasks.register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }



