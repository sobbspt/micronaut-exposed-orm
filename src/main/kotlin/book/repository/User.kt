package book.repository

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

class User(
        var id : EntityID<Int>?,
        var userName  : String,
        var firstName : String,
        var lastName  : String
)

object Users : IntIdTable() {
    val userName  = text("user_name")
    val firstName = text("first_name")
    val lastName  = text("last_name")
}