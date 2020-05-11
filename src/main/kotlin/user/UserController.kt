package user

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import user.model.UserRequest
import user.model.UserResponse
import user.repository.UserRepository

@Controller
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class UserController(private val userRepository: UserRepository) {
    @Post("/users")
    fun add(@Body userRequest: UserRequest): UserResponse {
        val a = userRepository.create(userRequest.toDomain())
        return a
    }
}