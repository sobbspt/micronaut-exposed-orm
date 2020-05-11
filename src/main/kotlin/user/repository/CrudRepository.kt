package user.repository

import user.model.User
import user.model.UserResponse

interface CrudRepository<T, K> {
    fun createTable()
    fun create(m: T): User
    fun findAll(): Iterable<T>
    fun deleteAll(): Int
}