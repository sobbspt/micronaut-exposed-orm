package book

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("book")
                .mainClass(Application.javaClass)
                .start()
    }
}
