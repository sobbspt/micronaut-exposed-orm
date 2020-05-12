package user.controller

import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.*
import user.model.UserRequest
import user.model.UserResponse
import user.repository.UserRepository

@Controller
class UserController(private val userRepository: UserRepository) {
    @Post("/users")
    fun add(@Body userRequest: UserRequest): MutableHttpResponse<UserResponse> {

        return HttpResponse.status<UserResponse>(HttpStatus.CREATED).body(userRepository.create(userRequest.toDomain()).toResponse())
    }

    @Get("/users")
    fun fetchAll(): MutableHttpResponse<List<UserResponse>> {

        return HttpResponse.status<List<UserResponse>>(HttpStatus.CREATED).body(userRepository.findAll().map { it.toResponse() }.toList())
    }

    @Get("/users/{id}")
    fun getById(@QueryValue(value = "id") id: Int): MutableHttpResponse<UserResponse> {

        return HttpResponse.status<UserResponse>(HttpStatus.CREATED).body(userRepository.findById(id).toResponse())
    }
}