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
    fun toDomain(): UserDomain {
        return UserDomain(id = null, firstName = this.firstName, lastName = this.lastName, userName = this.userName)
    }
}

data class UserDomain(
        val id: Int?,
        val userName: String,
        val firstName: String,
        val lastName: String
)