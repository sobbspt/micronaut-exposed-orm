package user.repository

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Users : IntIdTable() {
    val userName  = text("user_name")
    val firstName = text("first_name")
    val lastName  = text("last_name")
}

class User(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<User>(Users)
    var userName  by Users.userName
    var firstName by Users.firstName
    var lastName  by Users.lastName
}