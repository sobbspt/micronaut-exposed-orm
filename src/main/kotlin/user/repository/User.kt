package user.repository

import org.jetbrains.exposed.dao.id.IntIdTable

object Users : IntIdTable() {
    val userName = text("user_name")
    val firstName = text("first_name")
    val lastName = text("last_name")
}
