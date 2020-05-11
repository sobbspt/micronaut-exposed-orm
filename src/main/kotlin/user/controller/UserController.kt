package user.controller

import io.micronaut.http.annotation.*
import user.model.UserRequest
import user.model.UserResponse
import user.repository.UserRepository

@Controller
class UserController(private val userRepository: UserRepository) {
    @Post("/users")
    fun add(@Body userRequest: UserRequest): UserResponse {

        return userRepository.create(userRequest.toDomain()).toResponse()
    }

    @Get("/users")
    fun fetchAll(): List<UserResponse> {

        return userRepository.findAll().map { it.toResponse() }.toList()
    }

    @Get("/users/{id}")
fun fetchAll(@QueryValue(value = "id") id: Int): UserResponse {

        return userRepository.findById(id).toResponse()
    }
}