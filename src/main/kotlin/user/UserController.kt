package user

import user.repository.User
import user.repository.UserRepository
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

@Controller
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class UserController(private val userRepository: UserRepository) {
    @Post("/users")
    fun add(@Body user: User): User {
        userRepository.createTable()
        return userRepository.create(user)
    }
}