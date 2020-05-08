package user

import user.repository.User
import user.repository.UserRepository
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import user.model.UserResponse

@Controller
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class UserController(private val userRepository: UserRepository) {
    @Post("/users")
    fun add(@Body user: User): UserResponse {
        val a = userRepository.create(user)
        return a
    }
}