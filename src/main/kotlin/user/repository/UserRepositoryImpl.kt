package user.repository

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.statements.UpdateBuilder
import org.jetbrains.exposed.sql.transactions.transaction
import user.model.User
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class UserRepositoryImpl() : UserRepository {
    override fun createTable() = transaction { SchemaUtils.create(Users) }

    override fun create(user: User): User {
        var userId: EntityID<Int>? = null
        transaction {
            userId = Users.insertAndGetId(toRow(user))
        }

        return User(id = userId?.value, firstName = user.firstName, lastName = user.lastName, userName = user.userName)
    }

    override fun findAll(): List<User> {
        var result: List<User> = emptyList()
        transaction {
            result = Users.selectAll().toList().map { fromRow(it) }.toList()
        }

        return result
    }

    override fun deleteAll(): Int {
        TODO("Not yet implemented")
    }

    override fun findById(id: Int): User {
        val result = transaction {
            Users.select { Users.id eq id }.firstOrNull()
        } ?: throw Exception("Resource not found")

        return fromRow(result)
    }

    private fun toRow(u: User): Users.(UpdateBuilder<*>) -> Unit = {
        it[userName] = u.userName
        it[firstName] = u.firstName
        it[lastName] = u.lastName
    }

    private fun fromRow(r: ResultRow) = User(r[Users.id].value,
                r[Users.userName],
                r[Users.firstName],
                r[Users.lastName])
}