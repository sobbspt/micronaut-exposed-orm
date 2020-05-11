package user

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import user.model.UserRequest
import user.model.UserResponse
import user.repository.UserRepository

@Controller
class UserController(private val userRepository: UserRepository) {
    @Post("/users")
    fun add(@Body userRequest: UserRequest): UserResponse {

        return userRepository.create(userRequest.toDomain()).toResponse()
    }
}