package user.model

data class UserResponse(
        val id: Int?,
        val userName: String,
        val firstName: String,
        val lastName: String
)

data class UserRequest(
        val userName: String,
        val firstName: String,
        val lastName: String
) {
    fun toDomain(): User {
        return User(id = null, firstName = this.firstName, lastName = this.lastName, userName = this.userName)
    }
}

data class User(
        val id: Int?,
        val userName: String,
        val firstName: String,
        val lastName: String
) {
    fun toResponse(): UserResponse {
        return UserResponse(id = this.id, firstName = this.firstName, lastName = this.lastName, userName = this.userName)
    }
}