package user.repository

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.statements.UpdateBuilder
import org.jetbrains.exposed.sql.transactions.transaction
import user.model.UserResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class UserRepositoryImpl(@Inject val db: Database) : UserRepository {
    override fun createTable() = transaction { SchemaUtils.create(Users) }

    override fun create(user: User): UserResponse {
        var userId: EntityID<Int>? = null
        transaction {
            userId = Users.insertAndGetId(toRow(user))
        }

        return UserResponse(id = userId?.value, userName = user.userName, firstName = user.firstName, lastName = user.lastName)
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