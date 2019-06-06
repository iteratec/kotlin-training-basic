package de.iteratec.kotlin_training_playground

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import javafx.stage.Stage
import kotlinx.coroutines.*


suspend fun helloWorld() = coroutineScope {
    launch {
        delay(1000)
        println("Kotlin Coroutines World!")
    }
    println("Hello")
}


suspend fun takeThisJava() = coroutineScope {
    repeat(1_000_000) {
        // launch a lot of coroutines
        launch {
            delay(1000L)
            print(".")
        }
    }
}

class HelloJavaFX : Application() {

    override fun start(primaryStage: Stage) {
        primaryStage.apply {
            val label = Label("Say 'Hello World'")
            scene = Scene(VBox(label)).apply {
                stylesheets.add(getResourceUri("/javafx.css"))
            }
            show()

            GlobalScope.launch(Dispatchers.Main) {
                delay(1000)

                label.text = "This"
                delay(1000)

                label.text = "is"
                delay(1000)

                label.text = "Kotlin!"
            }

//            Thread {
//                Thread.sleep(1000)
//
//                label.text = "This"
//                Thread.sleep(1000)
//
//                label.text = "is"
//                Thread.sleep(1000)
//
//                label.text = "Thread!"
//            }.start()
        }
    }

}

private fun getResourceUri(resourceName: String): String =
    object {}.javaClass.getResource(resourceName).toExternalForm()


fun main() {
    runBlocking {
        helloWorld()
        // takeThisJava()
    }
//    Application.launch(HelloJavaFX::class.java)
}
