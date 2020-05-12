package user.controller

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.kotlintest.MicronautKotlinTestExtension.getMock
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import user.model.User
import user.model.UserResponse
import user.repository.UserRepository
import user.repository.UserRepositoryImpl

@MicronautTest
class UserControllerTest(private val userRepository: UserRepository, @Client("/") private val client: RxHttpClient) : StringSpec({
    "Should return single user when get by id" {
        val mockUser = User(id = 1, userName = "user name", firstName = "first name", lastName = "last name")

        val mock = getMock(userRepository)

        every { mock.findById(any()) } returns mockUser

        val actual = client.toBlocking().retrieve(
                HttpRequest.GET<Int>("/users/1"),
                UserResponse::class.java)

        actual.id shouldBe mockUser.id
        actual.firstName shouldBe mockUser.firstName
        actual.lastName shouldBe mockUser.lastName
        actual.userName shouldBe mockUser.userName

        verify(exactly = 1) { mock.findById(any()) }
    }
}) {
    @MockBean(UserRepositoryImpl::class)
    fun userRepository(): UserRepository {
        return mockk()
    }
}