package user.repository

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.statements.UpdateBuilder
import org.jetbrains.exposed.sql.transactions.transaction
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class UserRepositoryImpl(@Inject val db: Database) : UserRepository {
    override fun createTable() = transaction { SchemaUtils.create(Users) }

    override fun create(user: User): User {
        transaction {
            Users.insertAndGetId(toRow(user))
        }
        return user
    }

    override fun findAll(): Iterable<User> {
        TODO("Not yet implemented")
    }

    override fun deleteAll(): Int {
        TODO("Not yet implemented")
    }

    private fun toRow(u: User): Users.(UpdateBuilder<*>) -> Unit = {
        it[userName] = u.userName
        it[firstName] = u.firstName
        it[lastName] = u.lastName
    }

    private fun fromRow(r: ResultRow) =
            User(r[Users.id],
                    r[Users.userName],
                    r[Users.firstName],
                    r[Users.lastName])
}