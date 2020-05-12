package user.config

import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Context
import io.micronaut.context.annotation.Factory
import org.jetbrains.exposed.sql.Database
import org.slf4j.LoggerFactory
import javax.inject.Singleton
import javax.sql.DataSource

@Factory
class PersistConfig(private val dataSource: DataSource) {

    companion object {
        private val LOG = LoggerFactory.getLogger(PersistConfig::class.java)
    }

    @Bean
    @Context
    fun db(): Database {
        LOG.info("DB Connected")
        return Database.connect(dataSource)
    }
}