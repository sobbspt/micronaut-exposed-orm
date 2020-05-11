package user.config

import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import org.jetbrains.exposed.sql.Database
import javax.inject.Singleton
import javax.sql.DataSource

@Factory
class PersistConfig(private val dataSource: DataSource) {

    @Bean
    @Singleton
    fun db(): Database {
        println("DB Connected")
        return Database.connect(dataSource)
    }
}